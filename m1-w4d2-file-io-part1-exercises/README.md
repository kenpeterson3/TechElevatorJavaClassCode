# File I/O Part 1 Exercises

## WordSearch

### Part 1

Write a program that asks the user for a search word, and the path of a text file to search. The program searches the file for occurrences of the search word, and each time it finds the word, it displays the line number and contents of the line where the word was found. 

Use `alices_adventures_in_wonderland.txt` for test input.

The initial output should start with:
```
1) Project Gutenberg's Alice's Adventures in Wonderland, by Lewis Carroll
9) Title: Alice's Adventures in Wonderland
43) [Illustration: "Alice"]
.
.
.
```

### Part 2

Modify the program to ask the user if the search should be case sensitive.

Use `alices_adventures_in_wonderland.txt` for test input.
       
The output should change to:
```
1) Project Gutenberg's Alice's Adventures in Wonderland, by Lewis Carroll
9) Title: Alice's Adventures in Wonderland
41) ALICE'S ADVENTURES IN WONDERLAND
43) [Illustration: "Alice"]
.
.
.
```

<div style="page-break-after: always;"></div>

## QuizMaker (Challenge)

Write a program that "gives" a quiz.  The program begins by asking the user for the path of a text file that contains the quiz questions. It will then read the file, and display each question and its possible answers. The program will wait for the user's answer before moving onto the next question.

The quiz questions file has the following format:

```
Question-1|answer-1|answer-2|answer-3*|answer-4
Question-2|answer-1*|answer-2|answer-3|answer-4
Question-3|answer-1|answer-2|answer-3|answer-4*
```
The correct answer is signified by an `*` at its end.

Example file

```
What color is the sky?|Yellow|Blue*|Green|Red
What are Cleveland's odds of winning a championship?|Not likely*|Highly likely|Fat chance|Who cares??
```

Hints:

- Create a class that can hold a quiz question, its available answers, and the correct answer.
- Try holding each quiz question in a list of quiz questions

### Step 1

Ask the questions found in the quiz file. Don't show the asterisk in the list of choices.  Redisplay the question and possible answers if the user enters an invalid response.  Valid responses are 1 through 4.

Example
```
What color is the sky?
1. Yellow
2. Blue
3. Green
4. Red

Your answer: 8

Invalid answer!

What color is the sky?
1. Yellow
2. Blue
3. Green
4. Red

Your answer: 4
Sorry that isn't correct!

``` 

### Step 2

Go through quiz questions as before, but record how many answers the use got correct.  At the end of the quiz, display the total number of questions asked and the number of correct answers.

Example
```
What color is the sky?
1. Yellow
2. Blue
3. Green
4. Red

Your answer: 4

Sorry that isn't Correct!

What are the Cleveland Browns' odds of winning a championship?
1. Not likely
2. Highly likely
3. Fat chance
4. Who cares??

Your answer: 1

Correct!

You got 1 answer(s) correct out of the total 2 questions asked
```
