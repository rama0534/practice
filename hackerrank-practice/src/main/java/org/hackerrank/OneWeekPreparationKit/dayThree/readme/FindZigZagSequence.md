# Find ZigZag sequence.
In this challenge, the task is to debug the existing code to successfully execute all provided test files.

Given an array of n distinct integers, transform the array into a zigzag sequence by permuting the array elements. 
A sequence will be called a zigzag sequence if the first k elements in the sequence are in increasing order 
and the last k elements are in decreasing order, where k = (n + 1)/2. You need to find the lexicographically smallest zigzag sequence of the given array.

### Example.
``` a = 2,3,5,1,41```
Now if we permute the array as 1, 4, 5, 3, 21, the result is a zigzag sequence.

Debug the given function findZigZagSequence to return the appropriate zigzag sequence for the given input array.

Note: You can modify at most three lines in the given code. You cannot add or remove lines of code.

To restore the original code, click on the icon to the right of the language selector.

#### Input Format
The first line contains t the number of test cases. 
The first line of each test case contains an integer n, denoting the number of array elements.
The next line of the test case contains n elements of array a.

#### Constraints
``` 
1 ≤ t ≤ 20
1 ≤ n ≤ 10000 (n is always odd)
1≤ ai ≤ 10^9
```
#### Output Format
For each test cases, print the elements of the transformed zigzag sequence in a single line.

[link](https://www.hackerrank.com/challenges/one-week-preparation-kit-zig-zag-sequence/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D=one-week-day-three
)