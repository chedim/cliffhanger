# Cliffhanger library communication protocol
Cliffhanger library communication protocol (CLCP) is an application layer binary network protocol that is used by cliffhanger applications and libraries to communicate changes in their local data graphs.
Messages should be separated by CR ASCII code.

## Client authentication message
Every CLCP communication should start with an authentication message from the client:
```
token
```
where:
- token: JWT token signed with a key acceptable by the target library 

### Message format
```
set key value
```
where: 
- key: SHA1 of the datapoint name
- value: base64-encoded datapoint value

Example: 
```
set 1b63f41de1266ba378b1b6ad5c44ad60f21f2bef SGVsbG8sIENsaWZm
```

### Rejection messages
Client messages may be rejected by the library.
The library should notify the client about rejections by sending a rejection message:
```
EE: rejected reason
```
where:
- rejected: SHA1 of rejected message
- reason: human-readable rejection reason

Cliffhanger string escape sequences are supported in the rejection reason field.

Example:
```
EE: 4257ff111e606143fb8250713bc09d30128412d5 user password must be set
```

### Acceptance messages
Libraries must respond with an acceptance message for every accepted value:
```
OK: accepted
```
where:
- accepted: SHA1 of accepted message

Example:
```
OK: 4257ff111e606143fb8250713bc09d30128412d5
```

