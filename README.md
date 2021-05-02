# cliffhanger
Datacentric natural programming language

*Currently under development*

# Example application
`examples/fiboacci.ch`:
```
when started:
  and argument 1 is a number:
    a new console line is a number from fibbonacci with argument 1
  or else:
    error is "Please provide a number as the 1st argument"
    system exit with 1

when fibbonacci with a number:
 and the number is above 1:
  the number is (a number from fibonacchi with the number - 1) + (a number from fibonacchi with the number - 2)

```

# Syntax roadmap
Cliffhanger applications consist of data and behavior definitions that are triggered on data changes. Each CH application operates on an abstract data tree.

Applications define data behavior using when-or statements. When-or statement syntax is defined as follows:

```
when <trigger>:
  <mutations>
[or [<alternative trigger>]:
  <alternative mutations>]
[or else:
  <alternative mutations>]
```

where `<trigger>` and `<alternative trigger>` are logical conditions that may reference elements of the data tree and are re-evaluated every time  any of the referenced values are redefined.
`<mutations>` and `<alternative mutations>` is a list of mutations that should be performed on the data tree every time the corresponding trigger evaluates to true.

All definitions inside of a when-or block and its nested blocks are processed as a single atomic operation and triggers on modified by when-or blocks mutation are not processed until all mutations are processed:

```
when started:
  value is 0
  value is 1

when value is 0:
  a new console line is "This when-or block mutation will never be triggerd"

when value is 1:
  a new cosole line is "Only this mutation will be triggered!"
```

## Tree traversal
Any identifier (that is, not a keyword or a literal) or integer literal used in either trigger condition or a mutation instructs CH to traverse the data tree down from the current node to its child with that identifier. Identifiers can be separated either with "/" or " ", for example:

`system file /etc/cliffhanger/config`

is evaluated as follows:

- at the beginning the internal tree pointer (ITP) points at the root of the data tree
- after the "system" identifier is processed, ITP is moved to point at the "system" top-level node
- after the "file" identifier is processed ITP points at the node "/system/file" (which contains the operating system's file tree)
- after the "etc" identifier is processed ITP points at the node "/system/file/etc", which corresponds to /etc directory 
- after the "cliffhanger" and "config" identifiers are processed ITP points at "/system/file/etc/cliffhanger/config", which corresponds to the file located at /etc/cliffhanger/config

Other examples: 

`network port 80`
`user name glyph 1`

## Node kinds
Nodes can be:
**  *`named` or `anonymous` -- an anonymous node has no name and, therefore cannot be addressed directly and can be only extracted from another node
* `attached` or `detached` -- a detached node has no `parent`

Each node can have one child anonymous node associated with it per type, which can be defined using anonymous `a/an` operator and referenced using `the` context reference operator or extracted using `from` operator:

```
when started:
  a digit is from system random
  a new console line is "The digit is: " + the digit
```
  

## Node types
Data tree nodes can be either one of system, standard, or user defined types. 

### Meta-nodes
Meta-nodes are special sub-nodes that are defined for every node in the data tree:
* `length` is defined as an integer node with value equal to the number of all non-meta sub-nodes of its parent node
* `size` is defined as an integer node with value equal to the number of memory bytes used to store the tree rooted at its parent node without accounting for the size of meta nodes
* `depth` is defined as an integer node with value equal to the depth of the tree rooted at its parent node
* `parent` is defined as a pointer to the parent node of its parent node.
* `weight` is defined as an integer node that is used by comparison operators
* `delegate` is defined as an array of nodes that are used by Cliffhanger to delegate references to missing in the parent node sub-nodes

Meta-nodes cannot contain children nodes. Although meta-nodes are named nodes, they behave as anonymous nodes as they cannot be referenced directly and can only be extracted using the `of` operator.

Examples:
`length of user name` `parent of category` ...

Custom meta-nodes can be created by prefixing their definitions with `meta` keyword: `meta year is a new integer`

### System node types
Cliffhanger defines the following system types:

* `bit` -- either 0 (false) or 1 (true)
* `digit` -- an unsigned number between 0 and 9
* `integer` -- a signed integer number (with dynamically allocated size)
* `fraction` -- an unsigned real number between 0 and 1
* `glyph` -- a UTF-8 character
* `pointer` -- a node that points to another node
* `operator` -- a node that acts as an operator on other nodes
* `type` -- a node template that can be used with the `new` keyword to create sub-nodes of user-defined types

### Standard node types and type structures
* `real` -- a node with an integer and fraction anonymous subnodes
* `array` -- a node with subnodes with sequential numbers as names. Defines a custom meta node `type` that references type of elements in the array
* `string` -- an array of glyph nodes
* `index` -- a B-tree that is automatically populated from an array. Inherits array's `type` meta-node
* `trie` -- a prefix tree that is automatically populated from an array of strings

## Trigger conditions
Trigger conditions use identifiers to observe mutations on some tree nodes. By default, any mutation of the node is observed. Observed mutations can be filtered out with logical, comparison and ownership operators

## Logical operators
and, or, not

## Comparison operators
- is -- equality comparison (in js: ==)
- is under -- less than comparison (in js: <)
- is above -- greater than comparison (in js: >)
- is not above -- less than or equals comparison
- is not under -- greater than or equals comparison

Examples:
  `when user name is "guest"`
  `when length of user name is under 5`
  `when system time is above 1619897256`
  `when attempts is not above 3`
  `when years from user age is not under 21`

## Ownership operators
with -- verifies that left operand contains nodes from the right

without -- verifies that left operand does not contain nodes from the right

Examples:
  `when user with email`
  `when registration without password`
  ...

## Type, context reference and extraction operators
The `a` operator can be used:
* togeteher with `from` operator can be used to *extract* an anonymous value from a node by its type and cast it to `type`: `a byte from network port 80`
* together with `new` and `with` operators to create a new node:
``` 
when started:
  a new user 
```
* inside of a when-or trigger together with `is` operator to check the type of a node: `when argument 1 is a number`

The `the` operator can be used to reference an anonymous value: 
```
when a new number:
  the number is 0
```
## The `a new` operator
The `a new` operator takes a system type, a type node or a node with `type` meta-field and creates a new node.
* When used on a type that does not define `type` meta-field, it returns a new detached anonymous node of that type: `a new number`.
* When used on a type that defines `type` meta-field, it requires a value for that field to be passed as an anonymous parameter using the `of` keyword: `a new array of string`
* When used on a node with `type` meta-field, it uses the value of that field to create a new node that is attached to the provided to it node: 
```
when started:
  message is a new array of string
  a new message is "Hello, World!"
```

## Parametarized triggers
When-or triggers can use the `with` keyword to accept parameters:
```
when a digit from console prompt with message as string:
  a new console text with message
  the digit is from a new console line
```

Each parametrized when-or statement operates on its own detached data tree. 

### Named and anonymous parameters
A definition may pass parameters to parametrized triggers using the `with` keyword:
```
when started with a string argument 1:
  user is a new User with:
    name as the string
```

## Nested when-or blocks
A line inside of a `when-or` block that starts with the `and` operator is evaluated as a nested when-or block:
```
when started:
  and with a string as argument 1:
    a new console line with "Hello, " + the string
    system exit with 0
  or:
    a new console error line with "Please pass your name as the first argument"
    system exit with 1
```
## Omited left operands
Any binary operator with its left operand missing will reuse the first present left operand of a preceding operator of the same type:
```
when user is online and is banned:
  ...
```
In this example the second `is` operator will reuse the `user` operand of the first `is` operator

# Cliffhanger application Structure
Cliffhanger nodes can be both defined as files and folders. Every when-or definition inside of a file will k
