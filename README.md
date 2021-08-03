# cliffhanger
Cliffhanger is a natural model-based programming language that combines classic data definition language elements with reactional and declarative programming. 

# Acknowlegments
This language was highly influenced by the following technologies:
- JavaScript
- Forth
- SAIL programming language by Appian
- RMPL (Reactive Model-based Programming Language for robotic space explorers) by MIT
- Apache Kafka
- Java streaming API

# About this document
This document is intended to be a roadmap for cliffhanger development.
I plan to implement POC of cliffhanger mutation machine using memcached to store application data model.
This should allow non-distributed execution of CH applications as well as persisting application data with Couchbase.
The next step would be to implement the language as couchbase service, which should make possible running cliffhanger applications across a cluster of nodes.

# Mutational programming
Mutational programming is performed by describing how data should mutate and conditions that trigger those mutations.
In its purest form mutational programming is done using `when` operator that takes a condition and a set of variables and values that should be assigned to them when the condition evaluates to `true`.
This is very similar to reactional (aka event-driven) programming which uses a similar `when` operator to describe a set of instructions to execute.
Cliffhanger supports mutational programming with two mechanisms -- dynamic definition switching and cascading reevaluations.

## Cascading Reevaluations
Cliffhanger applications developed around datapoints -- a special kind of variables. 
Datapoint values are calculated from developer-provided data definitions.
If a definition references another datapoint then the definition is said to depend on that datapoint.
Whenever a datapoint value changes all its dependant definitions as well as their dependant definitions are marked for reevaluation.
The actual reevaluation of dependant definitions happens the first time they are accessed.

## Dynamic Definition Switching
Definitions can be dynamically enabled and disabled by cliffhanger machine based on their control datapoint's value.
When the datapoint evaluates to `false` the controlled definition is said to be disabled and has no effect on application data model.

# Language Overview
Striving to be an easy to read language, Cliffhanger uses terms from English language to describe provided langage elements.

## Statements
Examples:
```
z // the simplest statement just creates a datapoint that will always evaluate to true

x is 20 

y is:
- 10 when the user is not registered
- 20 otherwise

the user is registered

the letter is queued when the user clicks the send button

user messages are the last 10 messages with recipient == user

```

Cliffhanger statements are used to define datapoints.
Statements always start at column 0 and end with two newline symbols (an empty line)
A minimal statement must contain at least a datapoint name.
Optional definition section may be included in the statement to define either the datapoint value or its attributes.
Only one value definition can be active for a datapoint at a time.
Each definition section may include optional condition sub-section that defines definition's control datapoint.
If no condition sub-section is provided then the definition is considered active.
Cliffhanger always uses the first definition section that is active and ignores all the rest.
If at least one definition section is present but none of the definitions is active then the datapoint is not defined.
Referencing an undefined datapoint causes application to exit with error.
If no definition section is provided then the datapoint assigned the boolean value `true`.

## Words
In cliffhanger source code any set of symbols that are not whitespace, reserved keywords ad literals or punctuation characters constitutes a word.
Words that include non-alphabetical symbols must be explicitly defined either in preamble or by the application as aliases for alphabetical words.
Alphabetical words don't need to be defined. 

## Phrases
Cliffhanger uses semantic contexts to group words into phrases.
Words are collected into a phrase of corresponding to the current context type until a context changing keyword is met.

## Semantic Contexts
Cliffhager keeps track of semantic contexts which define specific behavior for phrases.

### Naming Context
The naming context is the starting context for every statement.
Naming context phrases are treated as paths on the application's data graph.
For example, phrase `the user name` will refer to datapoint `name` associated with datapoint `user` under datapoint `the`.
Associated datapoints


- the definition context usually entered into with `is` keyword. Collected words are then treated by this context as a datapoint definition.
- the condition context enetered into with `when` keyword. Collected words are treated as a definition for a flag datapoint that controls when the including statement is active.

## Definition branching
Semicolon followed by newline (':\n') can be used in definiton context to provide multiple alternative branching definitions.
Each branching definition then starts with a dash ('-') and ends with a newline ('\n'):
```
the fibonacchi of a numer is:
- 0 when the number is 0
- 1 when the number is 1
- (the fibonacchi of (the number - 1)) + (the fibonacchi of (the number + 2)) otherwise
```

Only one branching definition can be active at a time.
If none of the definitions is active then the datapoint is undefined and evaluates to false.

## Datapoints
Datapoints are scalar variables with values calculated at the time of use.
The type of a datapoint is always defined by the type of its value.
Cliffhanger supports the following basic value types:
- digit - digits between 0 and 9
- number - signed integer numers
- fraction - an unsigned fractional number between 0 and 1
- flag - a boolean value that is either true or false
- glyph - a number that represents a Unicode glyph
Cliffhanger provides pre-defined nouns for every basic type.

## Datapoint Values
When a datapoint is referenced in a definition, cliffhanger machine first looks for the current datapoint value in the application context.
If requested datapoint's value hasn't been previously calculated and is absent from the context then datapoint's active definition is used to calculate it and add it into the context, after which it can be used in the definition.
When any of datapoints referenced in a definition change their value the calculated value is removed from the context, which should trigger value recalculation the next time the datapoint value is requested.

## Datapoint name syntax
Datapoint name syntax is used by cliffhanger to organize datapoints into application data graph.
Cliffhanger compiler uses a vocabulary of English words
This means that cliffhanger deducts additional information about each word in a name, like:
- which part of speech this word is
- which form of the word was used

These deductions are used to associate differnt meanings to the same word in different contexts.
For example, phrases `the user`, `a user`, `user` and `users` all refer to different forms of referencing datapoints associated with the idiom named `user`.

### Nouns
Nouns in datapoint na

## Noun plurals
A plural of a noun refers to some or all values referenced by the noun during the whole lifecycle of the application.
For example, plural `users` refers to all users ever processed by the appliation because they are referenced using the noun `user`.
Whenever the noun of a plural references a new value, that value is added into the plural form.
Plurals can be used in new noun definitions, where some of their values can be filtered out to create subsets of plural.
For example, we could create a subset of adult users who can order alcohol like this: 
Cliffhanger compiler or evaluator supports automatic detection of plural forms for the most words of English language using a noun form dictionary.
Developers, however, always can define or even re-define plural forms of a noun: `days is plural of day`

## Noun abstraction
So far we reviewed only concrete nouns.
Abstract nouns can be used as pointers to every single datapoint that was, is, or will be referenced by the corresponding concrete nouns. 

## Noun articles
Noun names can refer either to itself as a type of data or to the value that is currently associated with this noun. 
Articles can be used to distinguish these two use cases:
- nouns used with either `a` or `an` article refer to the noun itself
- nouns used with `the` article refer to the value of the noun in the current context

## Noun scopes
By default, an noun defined in a cliffhanger source file is visible inside of that file and any files located directly under the directory with the name of that file.
For example, nouns defined in a file `Application.ch` will be visible in `Application/Part.ch` but not in `OtherPart.ch` or `OtherPart/AnotherPart.ch`.
An noun can be declared public by putting its name into brackets: `{the secret} is 'public'`.
A public noun definition can be imported by using square brackets around its name: `public secret is {the secret}`

## Attached nouns
Nouns can be attached to other nouns using 'of' and 'with' operators.
In addition to these operators, a space-delimeted notation may also be used to access attached values:
```
an apple is with:
  a color is an {rgb color}             // brackets as a definition -- import public noun
  a size is either:
    - small
    - medium
,    - large

// brackets in the name -- export this state noun as public
{the apple looks ok} when:
  - the color of the apple is red       // of in a when block returns the value of the attached noun
  - the size of the apple is large      // the 'the' article indicates that we are referring to 'the current' apple,
                                        // in most cases - the latest defined one

// attaches another noun to apples
an age of an apple is a {time interval}

// another public state noun
// note the space-delimeted alternative to "... when the age of the apple ..."
{the apple too old} when the apple age > `a week`
```

## States
The "when" keyword can be used to enable definitions only if the application is in a specific state:
```
the time of the day is day when current hour > 8 and current hour < 20
the time of the day is night when current hour < 9 and current hour > 19
```

## Alternative definitions
A set of alternative definitions can be specified using the 'either' block:

```
the time of day is:
  - day when current hour > 8 and current hour < 20
  - night otherwise
```

## External definitions
Any missing in the file definition is treated as external.
Cliffhanger resolves external definitions by looking in these places:
* Adjacent `*.ch` file with the name of missing definition
* An executable with the name of missing definition. It is assumed that the executable accepts yaml-encoded parent object in its stdin and outputs encoded in yaml result of computing the corresponding property. (note: the executable should be shipped in the same package with the app)
* A file with the name of missing definition. The file will be loaded as uint8s.
* A folder with the name of missing definition. All files inside that folder will be treated as parts of the definition. Files that start with digits will be streamed as values.
* URLs configured in `$CLIFF_PATHS`

## Plurals
Plurals are the glue of a cliff application.
Plurals act as streams that, by default, capture all assigned to the noun value.

```
arguments are process arguments
```

## Frames
Frames are created using the 'is the last <size> <source>' definition:


# Data types
## Automatic type casting
CH should provide fully automatic type casting. It should be done by following a chain of type conversions using defined properties.
  
