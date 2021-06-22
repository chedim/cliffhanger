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

## Plurals
Plurals are the glue of a cliff application.
Plurals acts as streams that, by default, capture all assigned to the noun value.
They can also be used to import nouns:

```
arguments is {process arguments}
```

## Frames
Frames are created using the 'is the last <size> <source>' definition:


# Data types
CH provides a set of pre-defined types that can be used to construct user structures.

## Integer
The number type can be used to store an integer number.
The nuber type can be defined using the '#' type marker.
The default size of a number value is 32 bits. 
The size of a number value can be redefined by providing a value range: `field: #[0-255]` will result in a 1-byte value length, while #[0-2***^64] will create an 8-byte value.

## Real
The real type can be used to store fraction values.
It can be defined using the '$' type marker.
The default size is 32 bits and can be redefined by providing a value range: `field: $[0-255]`
Real literals are 

## Character
The character type can be used to store a single character.
It can be defined using the '~' type marker.

## Map
The map type can be used to store a group of objects.
Each object in a map has a corresponding key that can be used to access the object.
A map can be defined by using square brackets with key definition after the field name: `field[<keydef>]`
The key definition can take one of the following forms:
- Empty: the map will accept any as a key and will use the hashcode of the object as the key. Example: `field[]: ~~`.
- Type marker: the map will accept only keys of the specified type. Example: `field[~]: #`
- Upper-bound: the map will accept only keys of the same type as specified value and smaller than it. Example: `field[10]: #`

A map with upper-bound integer keys acts as an array.

## Text
The text type can be used to store text values.
It can be defined using the '~~' type marker or a regular expression filter: `field: ~~`
Alternatively, a text field can be defined as an array of characters: `field[#]: ~`; both definitions are equal.
A regular expression filter can be specified using the slash brackets: `field: /[a-z]{10}/`

# Defining a node

## Value node
```
node Fibonacchi(argument): #{
  @[.argument = 1]: 1
  else: Fibonacchi(argument - 1) + Fibonacchi(argument - 2)
}
```

## Structure node
```
import com.example.OnlineActivity;
import com.example.PasswordChange;

node User {

  // this field is of type text and its value must match the given regexp
  username: /[a-zA-Z][a-zA-Z_0-9]{5,}/

  email: /[a-zA-Z_\.0-9]+@[a-zA-Z_\.0-9]+/

  // This is a date field that should have value smaller than now - 16 years
  dob: `< -16y`

  // this field stores floating point values between 0.0 and 100.0 (including the boundaries)
  karma: $[0-100]

  // this field is of type number and its value is generated
  // based on dob field and cannot be set from outside
  (age): #{
    dob: `now - $dob`.years
  }

  // the :: can be used to define the field differently for outside consumers
  // in this case `online` refers to the last modification date of the 'online' field
  (lastActivity)::`online`

  // this is a string field with some additional update rules
  // and a custom outside definition -- the fiel will have different values
  // depending on wether it is accessed from inside the node or outside of it
  password::"": /.{8,}/ {
    // this is a mutation rule
    // it gets triggered whenever the `new` event is emited on com
    new@PasswordChange[.old = password]: .new
  }

  // this field is transient -- it can be set from outside, but not read and it is not stored
  (unlock): /.{8,}/
  
  // this field has a default value (false)
  // that can be changed by some mutation rules
  online: false {

    // mark user as online when they log in or
    // when they perform an activity
    unlock = password || new@OnlineActivity => true

    // this is a timed mutation: 
    // every time the value of online changes to true
    // it starts a 1-hour timer (cancelling previously set timer)
    // and marks user offline when the timer is due
    `1h`@online[= true] => false
  }

  // defines an array of 10 bits
  flags[10]: ?
  // defines an array of 5 strings:
  nicknames[5]: /.*/

  // defines a map:
  settings[/.*/]: /.*/
}
```
