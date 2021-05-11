# cliffhanger
Datacentric natural microservice programming language

*Currently under development*

I called it datacentric because it describes when and how your data mutates instead of what a robot should do, because that is how computers work. 

I made it natural because I wanted it to be readable so it is easy to troubleshoot, support and learn. 

I called it microservice programming language because any part of cliffhanger application's data tree can be run as a stand-alone http service that is called by the rest of the application.

I think that it is great for cloud because it will come with a built-in database (cliffdb, I hope to work on it in parallel), autoscaling and autobalancing of data tree nodes across a cluster. 
Combining this all with a powerful http-compliant (REST) api that uses a URL graph addressing language that works better with http(s) caching layers than grapql will make the idea-to-prototype and prototype-to-production time for cliffhanger projects to be less than the same metric for other languages (that is, of course, after a stable version of CH).

## Type system
Cliffhanger has a unique type system that is based on these basic types:
* A statement is analogous to the classic boolean type
* A digit is a digit between 0 and 9
* A character is a UTF-8 character
* A reference is an object that refers to another object
* A set is a group of elements that satisfy the set criteria and have same properties.

## Mutation events
Every change in application data is treated by cliffhanger as a mutation event that propagates through application's reference tree. Cliffhanger applications operate only_ by definig handlers for such mutations which can mutate the data even further. 

### References
Cliffhanger makes extensive use of references to address different objects. Before it can be used, a reference must be defined using the `<reference> is <reference>` construct, for example the reference to the current input character from the default stream can be defined like this:

`value is 'd'`

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
References to non-existing nodes evaluate to void. A void reference inside of a triggered action is handled by setting `cliffhanger error` to an member of `void reference` set.

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
A value can be assigned to a set by using `is a` operator construct, for example: `the input character is a digit`. After the example is executed the object referenced by `the input character` at the moment of execution becomes a member of the digit set.

#### Defining a new set
Defining a new set can be done using when-then construct, for example:
```
//   |-> trigger statement
when the input character is a digit:
  the input starts a number;                        // trigger action
  and the previous input is '-':                    // embedded trigger statement
    the previous input starts a negative number.    // trigger action for the embedded trigger 
```
In this example we used `when` operator that, in its simplest form, accepts a trigger statement and a trigger action. This example also makes use of extended argument lookup to join two trigger words with the `and` logical operator, meaning that additional trigger statement will be evaluated if and only if the main trigger statement is true. The extended argument lookup rules will be described later in this document.

Trigger statements work very similar to event handlers in the sense that they are re-evaluated every time any of the used in the statement values changes and, if trigger statement is evaluated to be true then the trigger action is executed.

So, in classic terms, this example:
- creates an event handler
- subscribes the event handler to receive mutations on reference `the input character` 
- upon receiving a mutation event the handler evaluates its trigger statement and,
- if the trigger statement evaluates to truth then the handler executes its action and
- then this operation is repeated for the embedded trigger statement

The `<reference> starts a <noun>` construct is called a noun start statement and is the most important part of this example as it instructs cliffhanger computer to change the behavior of the reference so that any object (including the start object) that it references is treated as a part of the noun up until this behavior is cancelled with a noun stop statement that looks like `<reference> stops a <noun>` and has the same values used both for `<reference>` and `<noun>`.

When a noun stop statement is executed all values that were referenced by statement's `<reference>` since the corresponding start statement was executed are grouped together into a single object and added into the noun set. 

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
