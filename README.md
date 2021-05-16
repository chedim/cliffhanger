# cliffhanger
Datacentric natural microservice programming language

*Currently under development*

I called it datacentric because it describes when and how your data mutates instead of what a robot should do, because that is how computers work. 

I made it natural because I wanted it to be readable so it is easy to troubleshoot, support and learn. 

I called it microservice programming language because any part of cliffhanger application's data tree can be run as a stand-alone http service that is called by the rest of the application.

I think that it is great for cloud because it will come with a built-in database (cliffdb, I hope to work on it in parallel), autoscaling and autobalancing of data tree nodes across a cluster. 
Combining this all with a powerful http-compliant (REST) api that uses a URL graph addressing language that works better with http(s) caching layers than grapql will make the idea-to-prototype and prototype-to-production time for cliffhanger projects to be less than the same metric for other languages (that is, of course, after a stable version of CH).

## General Principles

A cliffhanger application operates on application data graph by defining its mutation rules and external connections.
The data graph consists of nodes and leafs. 
Both nodes and leafs react to being changed by executing developer-defined statements that either check the validity of assigned to them data or define further recalculations that should be performed on the tree. 
A change in the state of application's data graph is called a mutation. 
Statements that should be executed after a mutation are called mutation rules.

### State Machine
Cliffhanger applications are executed using a state machine that applies mutations to application's data graph in the order defined by mutation queue.
When started, cliffhanger state machine is initialized by adding initial mutation on application's root node that sets that node to the application graph that is defined by application's structure.
The application may define some mutation rules that should be executed upon initial mutation.
Some of such rules may result in additional mutation on the data graph, called cascading mutations and initial mutation is then referred as the parent reaction of these mutations.
Cliffhanger state machine processes cascading mutations by adding them to the end of the mutation queue.
When all defined by application mutation rules are processed, state machine marks initial mutation as applied.
After a mutation is applied, state machine continues by processing the next queued mutation.
If the queue is empty then mutation machine starts waiting for external mutation events that may be triggered by client applications.
Cliffhanger state machine stops its execution either upon an error or after applications root node is void.

### Cliffhanger application structure
Cliffhanger uses directories to define application data nodes and files to define mutation rules and leafs.
Mutation rules for a node are defined in `node.cl` file in the directory that corresponds to the node.
Any other `*.cl` files inside a node directory define leafs  

#### Node description files
Node description files define mutation rules for a node of application's data graph. The path from application root directory to the node file defines the path of the node described by that file, for example to describe mutation rules for data that is written to the node "user name", node description file should be named "./user/name.cl"

#### Leaf Types
The name of a node description file

Each leaf of application's data graph can hold information of one of the following types:
- a flag can be either set or not
- an integer can hold any integer value
- a fraction can hold any fraction between and including 0 and 1
- a glyph represents a UTF-16 character
- a set represents a group of values indexed by an integer

#### Client applications
An application may connect another application and become its client by mapping a node of its data graph to the root node of the target application.
In such a case the mapped application is started in its own state machine (or existing state machine is connected if the mapped application is already running).
All mutations to the mapped graph made by the mapping application are marked as external and belonging to that application.
External mutations trigger only internal and added by the mapping application mutation rules.
Mutations that cascade from external mutation inherit that property from their parent mutation.
Any mutation rules defined by the mapping application on the mapped application graph apply only to mutations that belong to that application or were marked as global by the included application.

## Cliffnode syntax
Mutation rules are defined using `when` statements, which are defined as:

```
WhenStatement <- "when" Spacing+ TriggerStatement Spacing+ ":" Spacing+ "\n" MutationBlock  
```

Example `node.cl` of the "chedim.com/examples/sum" application:
```
application chedim.com/examples/sum

when node is not void:
  node argument a must be a number
  node argument b must be a number
  node result is node argument a plus node argument b
```

In this example we created a simple cliffhanger application that describes a node that can be used in another application to calculate sum of two numbers like this:

Example `node.cl` of the "chedim.com/examples/sum_client_" client application:
```
application chedim.com/examples/sum__client

when node is not void:
  node sum maps to sum.chedim.com and
    node sum argument a is 2 and
    node sum argument b is 3
  node out maps to console.local

when node sum result:
  node out is node sum result
  node is void
```


### References
Cliffhanger makes extensive use of references to address nodes and leafs. Any word that is not 

After this statement is executed, `value` becomes a reference to the value 'd'.

The same construct can be used to redefine the reference so that it points to a different value:

`value is 'c'`

Any unrecognized and unquoted set of alphabetic characters that is separated from other character set by at least one non-alphabetic character is concidered by Cliffhanger as a reference. 

#### Reference tree
Cliffhanger applications work with data by reacting to changes that happen on their reference tree. References in the source code of the application are used to address nodes on the tree by chaining references. A set of chained references forms a path on the tree.

For example, `current input character` chained reference corresponds to the following XPath: `/current/input/character`. Chained references always start from the root of the reference tree and each next reference in the chain advances a pointer on that tree to a corresponding to the reference child of a node prevuiosly referenced by the pointer.

After a reference is resolved to a pointer, that pointer can be operated upon by cliffhanger operators.

#### Abstract references
Using the `a` or `an` article in front of a reference makes it an abstract reference. Abstract references can be used to capture anonymous instances of set members: `a number`, `a word` into an anonymous set instance reference. After an abstract reference is captured it can later be referenced again using `the` article, for example:

```
when a number and the number is positive:
  ...
```

Anonymous set instance references are always prefixed with `the` article and always point to the latest captured by an abstract reference object.

#### Standard references
- the `void` reference can be used to invalidate another reference: `the current input character is void`
- the `it` reference always points to the last used reference: `when a number is above 10 and it is odd:`
- the `current`, `last` and `next` references can be used in stream data processing to refer to elements of the stream: `the current character`
- the `cliffhanger` reference points at the current state of the cliffhanger runtime.

For more details on standard references please refer to the documentation on standard reference tree.

#### Void references
References to non-existing nodes evaluate to void. A void reference inside of a triggered action is handled by setting `cliffhanger error` to a member of `void reference` set.

#### Reference resolution
References that target other references are transparently and recursively dereferenced when a value is requested from them unless they were explicitly checked to be a reference in the trigger condition:

`when current value is a reference:`


### Errors and error handling
Cliffhanger provides 2 different mechanisms for error handling -- supressive and aggressive. Suppressive error handling allows applications filter out data that otherwise may cause an error by declaring rules that incoming data must obey. If incoming data does not obey those rules, it is ignored. The `should be` construct is used to perform suppressive data validation:

```
when a number:
  the number should be under 5
```

Void reference and other system or user defined strict data validations result in critical erros that require the application to handle them more aggressively by defining a handler on `cliffhanger error` subtree. Such a handler may resolve the error by voiding it:

```
when cliffhanger error is a void reference:
  and the void reference is current user:
    the void reference is user 1
  cliffhanger error reference is void
```

Strict data validations can be defined using the `must be` construct:

```
when a number:
  the number must be under 5
```

### Sets
Cliffhanger sets are a more universal replacement for classes of OOP. 

Every cliffhanger value can belong to multiple sets while references can belong only to one set at a time. 

References cannot reference objects that don't belong to their sets. For example, a reference that belongs to the set of integers cannot reference a string value because it does not belong to the integer set. 

#### Standard sets
The standard library for Cliffhanger should contain definitions for the following sets:
* Natural numbers
* Integer numbers
* Real numbers
* Irrational numbers
* Complex numbers
* Words
* Parts of speech

#### Assigning a value to a set
A value can be assigned to a set by using `is a` operator construct, for example: `the input character is a digit`. After the example is executed the object referenced by `the input character` at the moment of execution becomes a member of the digit set. If the set did not exist before the first member is assigned to it then it is created automatically.

#### Set member triggers
Set member triggers can be used to execute additional statements on new members of the set before they are added to the set. For example thistrigger states that only digits that are less than `5` can be added to the set.

```
when a digit:
  it must be below 5
```

#### Set membership validation
The `is a` construct can be used in trigger conditions to validate that a value belongs to a set:

```
when cliffhanger error is a void reference:
  ...
```

### Operators
Besides the reference tree, cliffhanger maintains
