# cliffhanger
Universal data behavior definition language.

# Application data graph
Cliffhanger applications operate by constructing and maintaining time-evolving application data graphs.
Each node of the graph represents either a value or a data structure. 
Each data structure has its internal data graph that can be partially exposed to other nodes.

# Value types
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
