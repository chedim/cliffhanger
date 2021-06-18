# cliffhanger
Universal 
ata definition language.

# Application data graph
Cliffhanger applications operate by constructing and maintaining time-evolving application data graphs.
Each node of the graph represents a data structure. 
Each data structure has its internal data graph that can be partially exposed to other nodes.

# Defining a node
```
import com.example.OnlineActivity;
import com.example.PasswordChange;

node User {

  // this field is of type text and its value must match the given regexp
  username: /[a-zA-Z][a-zA-Z_0-9]{5,}/

  email: /[a-zA-Z_\.0-9]+@[a-zA-Z_\.0-9]+/

  // This is a date field that should have value smaller than now - 16 years
  dob: `< -16y`

  // this field is of type number and its value is generated
  // based on dob field and cannot be set from outside
  (age): {
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
  
  // the '?' symbol is used to reference a single bit or boolean value (true/false and 1/0 are synonyms)
  online: ? -> {
    // initialization value
    new@User: false;

    // mark user as online when they log in or
    // when they perform an activity
    unlock = password || new@OnlineActivity: true
    // this is a timed mutation: 
    // every time the value of online changes to true
    // it starts a 1-hour timer (cancelling previously set timer)
    // and marks user offline when the timer is due
    `1h`@online[= true]: false
  }

  // defines an array of 10 bits
  flags[10]: ?
  // defines an array of 5 strings:
  nicknames[5]: /.*/

  // defines a map:
  settings[/.*/]: /.*/
}
```
