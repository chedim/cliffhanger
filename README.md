# cliffhanger
Cliffhanger is a natural stream processing programming language that combines classic data definition language elements with reactional and declarative programming. 

# Acknowlegments
This language was highly influenced by the following technologies and cultural artifacts:
- JavaScript
- Forth
- SAIL programming language by Appian
- RMPL (Reactive Model-based Programming Language for robotic space explorers) by MIT
- Apache Kafka
- Java streaming API
- the "Love is..." bubble gum.

# About this document
This document intended to be a roadmap for cliffhanger development.
I plan to implement POC of cliffhanger mutation machine using memcached to store application data model.
This should allow non-distributed execution of CH applications as well as persisting application data with Couchbase.
The next step would be to implement the language as couchbase service module, which should make possible running cliffhanger applications across a cluster of nodes.

# Cliffhanger applications
Cliffhanger applications operate by consuming input streams and exposing processed data for further consumption.
Read from streams data is stored by the application in its data graph using datapoints.

# Mutational programming
Mutational programming is performed by describing how data should mutate and conditions that trigger those mutations.
In its purest form mutational programming is done using `when` operator that takes a condition and a set of variables and values that should be assigned to them when the condition evaluates to `true`.
This is very similar to reactional (aka event-driven) programming which uses a similar `when` operator to describe a set of instructions to execute.
Mutational programming, however, embraces declarative over imperative programming.
Cliffhanger supports mutational programming with two mechanisms -- dynamic definition switching and cascading reevaluations.

## Cascading Reevaluations
Cliffhanger applications developed around datapoints -- a special kind of variables. 
Datapoint values are calculated from developer-provided data definitions.
If a definition references another datapoint then the definition is said to depend on that datapoint.
Whenever a datapoint value changes all its dependant definitions as well as their dependant definitions are marked for reevaluation.
Definitions are re-evaluated lazily only when their value is requested by any of their dependant definitions.

## Dynamic Definition Switching
Cliffhanger datapoint definitions may be enabled and disabled based on the value of an optional control datapoint.
Whenever the control datapoint evaluates to `false` the controlled definition becomes disabled and is excluded from application's data model.

# Language Overview
Striving to be an easy to read language, Cliffhanger uses terms from English language to describe provided langage elements.

## Statements
Example:
```
today is tuesday; user is logged in

stdin is an input glyph stream

stdout is an output glyph stream

name prompt is "Enter Your name"

name is a text line from stdin after name prompt is in stdout

stdout is:
  name prompt
  after name is set: "Hello, {name}!"
  before this is unloaded:
    if name is set: "Bye, {name}"
    else: "Bye, anonymous"
```

Cliffhanger statements are used to define datapoints.
Statements always start at column 0 and end with two newline symbols (an empty line) or the semicolon symbol.

A minimal statement must contain at least a datapoint name and creates a datapoint with constant value `true`:
`z`

optional definition sections may be included in the statement to define either the datapoint value: 
`x is 20`, 
or its class/label:
`y is a number`
Only one value definition can be active for a datapoint at a time.

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
Condition context is entered into with `if`/`before`/`after` _condition keywords_ either from naming or definitition context and provides control point definitions.
Condition context may be exited into definition context using a semicolon.

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

stdout is {reference} // outputs '20'

```

In strings, however, the value of the named datapoint will be substituted instead:
```
stdout is "{reference}" // outputs 'value'
```
```
stdout is "{{reference}}" // outputs '20'
```

### Debug substitutions
`{?datapoint}` should substitute the current definition of the datapoint:
```
value is 10; stdout is "{?value}" // outputs 'value is 10'
new value is 20; stdout is "{?new value + value}" // outputs 'new value + value is 20'
```

### Datapoint arguments
Referencing a class in datapoint name allows to create datapoints that accept arguments.
Substituted value can then be used in datapoint definition with `the` keyword:
```
fibonacchi of a number is:
  0 when the number is 0
  1 when the number is 1
  fibonacchi of (the number - 1) + fibonacchi of (the number - 2)
```
Parametrized datapoints can then be used in combination with parameters as regular datapoints:
```
stdout is "{?fibonacchi of 4}"  // outputs 'fibonacchi of 4 is 3'
```

## Streams
Cliffhanger streams represet an ordered set of values.
Streams can be labeled as closed,in that case the stream acts as a collection.
Opened streams are considered to be of an infinite size.
Opened streams accessed using a floating window that keeps `{a stream} window size` items in the context.
Default window size is stored as `default window size` and equals to 10 elements.
Streams must always be referenced using plurals:
`names are strings`
Each stream value can be addressed by its position using the hash symbol:
`stdout is name#3`
`index is 10; stdout is name#{index}`
Using stream name in its singular form with `the` keyword returns the current value of the stream:
`stdout is the name`
The current position of the stream can be referenced using the hashtag symbol with stream singular name:
`stdout is "Name number {name#} is {name}"`
Values can be added onto a stream either by labeling them with stream name:
`identifier is a name when no name`
Streams can be merged with other streams using `are` keyword:
`apples are oranges`
Some members of a stream can be assigned to other streams as well:
`the identifier is a name when no name`

### Anchors
Streams provide `<anchor> {a stream}` datapoints, where anchors are defined as either "the first" or "the last":
These datapoints allow accessing the first and, in case of a closed stream, the last element of the stream:
```
winner is the first runner

sender is the last message author
```

### Slices
Streams also provide `<anchor> {a number} {a stream}` parametrized datapoint that allows to slice the stream:
```
winners are the first 10 users

log is the last 10 stdout
```

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

# TDD
Test driven developent in cliffhanger can be done with `must be/must not be` keywords:

```
a user name length must be < 19
a user email must not be false when user is verified
a user must be verified before user is online
```

A violation of `must` statements at any time will cause the application to print the violated statement and mutation trace to stderr and exit with errror code 1.
