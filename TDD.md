# Test driven development with cliffhanger

Test driven developent in cliffhanger can be done by tracing data mutations. 
For example, the following trace ensures that application exits in no more than 10 steps:

```
trace from started:
  when length of the trace is above 10:
    the error is "The behavior graph should have less than 10 edges"
```
end
