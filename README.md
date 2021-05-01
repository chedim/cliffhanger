# cliffhanger
Datacentric natural programming language
Currently under development

# Roadmap
Cliffhanger applications consist of data and behavior definitions that are triggered on data changes. Each CH application operates on an abstract data tree.

Applications define data behavior using when-or statements. When-or statement syntax is defined as follows:

```
when <trigger>:
  <mutations>
[or [<alternative trigger>]:
  <alternative mutations>]
```

where `<trigger>` and `<alternative trigger>` are logical conditions that may reference elements of the data tree and are re-evaluated every time  any of the referenced values are redefined.
`<mutations>` and `<alternative mutations>` is a list of mutations that should be performed on the data tree every time the corresponding trigger evaluates to true.

# Tree traversal
Any identifier (that is, not a keyword or a literal) used in either trigger condition or a mutation instricts CH to traverse the data tree down from the current node to its child with that identifier. Identifiers can be separated either with "/" or " ", for example:

```system file /etc/cliffhanger/config```

is evaluated as follows:

- at the beginning the internal tree pointer (ITP) points at the root of the data tree
- after the "system" identifier is processed, ITP is moved to point at the "system" top-level node
- after the "file" identifier is processed ITP points at the node "/system/file" (which contains the operating system's file tree)
- after the "etc" identifier is processed ITP points at the node "/system/file/etc", which corresponds to /etc directory 
- after the "cliffhanger" and "config" identifiers are processed ITP points at "/system/file/etc/cliffhanger/config", which corresponds to the file located at /etc/cliffhanger/config

# Trigger conditions
Trigger conditions use identifiers to observe mutations on some tree nodes. By default, any mutation of the node is observed. Observed mutations can be filtered out with logical, comparison and ownership operators

# Logical operators
and, or, not

# Comparison operators
- is -- equality comparison (in js: ==)
- is under -- less than comparison (in js: <)
- is above -- greater than comparison (in js: >)
- is not above -- less than or equals comparison
- is not under -- greater than or equals comparison

Examples:
  `when user name is guest`
  `when user name length is under 5`
  `when system time is above 1619897256`
  `when attempts is not above 3`
  `when years from user age is not under 21`

# ownership operators
with -- verifies that left operand contains nodes from the right
without -- verifies that left operand does not contain nodes from the right

Examples:
  `when user with email`
  `when registration without password`
  ...
