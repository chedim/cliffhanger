# Cliffhanger library communication protocol
Cliffhanger library communication protocol (CLCP) is an extension to websocket protocol.

### Rejection messages
Client messages may be rejected by the library.
The library should notify the client about rejections by sending a rejection message:
```
! rejected reason
```
where:
- rejected: SHA1 of rejected message
- reason: json-encoded string with human-readable rejection reason

Example:
```
! 4257ff111e606143fb8250713bc09d30128412d5 "user password must be set"
! 249ba36000029bbe97499c03db5a9001f6b734ec "output datapoint not found: user name \'"
```

### Context set message
Client may set context for all its future requests by sending the following message:
```
@ key
```
where key is SHA1 of a datapoint name.

### Value request message
Client may request library's output datapoint value by sending the following message: 
```
? key [slice]
```
where optional slice is either a numeric index or golang-like slice definition 
and key is either:
- SHA1 of datapoint name
- json-quoted datapoint name


Examples:
```
? 1b63f41de1266ba378b1b6ad5c44ad60f21f2bef
? "current user email"
? "requests" 564
? "messages" [0:10]
```

### Value subscription messabe
Client may request the library to emit a value message every time a datapoint value changes by sending the following message:
```
& key
```

where key is either:
- SHA1 of datapoint name
- JSON-qouted datapoint name

examples:
```
& 1b63f41de1266ba378b1b6ad5c44ad60f21f2bef
& "current user email"
```

### Value Message format
Value message can be used:
- by client to set library's input datapoint session value 
- by library to notify a client about changes in output datapoint session values
- by library to respond to a value request message
```
= yaml

```
where yaml code is terminated with an empty line and conforms to the following requirements: 
- keys are either:
-- SHA1 of a datapoint name
-- a datapoint name 
-- SHA1 of related request message
-- a numeric index 
-- golang-like slice definition 
- values: related values


Examples: 
```
= 1b63f41de1266ba378b1b6ad5c44ad60f21f2bef: 300

= current user email: "example@example.com"

= new message:
  to: "example@example.com"
  title: "Hello"
  text: "Hi there!"

= requests [111]:
  processed: true

```

### Datapoint deletion message
Datapoint deletion messages is sent either by client or library whenever a datapoint becomes undefined
```
- key
```
where key euther:
- SHA1 of a datapoint name
- datapoint name

Example:
```
- attention span
```

### Acceptance messages
Libraries must respond with an acceptance message for every accepted value:
```
+ accepted
```
where:
- accepted: SHA1 of accepted message

Example:
```
+ 4257ff111e606143fb8250713bc09d30128412d5
```

