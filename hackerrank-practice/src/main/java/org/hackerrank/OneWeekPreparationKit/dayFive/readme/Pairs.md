# Pairs
Given an array of integers and a target value, determine the number of pairs of array elements that have a
difference equal to the target value.
#### Example
````
k = 1;
arr = [1, 2, 3, 4];
````
There are three values that differ by k = 1: 2-1 = 1,3-2 = 1, and 4-3 = 1. Return 3. 
#### Function Description
Complete the pairs function below.
pairs has the following parameter(s):
- int k: an integer, the target difference
- int arr[n]: an array of integers

#### Returns
int: the number of pairs that satisfy the criterion

#### Input Format
The first line contains two space-separated integers n and k, and the target value.
The size of The second line contains space-separated integers of the array _arr_.

#### Constraints
````
2 ≤ n ≤ 10^5
0 < k < 10^9
0 < arr[i] < 2^31 - 1
each integer arr i] will be unique
````
 
#### Sample Input
````
STDIN       Function
-----       --------
5 2         arr[] size n = 5, k =2
1 5 3 4 2   arr = [1, 5, 3, 4, 2]
````
#### Sample Output
``` 
3 
```

#### Explanation
There are 3 pairs of integers in the set with a difference of 2: [5,3], [4,2] and [3,1].
