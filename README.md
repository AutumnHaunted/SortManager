# SortManager
*A Java program by Autumn Pelešová / AutumnHaunted*
A program that manages the sorting of integer arrays.

## Contents
1. [Sorters](https://github.com/AutumnHaunted/SortManager/blob/main/README.md#sorters)
   - [Bubble Sort](https://github.com/AutumnHaunted/SortManager/blob/main/README.md#bubble-sort)
   - [Merge Sort](https://github.com/AutumnHaunted/SortManager/blob/main/README.md#merge-sort)
   - [Binary Search Tree Sort](https://github.com/AutumnHaunted/SortManager/blob/main/README.md#binary-search-tree-sort)
2. [Using the program](https://github.com/AutumnHaunted/SortManager/blob/main/README.md#using-the-program)
   - [Input syntax](https://github.com/AutumnHaunted/SortManager/blob/main/README.md#input-syntax)
   - [Options](https://github.com/AutumnHaunted/SortManager/blob/main/README.md#options)
3. [Timing](https://github.com/AutumnHaunted/SortManager/blob/main/README.md#timing)
4. [Technologies used](https://github.com/AutumnHaunted/SortManager/blob/main/README.md#technologies-used)

## Sorters
There are currently three types of sorting algorithm implemented in this program.
You can choose any set of them to run, either on the same array, or on different arrays.

The following are the available sorters:

### Bubble Sort
Works by passing over the array from the start to the end, swapping any misordered pairs.
It repeats this until the array has been sorted.
> Input: **bubble**

### Merge Sort
Works by recursively dividing the array into subarrays until they are trivially sorted (by being only one element).
Then, "merges" them back up by combining two sorted subarrays to create one sorted union.
> Input: **merge**

### Binary Search Tree Sort
Binary Search Trees are not a typical form of sorting.
However, this sort uses them by constructing one from the input array, and as order is built into their structure, an ordered array can be extracted from it.
As BSTs cannot contain duplicates, the wrapper class checks for duplicates and adds them back into the result.
> Input: **tree**

## Using the program

### Input syntax
To use the program, the user can follow the prompts given by the console. Valid inputs will be specified in quotation marks. For example:
> Would you prefer a random array ("r") or to input an array ("i")? (or type "q" to quit)

Here, the valid inputs are `r`, `i`, and `q`. Inputting anything else will result in an error.

Sometimes, a prompt may ask you to enter a comma-separated list, such as here:
> Please input your array in the form of a comma-separated list of integers. (or type "q" to quit)

An example of a valid input for this prompt would be the following:
`5, 2, 7, 3, 4, 2, 6`

### Options
Users can...
- Select any subset of the available sorting types
- Use the same array or different arrays for each one
- Input a custom array or specify a size for a random array

## Timing
Every time a sort is carried out, it is timed, in milliseconds. This allows the user to compare the execution of different sort types on different kinds of arrays.
Some sort types work better on arrays that are already almost sorted while others work better when the array is highly disordered. The timing information can help you get an idea of this.

## Technologies used
- JetBrains IntelliJ Idea Ultimate
- Apache Maven
- Apache Log4j
- JUnit (and JUnit Jupiter)