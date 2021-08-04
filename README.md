# Runtime Comparison of Recursive and Iterative Algorithms 

## Structure

This project contains 2 modules:

**AlgoFoundationsProject**

Contains _Java_ source code for the recursive and iterative implementations of
1. Factorial
2. Fibonacci
3. Towers Of Hanoi

Contains a Java Swing GUI that allows users to call the functions using a user-provided input value.

**AlgoFoundationsClojure**

Contains _Clojure_ source code for the recursive implementations of
1. Factorial
2. Fibonacci


## Usage
The GUI can be run by calling GUI.main() in an IDE of your choice.

The Clojure functions can be run from a Clojure REPL, using the following commands
1. Open the Clojure REPL in your IDE.
2. Import the namespace. E.g. `(require 'src.clojuredemo.core)`
3. Call the function. E.g. `(src.clojuredemo.core/tail-recursive-fibonacci 6)`
