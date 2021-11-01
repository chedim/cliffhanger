# cliffhanger
Cliffhanger is a natural log processing programming language that combines classic data definition language elements with reactional and declarative programming. 

# Acknowlegments
This language was highly influenced by the following technologies:
- JavaScript
- Forth
- SAIL programming language by Appian
- RMPL (Reactive Model-based Programming Language for robotic space explorers) by MIT
- Apache Kafka
- Java streaming API

# About this document
This document intended to be a roadmap for cliffhanger development.
I plan to implement POC of cliffhanger mutation machine using memcached to store application data model.
This should allow non-distributed execution of CH applications as well as persisting application data with Couchbase.
The next step would be to implement the language as couchbase service module, which should make possible running cliffhanger applications across a cluster of nodes.

# Cliffhanger applications
Cliffhanger applications operate by consuming input streams and generating output streams. 
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
name prompt is "Enter Your name"

name is a cin text line after cout is name prompt

cout is:
  after name is set: "Hello, ${name}!"
  before this is unloaded:
    if name is set: "Bye, ${}"
    else: "Bye, anonymous"
```

Cliffhanger statements are used to define datapoints.
Statements always start at column 0 and end with two newline symbols (an empty line).

A minimal statement must contain at least a datapoint name and creates a datapoint with constant value `true`:
`z`

optional definition sections may be included in the statement to define either the datapoint value: 
`x is 20`, 
or its class:
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

### Word conjugation
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

## Definition branching
Semicolon followed by newline (':\n') can be used in definiton context to provide multiple alternative branching definitions.
Each branching definition then need to start with a whitespace offset:
```
the fibonacchi of a number is:
  if the number is 0: 0
  if the number is 1: 1
  else: (the fibonacchi of (the number - 1)) + (the fibonacchi of (the number + 2))
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
Class package name is constructed from the relative path of the file. 
The name of the file becomes the name of the class.
Classes are automatically located during runtime.
Cliffhanger classes are arranged into a directed graph that is separate from application's data graph and can be accessed using the `a` keyword.
When a class is assigned to a datapoint it inherits all associated datapoint definitions of that class.
For example, basic class `sequence` defines associated datapoint `length`, which makes all sequences have a `length` datapoint that uses the same definitions as `sequence length` associated with them.

### Basic classes
Cliffhanger supports the following basic value classes:
- digit - digits between 0 and 9
- number - signed integer numers
- fraction - an unsigned fractional number between 0 and 1
- flag - a boolean value that is either true or false
- glyph - a number that represents a Unicode glyph
- sequence - a sequence of values

### Custom classes
Every cliffhanger source file defines a custom datapoint class with the name of that file.
