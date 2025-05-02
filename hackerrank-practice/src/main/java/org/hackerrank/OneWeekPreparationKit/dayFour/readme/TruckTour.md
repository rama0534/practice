# Truck Tour
- Suppose there is a circle. There are N petrol pumps on that circle. Petrol pumps are numbered O to
(N - 1) (both inclusive). You have two pieces of information corresponding to each of the petrol pump:
(1) the amount of petrol that particular petrol pump will give, and
(2) the distance from that petrol pump to the next petrol pump.

- Initially, you have a tank of infinite capacity carrying no petrol.
You can start the tour at any of the petrol pumps.
Calculate the first point from where the truck will be able to complete the circle.
Consider that the truck will stop at each of the petrol pumps. The truck will move one kilometer for each litre of the petrol.
#### Input Format
The first line will contain the value of N.
The next N lines will contain a pair of integers each, i.e. the amount of petrol that petrol pump will give and the distance between that petrol pump and the next petrol pump.
#### Constraints:
````
1 ≤  N ≤ 10^5
1 ≤ amount of petrol, distance ≤ 10^9
````
#### Output Format
- An integer which will be the smallest index of the petrol pump from which we can start the tour.
#### Sample Input
````
3
1  5
10 3
3  4
````
#### Sample Output
`1`
#### Explanation
We can start the tour from the second petrol pump.