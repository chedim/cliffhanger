when started:
  secret is a digit from system random
  attempts is 0
  guess is a digit from console prompt with "Guess a digit:"

when guess is not secret:
  and attempts is under 3:
    guess is a digit from console prompt with "Wrong. Try again:"
  or else:
    a new console line is "You lose. The digit was " + secret
    system exit with 1
or else:
  a new console line is "You win!"
  system exit with 0
