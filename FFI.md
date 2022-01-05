# Cliffhanger library communication protocol
Cliffhanger library communication protocol (CLCP) is an application layer text network protocol that is used by cliffhanger applications and libraries to share changes in their local data graphs.
Messages should be separated by CR ASCII code.

## Client authentication message
Every CLCP communication should start with an authentication message from the client:
```
version charset token
```
where:
- version is the protocol version
- charset: the name of the charset to be used for communication sent using ASCII
- token: JWT token signed with a key acceptable by the target library 

Examples:
```
1 utf8 eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c
```

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
```

### Classification tree request message
Client may request library's classification tree by sending the following message:
```
? classes
```

### Classification tree response message
```
= classes value
```
where:
- value: json object that represents library's classification tree

Example:
```
= classes {
  "user": {
    "name": "string",
    ...
  },
  ...
}
```

### Value request message
Client may request library's output datapoint value by sending the following message: 
```
? key
```
where key is either:
- SHA1 of the datapoint name
- quoted datapoint name

Examples:
```
? 1b63f41de1266ba378b1b6ad5c44ad60f21f2bef
? "current user email"
```

### Value Message format
Value message can be used:
- by client to set a value in library's data graph
- by library to notify a client about its data graph change
- by library to respond to a value request message
```
= key value
```
where: 
- key is either:
-- SHA1 of the datapoint name
-- quoted datapoint name 
-- SHA1 of related request message
- value: json-encoded datapoint value

Examples: 
```
= 1b63f41de1266ba378b1b6ad5c44ad60f21f2bef 300
= "current user email" "example@example.com"
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

