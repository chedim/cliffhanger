// the brackets indicate an external definition
// the use of plural forms indicates that this is a stream
arguments are {process arguments}

// 'the next' and 'the current' take singular form of the word 
// the plural form will be formed either according to the rules of English or looked up
// in a dictionary during the compile time.
the port is a number from the next argument after the current argument is either:
  - '--port'
  - '-p'

the server is an {http server} with the port

requests are from the server with:
  request url is '/messages'
  request method is either:
    - 'POST'
    - 'GET'

messages are the last 10 request bodies

posting new message when request method is 'POST'
listing messages when request method is 'GET'

request response is with:
  body is either:
    - "OK" when posing new message
    - messages joined by '\n' when listing messages


