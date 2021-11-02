# Test driven development with cliffhanger

Test driven developent in cliffhanger can be done with `must be/must not be` keywords:

```
a user name length must be < 19
a user email must not be false when user is verified
```

A violation of `must` statements at any time will cause the application to print the violated statement and mutation trace to stderr and exit with errror code 1.
