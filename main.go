package main

import (
  "bufio"
  "fmt"
  "io"
  "io/util"
  "os"
)

func check(e error) {
  if e != nil {
    panic(e)
  }
}

func main() {
  filename := os.Args[1]

  source, e := os.Open(filename)
  check(e)
}
