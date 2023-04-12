# cliffhanger
Cliffhanger is a distributed graph operation language for programming microservice swarms.

## Fibonacchi example
File `<project_root>/fibonacchi.ct` that could handle HTTP requests to `/fibonacci/<number>` paths:

```
-- usage:
-- GET /fibonacchi/10

WHEN name($FIELD) = 1:
  = 1
ELSE:
  = $(( \
      $( @ ./$(( $FIELD - 1 )) ) + \
      $( @ ./$(( $FIELD - 2 )) ) \
    )
```

# Acknowlegments
This language was highly influenced by the following technologies and cultural artifacts:
- JavaScript
- Forth
- SAIL programming language by Appian
- RMPL (Reactive Model-based Programming Language for robotic space explorers) by MIT
- SQL
- Apache Kafka
- Java streaming API
- the "Love is..." bubble gum.

# Implementation
The language is under (yet another) redesign, so no current implementations are available.

# Cliffhanger VM
Cliffhanger applications are executed using a distributed virtual machine that loads cliffhanger definitions from a file system-like data sources and executes them against a distributed object tree.

## Data Tree 
Cliffhanger VM maintains a tree of scalar values.
Tree values can be referenced by their URLs.
The default url schema and domain refer to the Data tree and supports querying using XPath:
`/user/01/username`
`/current/user/email`
`/user/*[active]`
`/user/*[groups/admin]`
...

Note: in the future, other schemas (for example, `fs:`) may support XPath as well.

### Distributed Data Trees
A Data Tree becomes distributed when a peering connection is established between two or more cliffhanger nodes.
In such a situation, the branches of the Data Tree may be assigned to different nodes.

### Global Branch
All paths located under the `/global` branch are replicated to all nodes running the Cliffhanger VM machine.

### VM Information Branch
All information about the cliffhanger VM is located under the `/global/vm` branch.

### Node Information Branch
All information about the current Cliffhanger node is located under the `/global/vm/nodes/<NODE_ID>` branch.
A reference to the current node's information branch is alvays accessible as `$NODE` variable.
Any changes under a node information branch MUST be submitted to and processed and replicated by the corresponding node.

## Trigger Layers
The VM loads every cliffhanger application into a separate trigger layer. 

## Trigger events
When a new value is written onto the Data Tree, VM will execute associated with the path of the value triggers from all loaded and active layers.
Data Tree change events are propagated both horizontally through loaded layers in reverse order of layer loading and vertically through the path of the changed value from the value to the root of the Data Tree.

## Data Triggers
Data triggers are the main building blocks of Cliffhanger applications. 
A trigger consists of an optional trigger condition and a list of mutations to be performed when the trigger is activated.
Every time the sub-tree under the address to which a trigger is attached changes, the new sub-tree value is evaluated against the trigger condition. 
When the trigger condition evaluates to a truthy value, the trigger is activated and its mutations are executed.
Inside of a layer, all triggers are activated in the direct definition order.

### Value Triggers
Value triggers are defined in `*.ct` files and attach directly to a value on the Data Tree. 
These triggers are mapped onto the Data Tree according to the path and name (excluding the extension) of the file in which they are defined.

### Trigger Conditions
Trigger conditions can be used to activate triggers depending on the state of Cliffhanger VM.
Trigger conditions are defined using `when-else when-else` statements with conditions written in XPath. 
Trigger conditions must start at the beginning of a new line and end with a new line character.
Immediately succeding trigger conditions are merged into a single trigger condition using logical `OR` operator so, the following:
```
WHEN $THIS = 1:
WHEN $THIS =-1:
  ... list of Mutations
ELSE WHEN $THIS = 0:
  ... some other Mutations
ELSE:
  .. fallback mutations
```
is equal to:
```
WHEN $THIS = (1, -1):
  ... list of Mutations
ELSE WHEN $THIS = 0:
  ... some other mutations
ELSE:
  .. fallback mutations
```

Nested triger conditions are merged with parent conditions using logical `AND` operator:
```
WHEN $THIS = 1:
  WHEN $OLD = 0:
    ... list of Mutations #1
  WHEN $OLD = -1:
    ... list of Mutations #2
```
is equal to:
```
WHEN $THIS = 1 and $OLD = 0:
  ... list of Mutations #1 
WHEN $THIS = 1 and $OLD = -1:
  ... list of Mutations #2
```

Empty conditions at any level are still merged via `OR`, so:
```
WHEN $THIS = 1:
  WHEN $OLD = 0:
  WHEN $OLD = -1:
    ... list of Mutations
```
is equal to: 
```
WHEN $THIS = 1 and ($OLD = 0 or $OLD = -1):
  ... list of Mutations
```

#### ALWAYS shorthand
```
ALWAYS:
  ...
```
expands to:
```
WHEN true:
  ...
```

### Trigger Mutations
Mutations are defined using HTTP request protocol with separation of request headers and body done via adding whitespace offset to the body lines:
```
WHEN $THIS = 1:
  POST https://example.com/example/address
  Content-Type: text/plain
    echo $(@ $THIS)
```
Every mutation definition in a mutation list must have the same whitespace prefix.
Every body line inside a mutation definition must have the same whitespace prefix.

Mutations must be separated from each other using an empty line:
```
WHEN $THIS = 1:
  POST /data/tree/path
    echo "$(@ $THIS)" | grep 'name'

  POST https://example.com/example/address
  Content-Type: text/plain
    echo "$(@ $THIS)"

  DELETE fs://some/file/path/$(@ $OLD)

  PUT fs://some/file/path/$(@ $OLD)
  attributes: a+r
      date
```

Every HTTP header definition is evaluated as a BashL string using `/bash -c echo <definiiton>`.
Body definitions are evaluated as bash scripts.

#### POST mutation short form:
POST mutations can be shorted to an assignment expression:
```
ALWAYS:
  /path = value
```
equals to:
```
ALWAYS:
  POST /path
    echo "value"
```

### Access Guards
Access Guards are executed every time a value is read from the Data Tree and defined similarly to triggers but differ from them because they define HTTP responses instead of HTTP requests:
```
WHEN not($REQUEST/header/Authorization):
  HTTP 401 Unauthorized
  X-Error-Code: no-auth-header
    echo "You are not authorized to perform this operation."
    echo "(Missing Authorization header)"
```

Access gurads can also be used to transform the response values:
```
ALWAYS:
  HTTP 200 OK
    echo "transformed value: $THIS"
```

#### 200 OK shorthand
200 OK access guards can be shortened to a no-path assignment statement:
```
ALWAYS:
  = value
```
expands to:
```
ALWAYS:
  HTTP 200 OK
    echo "value"
```

#### Redirects
Redirects are Access Guards defined using the `REDIRECT` keyword that results in either delegating the request to another path on the same node or sending `HTTP 301 Moved Permanently` response to the client.
For example,
```
ALWAYS:
  REDIRECT /info/status
```
will redirect all requests to the value located at `/info/status` address.

### Trigger Variables
The following variables are available to all triggers:
| name | description |
| - | - |
| OLD | contains a local tree reference to the old value that will be overwritten |
| THIS | contains a local tree reference to this node |
| REQUEST | contains a local tree reference to the information about the originating request |
| FIELD | contains the first element of the relative path from the trigger to the changed value |
| NODE | contains a local tree reference to the current node branch |

## Vm Peering
VM peering is the mechanism by which two cliffhanger VMs share the same Data Tree.
When a peering VM joins another (master) VM, it triggers Data Tree rebalancing operation during which some of the elements of the master VM Data Tree are transferred together with attached to them triggers and guards onto the joining VM and both master and peering VM become nodes of a distributed Cliffhanger VM.

When a node of a distributed VM is requested to perform an operation on a part of the distributed Data Tree that is assigned to another node, it will redirect the request to the appropriate node using `HTTP 301 Moved Permanently` response. 
To do so, all nodes maintain a list of mappings that is available in the Data Tree under the `/global/vm/mappings` path prefix. 

### Tree rebalancing
Tree rebalancing is performed by participating nodes transparently by reassigning tree branches based on their computational complexity.
To do this, every node calculates computational complexity for each mapped to it tree path based on:
- percentage of memory occupied by the corresponding tree branch
- percentage of CPU time spent on serving the corresponding tree branch

Node's available computational power is also calculated and periodically updated by timing a sample computational task. 
This available computational power is than stored as `/global/vm/nodes/<NODE_ID>/power` value.
This information is then used to normalize calculated computational complexity across the cluster level.
Normalized calculational complexities are then published by the node by updating the `/global/vm/mappings/<MAPPING_ID>/complexity` value.

Each peering node can be configured to maintain a specific computational power usage levels.
When a node detects that it uses too much or too little of computational power, it attempts to either shed some of its mappings or gain more of them.

### Tree mappings
Tree mappings are used by participating nodes to determine which nodes serve which part of the Data Tree.
All changes to a tree mapping must either be initiated by the mapped node or submitted onto it and replicated by the mapped node to all other nodes.
When resolving tree paths with mappings, the most specific mapping should be selected by the requesting node: a mapping of `/data/users/01` should be picked over the mapping of `/data`.


#### Mapping shedding
To shed a mapping, a node first decides which specific mapping needs to be shed:
- If only single mapping is maintained by the node, then it attempts to split it into two mappings.
  The node attempts to size one of the mappings according to the amount of computational complexity it wants to shed and then selects that mapping to be shed.
- When more than a single mapping is maintained by the node, the node sorts mappings by their complexity and then picks the first mapping that is bigger than desired complexity amount.

The picked mapping is then marked by writing "SHEDDING" into `/global/vm/mappings/<MAPPING_ID>/status` value.

#### Mapping gaining
To gain a mapping, the node selects all mappings in the "SHEDDING" status and then selects the last mapping that is smaller than the desired complexity gain.
Then it sends an HTTP POST request to the node that wants to shed the mapping that updates the `/global/vm/mappings/<MAPPING_ID>` path with the following values:
```yaml
status: MOVING
node: <GAINING_NODE_ID>
```
The request to move the mapping MUST also contain a transaction ID in the `X-Transaction` header.
The gaining node then replicates this request to all participating nodes except the gaining node and responds with `HTTP 202 Accepted` when replication succeds.
When a mapping is in the `MOVING` state, all requests to the corresponding tree branch by participating nodes MUST be deffered until the mapping changes its status to `ACTIVE`.
During this period the shedding and gaining nodes MUST respond with yaml-encoded mapping value and `503 Service Unavailable` responses to any requests to the associated with the mapping tree branch.

When the shedding node is ready to perform the transfer, it sends a multi-part HTTP POST request with the same `X-Transaction` header as in the originating transfer request.
The response body should contain yaml-encoded value of the tree branch and its trigger and guard definitions as its parts.
Upon successfuly receiving the branch value, gaining node responds with `HTTP 202 Accepted` status.

When the gaining node is ready to start serving the branch, it updates the `/global/vm/mappings/<MAPPING_ID>/status` value to `ACTIVE` and replicates this change to all other participating nodes by sending HTTP POST requests to every node.

#### Mapping Locking
System administrators may create locked mappings by setting `/global/vm/mappings/<MAPPING_ID>/locked` path to a truthy value.
Locked mappings cannot be rebalanced from the node onto which they map.
For example, the path `/current/user/phone/screen` could be locked onto the node that represents user's phone, etc.

## Internal Communication
```
TODO: describe node properties that store information about supported by the node communication methods.
IDEA: use node-generated triggers for communication?
```

## External Communication
### Sending Data to a Cliffhanger VM
A cliffhanger VM accepts external data changes as HTTP POST requests submitted to the VM Data Api port.
Request paths are mapped directly onto the Data Tree.
Bulk value updates can be prformed by submitting requests with `Content-type` of either `application/json` or `application/yaml`.

### Requesting Data from a Cliffhanger VM
VM Data Tree values can be requested using HTTP GET requests submitted to the VM Data Api port.
All data responses are yaml-formatted.

### Pushing data out of a Cliffhanger VM
The nature of the language allows to push data to external systems directly from trigger mutations:
```
ALWAYS:
  POST https://some-other-system.com/some/path
  Authentication: Bearer "$(@ /external/some-other-system/auth)"
    echo "$THIS"
```

### Subscribing to changes
An external client or peering VM may subscribe to all changes under a data tree branch by opening a websocket on corresponding to the branch path on the node to which that path belongs.
If such a request is sent to any different node, it MUST respond with a temporary redirect to the correct node.

# Related Projects and ideas

## JavaScript client library
It would be nice to have a library that can be
used to interact with Cliffhanger data tree from
the browser.

## WebGL renderer
It would be nice to have a component that allows
rendering cliffhanger data trees on an html web page.

## VR editor
It would be nice to implement an editor app
that would allow working on cliffhanger data
trees using a browser in a standalone VR headset.

## Cliffhanger nginx manager
It would be nice to have a service that would
manage local nginx configuration to provide
node-targeted paths for external clients that
can't communicate with the nodes dorectly.
