# File I/O Part 2 Exercises

## FizzBuzz

Create a program to write out the result of FizzBuzz (1 to 300) to a file called `FizzBuzz.txt`.

* If the number is divisible by 3 or contains a 3, print “Fizz”
* If the number is divisible by 5 or contains a 5, print “Buzz”
* If the number is divisible by 3 and 5, print “FizzBuzz”
* Otherwise print the number.

The class should be called:

```
com.techelevator.FizzBuzz
```

## File Splitter

#### Challenge

Develop an application that takes a significantly large text file and splits it into smaller file chunks.

Create a class called `com.techelevator.FileSplitter` with a method called `splitFile` that takes two arguments; a `String filename` and an `int maxLines`.

The program should accept 2 parameters

* The name of the text file to be split
* The maximum number of lines that should appear in each output file

Each output file that is created should have a sequential number assigned to it.

For instance, a 250 line text file named "input.txt", split every 100 lines, will produce 3 output files

* `input-1.txt` - 100 lines
* `input-2.txt` - 100 lines
* `input-3.txt` - 50 lines

Use a sequential naming format for each file produced to guarantee uniqueness. Note, the sequence number is simply
appended to the name of the input text file.

These types of files used to be quite common back in the earlier days of computing when
disks such as floppies were much smaller and couldn’t hold a larger program on their own.
