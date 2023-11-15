# Scala Course Assignments

This repository contains my solutions to the challenging assignments of the Scala course I completed on Coursera.

## About the Course

The course provided an in-depth understanding of the Scala programming language. It covered fundamental concepts such as functional programming, object-oriented programming, and more advanced topics like concurrency and parallelism.

## Assignments

The assignments were designed to test the understanding of the concepts taught in the course. They were challenging and required a good grasp of Scala and problem-solving skills.


### 1. Recursion

#### Assignment 1.1: Pascal's Triangle
The first assignment was to implement a function that computes the elements of Pascal's Triangle. The function takes a column `c` and a row `r`, both counting from 0, and returns the number at that spot in the triangle. This was achieved using a recursive process.

#### Assignment 1.2: Parentheses Balancing
The second assignment was to write a recursive function that verifies the balancing of parentheses in a string. The function returns true for balanced strings and false for unbalanced ones.

#### Assignment 1.3: Counting Change
The third assignment was to write a recursive function that counts how many different ways you can make change for an amount, given a list of coin denominations.


### 2. Functional Sets

#### Functional Sets
You will learn how to represent sets of integers using characteristic functions, which are higher-order functions that take an integer and return a boolean.

#### FP principles
You will practice writing Scala code using functional programming principles, such as immutability, recursion, and anonymous functions.

#### Testing and debugging
You will write your own tests for your solutions using the FunSetSuite.scala file, which contains hints and examples.


### 3. Object-Oriented Sets

#### Functional Sets
This assignment is about creating an object-oriented representation based on binary trees. Here are the key points:

- **Objective**: The goal is to work with an object-oriented representation based on binary trees. The assignment involves completing the `TweetSet.scala` file, which defines an abstract class `TweetSet` with two concrete subclasses: `Empty` and `NonEmpty(elem: Tweet, left: TweetSet, right: TweetSet)`. 
- **Filtering**: You need to implement filtering on tweet sets. The `filter` method takes a predicate (a function that returns a boolean) and returns the subset of all the tweets in the original set for which the predicate is true.
- **Unions**: You need to implement the `union` method on tweet sets. This method should return a new tweet set which is the union of the current set and another set.


### 4. Huffman Coding Assignment
- **Objective**: This assignment is about implementing Huffman coding, a popular compression algorithm. You'll be working with a binary tree data structure that represents the characters to be encoded and their frequencies.

The assignment has two main parts:
1. **Encoding**: You'll create a function to encode a character. This is done by traversing from the root of the tree to the leaf containing the character. You'll add a 0 to the representation for each left branch you choose, and a 1 for each right branch.
2. **Decoding**: You'll also create a function to decode a sequence of bits. Starting at the root of the tree, you'll read the bits one by one. For each 0, you'll choose the left branch, and for each 1, you'll choose the right branch. When you reach a leaf, you'll decode the corresponding character and then start again at the root of the tree.

You'll be provided with a `CodeTree` abstract class and two case classes, `Fork` and `Leaf`, to represent the Huffman tree. You'll need to implement two functions, `weight` and `chars`, using pattern matching on the code tree. The `weight` function should return the total weight (frequency of appearance) of a given Huffman tree, and the `chars` function should return the list of characters defined in a given Huffman tree.


### 5. Anagrams
1. **Finding anagrams**: You need to write a Scala program that can find all the possible anagrams of a given sentence, using a dictionary of meaningful words.
2. **Using collections and for-comprehensions**: You need to use the Scala Collections API and for-comprehensions to manipulate lists, sets, maps, and other data structures.
3. **Working with strings and characters**: You need to use the Java String class and its methods to process the characters of the sentence and the words in the dictionary.


## Running the Code

To run the code in this repository, you need to have Scala installed on your machine. You can then clone this repository and run the Scala files using the Scala compiler.

```bash
git clone https://github.com/k-pulkit/scala-course-assignments.git
cd scala-course-assignments
sbt test
```