# cliffhanger
Cliffhanger is a natural reactive stream processing and data definition distributed programming language. 

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
For current implementation (still a WIP) check out this repo: https://github.com/chedim/cliff-go

# About this document
This document intended to be a roadmap for cliffhanger development.
I plan to implement POC of cliffhanger mutation machine using memcached to store application data model.
This should allow non-distributed execution of CH applications as well as persisting application data with Couchbase.
The next step would be to implement the language as couchbase service module, which should make possible running cliffhanger applications across a cluster of nodes.

# Cliffhanger Environment
Cliffhanger environment is a cluster of computational nodes capable of executing cliffhanger applications using shared classification tree and data graph.
For example, a cliffhanger environment may consist of:
- A central cluster in the Cloud that provides security, monitoring and analytics
- A swarm of Edge computing clusters that process data linked to a specific location
- A swarm of mobile and desktop devices, each providing UI services for the environment users

By maintaining global classification and data graph across all these clusters, cliffhanger environments remove the boundaries between cloud, edge, frontend and backend.

## Classification Tree
Cliffhanger environment constructs its data graph around a classification tree.
Each node in the tree specifies a sub-class of its parent node.
Every class contains a set of field and label definitions that define mutation rules for instances of the class.
The classic inheritance relation exists between parent classes and their sub-classes.
For example, the node `animal` may contain a sub-node `cat`, which will inherit all rules defined on the `animal` class.
The tree can be addressed using the `a/an` keyword: `a cat`. 
The tree is traversed by `a` references in reversed direction (down from leaves to the root): `a cat animal` will address subtype `cat` of type `animal`.
External classification tree definitions can be loaded into environment from remote or local libraries.

## Entity graph
Entity graph is the part of environment data graph that is constructed from classification tree.
The graph can be addressed using `the` keyword: `the cat`
The graph is traversed by `the` referenced in forward direction (up from the root to leaves): `the cat name`
The nodes of entity graph represent data variables. 
Edges between those nodes represent data ownership: `the cat name` represents entity `name` owned by an entity classified as `a cat`

## Classification labels
Classification labels are used to create edges from entity graph to the classification tree.
Labels added using `is` operator: `the animal is a cat`.
When a label is added to the entity, that entity is added into the corresponding entity collection and is sent to collection's processing unit(s).

### Output Datapoints 
Output datapoints can be created by libraries to expose their state:
```
the current user is an output
```

# Cliffhanger applications
Cliffhanger applications represent namespaced regions of cliffhanger environment's data graph.
When an application is loaded, all unresolved classification tree references are mapped to the global environment classificatoin tree.
This allows to avoid using `import` statements in the language :)

# Mutational programming
Mutational programming is performed by describing how data should mutate and conditions that trigger those mutations.
In its purest form mutational programming is done using `when` operator that takes a condition and a set of variables and values that should be assigned to them when the condition evaluates to `true`.
This is very similar to reactional (aka event-driven) programming which uses a similar `when` operator to describe a set of instructions to execute.
Mutational programming, however, embraces declarative over imperative programming.
Cliffhanger supports mutational programming with two mechanisms -- dynamic definition switching and cascading reevaluations.

## Cascading Reevaluations
Cliffhanger applications developed around datapoints -- a special kind of variables. 
By default, datapoint values are calculated from developer-provided data definitions.
If a definition references another datapoint then the definition is said to depend on that datapoint.
Whenever a datapoint value changes all its dependant definitions as well as their dependant definitions are marked for reevaluation.
Definitions are re-evaluated lazily only when their value is requested by any of their dependant definitions.

## Static datapoints
Datapoints that are not accessed via `the` operator are considered static.
Static datapoint values are calculated immediately after the application starts and automatically reevaluated every time
their dependencies change.  

## Persisted datapoints
To persist datapoint values across application startups developers should label them as persisted, for example: 
`users are persisted`.

## Dynamic Definition Switching
Cliffhanger datapoint definitions may be enabled and disabled based on the value of an optional control datapoint.
Whenever the control datapoint evaluates to `false` the controlled definition becomes disabled and is excluded from application's data model.

# Language Overview
Striving to be an easy to read language, Cliffhanger uses terms from English language to describe provided langage elements.

## Statements
Example file -- hello.cliff:
```
hello is an application

name prompt is "Enter your name: ";
name is an input text line after name prompt is an output

output is:
  name prompt
  when name is set: "Hello, {name}!"
  before this is unloaded:
    when name is set: "Bye, {name}!"
    else: "Bye, anonymous!"
```

Cliffhanger statements are used to define datapoints.
Statements always start at column 0 and end with two newline symbols (an empty line) or the semicolon symbol after which another statement can be started on the same or the next line.

A minimal statement must contain at least a datapoint name and creates a datapoint with constant value `true`:
`z`

optional definition sections may be included in the statement to define either the datapoint value: 
`x is 20`, 
or its class/label:
`y is a number`

Each definition section may include optional condition sub-section that defines definition's control datapoint.
If no condition sub-section is provided then the definition is considered active after all other definitions fail.
To calcualte datapoiont's value, Cliffhanger always uses the first value definition section (in the order they appear in the source code) that is active and ignores other definitions without checking their control point values.
If at least one definition section is present but none of the definitions is active then the datapoint is not defined and evaluates to false.

## Words
In cliffhanger source code any set of symbols that are not whitespace, reserved keywords and literals or punctuation characters constitutes a word.
If a word with forbidden name needs to be defined then its name needs to be escaped: `event \when is a date`.
Words that include non-alphabetical symbols must be explicitly defined either in preamble or by the application as aliases for alphabetical words.
Alphabetical words don't need to be defined. 

### Word Normalization
Cliffanger automatically normalizes all words using common English language dictionary. 
Developers may extend or overwrite the default dictionary:
`publics is a plural of public`
`be is a form of is`
etc.

## Phrases
Cliffhanger uses semantic contexts to group words into phrases.
Words are collected into a phrase of corresponding to the current context type until a context changing keyword is met.
Collected phrases and their types are then used as cliffhanger definitions.

## Semantic Contexts
Cliffhanger compiler/evaluator keeps track of semantic contexts which define specific behavior for phrases.

### Naming Context
Naming context is the starting context for every statement.
Naming context phrases are treated as paths on the application's data graph.
For example, phrase `current user name` will refer to datapoint `name` associated with datapoint `user` under datapoint `current`.

### Request Context
Request context is entered into with `a`/`an` _request keyword_ from a naming context.
Request context collects a datapoint name.
A value is then requested from the datapoint with collected name and used as the datapoint definition.

### Definition context
Definition context is entered into with `is`/`are` _defining keyword_ from a naming context.

### Condition context
Condition context is entered into with `when`/`before` _condition keywords_ either from naming or definitition context and provides control point definitions.
Condition context may be exited into definition context using a semicolon.

### Related mutation context
Related mutation context is entered into with `after` _related mutation keyword_ either from naming or definition context and provides a related definition that should be applied to the application data tree _before_ the main definition is applied.

... many more contexts... maybe this is not the right term and/or way to describe them?

## Definition branching
Semicolon followed by newline (':\n') can be used in definiton context to provide multiple alternative branching definitions.
Each branching definition then need to start with a whitespace offset:

```
today is a weekend:
  when today is saturday
  when today is sunday
```

Only one value definition in a branching set can be active at a time.
If none of the definitions is active then the datapoint is undefined and evaluates to false unless it has other active definitions.

## Statement grouping
Statements that start with the same set of words can be grouped into one statement using the semicolon followed by new line:
```
user:
  name is "Alfred"
  age is 24
  email is "alfred@alfred.com"
  group:
    is a group
    name is "admins"
```

## Datapoints
Cliffhanger datapoints construct a data graph that can react to external signals.

### Datapoint Values
When a datapoint is referenced in a definition, cliffhanger machine first looks for the current datapoint value in the application context.
If requested datapoint's value hasn't been previously calculated and is absent from the context then datapoint's active definition is used to calculate it and add it into the context, after which it can be used in the definition.
When any of datapoints referenced in a definition change their value the calculated value is removed from the context, which should trigger value recalculation the next time the datapoint value is requested.

## Datapoint classes
Every cliffhanger source file corresponds to a single datapoint class.
Every datapoint class corresponds to a stream of instances of that class that can be accessed using the name of the class in its plural form.
Class package name is constructed from the relative path of the file. 
The name of the file becomes the name of the class.
Classes are automatically located and loaded during runtime using paths from `CLIFF_LIB` environment variable.
This behavior can be overridden by redefining `class` datapoint.
Cliffhanger classes are arranged into a directed graph that is separate from application's data graph and can be accessed using the `a` keyword.
When a class is assigned to a datapoint it inherits all associated datapoint definitions of that class.
For example, basic class `number` defines associated datapoint `size`, which makes all number have a `size` datapoint that (unless it was overriden for that specific object or class) uses the same definitions as `number size` associated with them.

### Basic classes
Cliffhanger supports the following basic value classes:
- digit - digits between 0 and `cliffhanger max digit` (default: 10)
- number - signed integer numers
- float - signed float numbers
- fraction - an unsigned fractional number between 0 and 1
- flag - a boolean value that is either true or false
- glyph - a number that represents a Unicode glyph
- stream - a stream of values

Digit, number, and float classes provide `size` property as their sub-datapoint. 
This property defines the allocated memory size for the value.
The default value for this property can be set by redefining `<type name> default size` datapoint.

### Custom classes
Every cliffhanger source file defines a custom datapoint class with the name of that file.
The file class can be referenced with its name, instance of the class is referenced with `a/an` keyword.
Every class automatically has access to 
All datapoints explicitly defined under the file class are public.
All datapoints defined in a source file except for datapoints defined under `static` and the name of the file are instance-scoped.
For example, example.cliff:
``` 
an example created is a number of size 4     // a public datapoint

initialized                                   // a private boolean datapoint

example goal is "to learn cliff"              // a public static datapoint

static target is "to write an app a day"      // a private static datapoint

example target is static target               // a public static alias to a private static datapoint

```

### Undefined datapoint capturing
Access to undefined sub-datapoints can be captured using special `?lookup` datapoint.
The `?query` datapoint can be used in `?lookup` datapoint definition to access the name of the requested sub-datapoint.

### Datapoint value substitution
Datapoint values can be substituted into the current context by wrapping datapoint names in figure brackets:
```
value is 20

reference is "value"

{reference} is an output // outputs '20'

```

In strings, however, the value of the named datapoint will be substituted instead:
```
"{reference}" is an output // outputs 'value'
```
```
"{{reference}}" is an output // outputs '20'
```

### Debug substitutions
`{?datapoint}` should substitute the current definition of the datapoint:
```
value is 10; "{?value}" is an output // outputs 'value is 10'
new value is 20; "{?new value + value}" is an output // outputs 'new value + value is 20'
```

## Collections and streams

### Collections
Datapoints that have multiple acive definitions can be addressed either by their singular name or by their plural name.

Singular datapoint name will address the latest active datapoint definition:
```
some value is the user
some value is a console output
// outputs the latest user name
```

Plural datapoint name will address all collection members: 
```
some values are:
  1
  2
  3
  4
  5
some values are console outputs
// outputs 1 2 3 4 5
```

### Streams
Cliffhanger streams are automatically created to satisfy streaming operations.
Streams accessed using a floating window that keeps `{a stream} window size` history of assigned to the corresponding datapoint values in the context.
The size of a particular stream window is calculated dynamically to satisfy all dependant definitions.
Dynamically calculated size cannot exceed `max windox size` datapoint value.
Requesting window size bigger than `max window size` results in an error.
Streams are referenced using plurals:
`values are random numbers`

Using stream name in its singular form with `the` keyword returns the latest value of the stream:
`the name is an output`

The current position of the stream can be referenced using the hashtag symbol with stream singular name:
`"Name number {name#} is {name}" is an output`

Values can be added onto a stream either by labeling them with stream name:
`identifier is a name when no name`

Or by filtering other streams:
```
name is the next user input after the user input is "--name " 
```

Streams can be merged with other streams using `are` keyword:
`apples are oranges`
In this example all new members of `apples` stream are also labeled as members of `oranges` stream.

Some members of a stream can be assigned to other streams as well:
`the identifier is a name when no name`

### Anchors
Streams provide `<anchor> {a stream}` datapoints, where anchors are defined as either "the first" or "the last":
These datapoints allow accessing the first and, in case of a collection, the last elements:
```
winner is the first runner

sender is the last message author
```

### Indexing
Collections can be indexed by prefixing them with an index phrase:
```
some value is the 3rd user
some value is the 30th message
some value is the last 5th message
// etc...
```

Streams can be indexed both into the future and into the past:
```
the winner is the next 3rd registered user
the winner is the last 5th online user
the winner is the last {the winning number}th banned user
``` 

When indexed into the future, recalculation of dependant datapoints is delayed until the reference can be fulfilled.
Indexing into the past defines the size of the stream window.
When window size increases, the new elements of the window are considered empty. 
Definitions that request empty window elements are deffered until there is enough elements in the window.

### Collection filtering 
Collections can be filtered using the `where` keyword:
```
registrations are users where the user is registered

jobs are tasks where current time - the task expiration > the last task recalculation time

displayed messages are the last 10 messages where folder = displayed folder
```

### Slices
Streams and collections also provide `<anchor> {a number} {a stream}` parametrized datapoint that allows to reference only a slice of the element set:
```
winners are the first 10 users

log is the last 10 outputs
```

Only slicing operations that refer to future stream elements can be delayed.
Slicing operations on underfilled buffers should return less elements than requested.

## Inheritance
Inheritance is supported by accepting labels on classes. 
Multiple inheritance is allowed.

animal.cliff:
```
an animal name is a string

an animal kind is a string

```
cat.cliff:
```
cat is an animal

a cat kind is "cat"

```

# Data integrity validations
`must [not] be` keyword can be used to enforce data integrity validations:

```
a user name length must be < 19
the user email must not be false when a user is verified
a user must be verified before it is online
```

A violation of `must` statements at any time will cause the application to print the violated statement and mutation trace to stderr and exit with errror code 1.

# Inter-library communication and FFI
Cliffhanger libraries are loaded into separate cliffhanger processes that communicate changes in their data graphs using network sockets.
This allows running cliffhanger applications using computational clusters distributed across LAN as well as the Internet.
Hosted libraries can be used to protect intellectual property as well as an API for commercial services.
Refer to FFI.md for protocol details.

# Appendix A: Standard preamble
## Outputs 
An output is a stream that can be consumed by external targets, stored in a file, or forwarded over the network.
Marking a stream as an output allows cliffhanger applications push data to external consumers.
Marking a value datapoint as an output allows cliffhanger applications expose endpoints that can be pulled by external clients.
