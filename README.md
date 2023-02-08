# cliffhanger
Cliffhanger is a natural reactive language for programming over a mesh of http services optionally linked into a self-rebalancing clusters that maintain distributed data trees. 

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
Cliffhanger VM maintains a ditributed tree of scalar values.
Tree values can be referenced by their paths using forward slash as path separator:
`/users/01/login`
`/current/user/email`
...

### Distributed Data Trees
A Data Tree becomes distributed when a peering connection is established between two or more cliffhanger nodes.
In such a situation, the branches of the Data Tree may be assigned to different nodes.

### Global Branch
All paths located under the `/global` branch are replicated to all nodes running the Cliffhanger VM machine.

### VM Information Branch
All information about the cliffhanger VM is located under the `/global/vm` branch.

### Node Information Branch
All information about the current Cliffhanger node is located under the `/global/vm/nodes/<NODE_ID>` branch.
The id of the current node is available to triggers as `$NODE_ID` environment variable.

## Trigger Layers
The VM loads every cliffhanger application into a separate trigger layer. 

## Trigger events
When a new value is written onto the Data Tree, VM will execute associated with the path of the value triggers from all loaded and active layers.
Data Tree change events are propagated both horizontally through loaded layers in reverse order of layer loading and vertically through the path of the changed value from the value to the root of the Data Tree.

## Data Triggers
Data triggers are the main building block of Cliffhanger applications. 
A trigger consists of an optional trigger condition and a list of mutations to be performed when the trigger is activated.
Every time the value to which a trigger is attached changes, the new value is evalueted against the trigger condition. 
When the trigger condition evaluates to a truthy value, the trigger is activated and its mutations are executed.
Inside of a layer, all triggers are activated in the direct definition order.

### Value Triggers
Value triggers are defined in `*.ct` files and attach directly to a value on the Data Tree. 
These triggers are mapped onto the Data Tree according to the path of the file in which they are defined.

### Tree Triggers
Tree Triggers are defined in files named `__.ct`.
They attach to Data Tree paths according to the path to the folder in which they are defined and are evaluated for all changes that happen under that path.

### Trigger Conditions
Trigger conditions can be used to activate triggers depending on the state of Cliffhanger VM.
Trigger conditions are defined using `when <condition>:` statements that must start at the beginning of a new line and end with a new line character.
Immediately succeding trigger conditions are merged into a single trigger condition using logical `OR` operator so, the following:
```
WHEN [ "$NEW" -eq 1 ]:
WHEN [ "$NEW" -eq -1 ]:
  ... list of Mutations
```
is equal to:
```
WHEN [ "$NEW" -eq 1 ] || [ "$NEW" -eq -1 ]:
  ... list of Mutations
```

Nested triger conditions are merged with parent conditions using logical `AND` operator:
```
WHEN [ "$NEW" -eq 1 ]:
  WHEN [ "$OLD" -eq 0 ]:
    ... list of Mutations #1
  WHEN [ "$OLD" -eq -1 ]:
    ... list of Mutations #2
```
is equal to:
```
WHEN [ "$NEW" -eq 1 ] && [ "$OLD" -eq 0 ]:
  ... list of Mutations #1 
WHEN [ "$NEW" -eq 1 ] && [ "$OLD" -eq -1 ]:
  ... list of Mutations #2
```
Empty conditions at any level are still merged via `OR`, so:
```
WHEN [ "$NEW" -eq 1 ]:
  WHEN [ "$OLD" -eq 0 ]:
  WHEN [ "$OLD" -eq -1 ]:
    ... list of Mutations
```
is equal to: 
```
WHEN [ "$NEW" -eq 1 ] && ( [ "$OLD" -eq 0 ] || [ "$OLD" -eq -1 ]):
  ... list of Mutations
```

### Trigger Mutations
Mutations are defined using HTTP request protocol with separation of request headers and body done via adding whitespace offset to the body lines:
```
WHEN [ "$NEW" -eq 1 ]:
  POST https://example.com/example/address
  Content-Type: text/plain
    echo "$NEW"
```
Every mutation definition in a mutation list must have the same whitespace prefix.
Every body line inside a mutation definition must have the same whitespace prefix.

Mutations must be separated from each other using an empty line:
```
WHEN [ "$NEW" -eq 1 ]:
  POST /data/tree/path
    echo "$NEW" | grep 'name'

  POST https://example.com/example/address
  Content-Type: text/plain
    echo "$NEW"

  DELETE fs://some/file/path/${OLD}

  PUT s3://bucket/path
    date
```

Every HTTP header definition is evaluated as a BashL string using `/bash -c echo <definiiton>`.
Body definitions are evaluated as bash scripts.

### Access Guards
Access Guards are executed every time a value is read from the Data Tree and defined similarly to triggers but differ from them because they define HTTP responses instead of HTTP requests:
```
WHEN [ -z "${HEADERS[Authorization]}" ]:
  HTTP 401 Unauthorized
    echo "You are not authorized to perform this operation."
    echo "(Missing Authorization header)"
```

Access gurads can also be used to transform the response values:
```
WHEN true:
  HTTP 200 OK
    echo "transformed value: $NEW"
```

#### Redirects
Redirects are Access Guards defined using the `REDIRECT` keyword that results in either delegating the request to another path on the same node or sending `HTTP 301 Moved Permanently` response to the client.
For example,
```
WHEN true:
  REDIRECT /info/status
```
will redirect all requests to the value located at `/info/status` address.

### Trigger Variables
The following variables are available to all triggers:
| name | description |
| - | - |
| NEW | contains the value to be written onto the Data Tree |
| OLD | contains the previous value that will be overridden by this update |
| METHOD | contains the method used to submit the new value |
| URL | contains the path to the value to be changed |
| HEADERS | array of headers submitted with the request |
| FIELD | contains the first element of the relative path from the trigger to the changed value |

### Querying the Data Tree
Trigger scripts can query the data tree by invoking the `@` function with the path of requested value as its argument.
Truthiness of a value can be checked using the `@+` function:
Examples:
```
WHEN [ "$(@ /system/online)" -eq 1 ]:
  ...

WHEN @+ https://example.com/some/flag:
  ...
```

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
WHEN true:
  POST https://some-other-system.com/some/path
  Authentication: Bearer "$(@ /external/some-other-system/auth)"
    echo "$NEW"
```
