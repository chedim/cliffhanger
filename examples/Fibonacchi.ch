node Fibonacchi(argument): #{
  @[.argument = 1]: 1
  else: Fibonacchi(argument - 1) + Fibonacchi(argument - 2)
}
