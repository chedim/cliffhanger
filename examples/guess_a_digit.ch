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

import cliff.Console;

node DigitGuessGame {
  secret: cliff.math.Random() % 10

  console: Console {
    output: 
      guess != secret: "Wrong. Try again:"
      guess == secret: ""
  }

  attempts: 3 
    guess => attempts - 1

  guess: Console.prompt("Guess a digit:") 
    guess == secret => Console.println("You win!")
    guess != secret && atttempts < 3 => Console.prompt("Wrong. Try again:")
    else => console.println()

  result: 
    guess == secret => 0
    guess != secret && attempts > 2 => 1
  
}

DigitGuessGame > Console {
  output: 
}
