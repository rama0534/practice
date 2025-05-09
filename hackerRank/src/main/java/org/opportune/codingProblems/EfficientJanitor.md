# Efficient Janitor
The janitor of a high school is extremely efficient. By the end of each day, 
all the school's waste is in plastic bags weighing between `1.01 pounds and 3.00` pounds.
All plastic bags are then taken to the trash bins outside. 
One trip is described as selecting a number of bags which together do not weigh more than 3.00 pounds, 
dumping them in the outside trash can and returning to the school. Given the number of plastic bags `n`, 
and the weights of each bag, determine the minimum number of trips the janitor has to make.

#### Example
````
n = 5
weight = [1.01, 1.99, 2.5, 1.5, 1.01]
The janitor can carry all plastic bags out in 3 trips: [1.01 + 1.99, 2.5, 1.5 + 1.01].
````
#### Function Description
Complete the function efficientJanitor in the editor below.

efficientJanitor has the following parameter(S):
`float weight[n]`: weights of the bags

#### Returns
`int: `the minimum number of trips required

#### Constraints
- `1 ≤ n ≤ 1000 `
- `1.01 ≤ weight[i] ≤ 3.0`

#### Input Format For Custom Testing
The first line contains an integer, n, the number of elements in weight.

Each line i of the n subsequent lines (where 0 ≤ i < n) contains a floating point number that describes weight[i].
#### Sample Case 0
Sample Input For Custom Testing
````
weight[] size n = 5
weight = [1.01, 1.01, 1.01, 1.4, 2.4]
````

#### Sample Output
`3`

#### Explanation
The janitor can carry all plastic bags out in 3 trips:
- The first 2 plastic bags together, the 3rd and 4th together and the last one alone

#### Sample Case 1
Sample Input For Custom Testing
````
weight[] size n = 4
weight = [1.01. 1.991, 1.32, 1.4]
````
#### Sample Output
`3`
#### Explanation
The janitor can carry all plastic bags out in 3 trips:
- The 1st and 2nd plastics bags separately and the 3rd and 4th together


#### Solution
````java
private static int minimumTrips(List<Double> list) {
        int trips = 0;
        Collections.sort(list);
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            if((list.get(left) + list.get(right)) <= 3.00) {
                left++;
                right--;
            } else {
                right--;
            }
            trips++;
        }
        return trips;
    }
````