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

### References and the reference heap
Cliffhanger makes extensive use of references to address different objects. Before it can be used, a reference must be defined using the `<reference> is <reference>` construct, for example the reference to the current input character from the default stream can be defined like this:

`the current input character is 'd'`




### Sets

#### Standard sets
The standard library for Cliffhanger should contain definitions for the following sets:
* Natural numbers
* Integer numbers
* Real numbers
* Irrational numbers
* Complex numbers
* Words
* Parts of speech

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

Trigger statements work very similar to event handlers in the sense that they are re-evaluated every time any of the used in the statement value changes and, if trigger statement is evaluated to be true then the trigger action is executed.

So, in classic terms, this example:
- creates an event handler
- subscribes the event handler to receive mutations on the reference `the input character` 
- upon receiving a mutation event the handler evaluates the trigger statement and,
- if the trigger statement evaluates to truth then the handler executes the trigger action and
- then this operation is repeated for the embedded trigger statement

The `<reference> starts a <noun>` construct is called a noun start statement and is the most important part of this example as it instructs cliffhanger computer to change the behavior of the reference so that any object (including the start object) that it references is treated as a part of the noun up until this behavior is cancelled with a noun stop statement that looks like `<reference> stops a <noun>` and has the same values used both for `<reference>` and `<noun>`.

When a noun stop statement is executed all values that were referenced by statement's `<reference>` since the corresponding start statement was executed are grouped together into a single object and added into the noun set. Noun set triggers can be used to execute additional statements on the grouped values:

```
when a <noun>:
  <action statements>
```

