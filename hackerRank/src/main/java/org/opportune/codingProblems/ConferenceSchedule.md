# Conference Schedule
A schedule has just been released for an upcoming tech conference. The schedule provides the start and end times of each of the presentations. 
Once a presentation has begun, no one can enter or leave the room. It takes no time to go from one presentation to another. 
Determine the maximum number of presentations that can be attended by one person.

**Example**
````
n = 3
scheduleStart = [1, 1, 2]
scheduleEnd = [3, 2, 4]
````
Using O-based indexing, an attendee could attend any presentation alone, or both presentations `1 and 2`. 
Presentation 0 ends too late to be able to attend presentation `2` afterward.
The maximum number of presentations one person can attend is `2`.
#### Function Description
Complete the function maxPresentations in the editor below.
maxPresentations has the following parameter(s): 
- `scheduleStart[n]`: the start times of presentation `i `
- `scheduleEnd[n]`: the end times of presentation `i`
#### Returns:
int: the maximum number of presentations that can be attended by one person

#### Constraints
- `1 ≤ n ≤ 105`
- `1 ≤ scheduleStart[i], scheduleEnd[i] ≤ 10^9`
#### Sample Case 0
Sample Input
````
size n = 4
scheduleStart = [1, 1, 2, 3]
scheduleEnd = [2, 3, 3, 4]
````
Sample Output

`3`
#### Explanation
An attendee can go to presentations `0, 2, and 3` without conflict. If presentation `1 `is chosen, from time` 1 to 3`, 
only two presentations can be attended.
The maximum number of presentations a single person can attend is `3`.

#### Sample Case 1
Sample Input
````
size n = 4
scheduleStart = [6, 1, 2, 3]
scheduleEnd = [8, 9, 4, 7]
````
Sample Output

`2`

#### Explanation
An attendee can attend presentation `1` only as it runs the entire day, or they can instead attend meeting `2 from 2 until 4`, 
then choose to attend either presentation `0 or 3`. 
The maximum number of presentations a single person can attend is `2`.

#### Solutions
```java
private static int maxPresentations(List<Integer> scheduleStart, List<Integer> scheduleEnd) {
        int count = 0;
        int n = scheduleStart.size();
        List<int[]> presentations = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            presentations.add(new int[]{scheduleStart.get(i), scheduleEnd.get(i)});
        }
        //sort by their end times
        presentations.sort(Comparator.comparingInt(a -> a[1]));
        int lastEndTime = 0;
        for (int[] presentation : presentations) {
            if (presentation[0] >= lastEndTime) {
                count++;
                lastEndTime = presentation[1];
            }
        }
        return count;
    }

```