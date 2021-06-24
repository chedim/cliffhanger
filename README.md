# cliffhanger
Natural data processing language

# Application structure
Cliff applications are written by defining nouns that operate on noun streams.

## Noun
A noun is a named value that is resolved at the moment when it is used.
Noun names can be constructed from any words that are not reserved by the language.
Noun definition consists of the noun name, optional noun owner, one of the defining keywords and the definition:
```
the secret is 10
```
In this case we defined noun 'the secret' with static value 10.
This noun can later be redefined in the same way:
```
the secret is 1
```
And id can be used to define another noun:
```
the key is 0 - the secret
```

## Articles 
The 'the' article is used to refer to 'the current' value of an noun, which by default is the latest.
The 'a' and 'an' articles can be used to capture values of nouns:
```
the secret is a string      // allows capturing a string value
```

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
    - large

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
  
