# Streams
Streams in Java, introduced in Java 8, provide a way to process collections of objects in a declarative and functional style. 
A stream represents a sequence of elements that supports various operations which can be pipelined to produce the desired result. 
Streams do not store data but operate on a source such as a collection, array, or I/O channel. 

## Stream Creation
Streams can be created in several ways:
- From a collection using the stream() or parallelStream() method.
- From an array using Arrays.stream().
- Using Stream.of(), Stream.generate(), or Stream.iterate().
## Stream Operations
Stream operations are divided into intermediate and terminal operations.
### Intermediate operations
Transform a stream into another stream, allowing for chaining of operations. Examples include:
- `filter(Predicate)`: Returns a stream consisting of elements that match the given predicate.
- `map(Function)`: Returns a stream consisting of the results of applying the given function to the elements of the stream.
- `flatMap(Function)`: Returns a stream consisting of the results of replacing each element of the stream with the contents of a mapped stream (which may be empty).
- `distinct()`: Returns a stream consisting of the distinct elements (according to Object.equals(Object)) of the stream.
- `sorted()`: Returns a stream consisting of the elements of the stream, sorted according to natural order.
- `limit(long)`: Returns a stream consisting of the elements of the stream, truncated to be no longer than maxSize in length.
- `skip(long)`: Returns a stream consisting of the remaining elements of the stream after discarding the first n elements of the stream.
### Terminal operations
Produce a result or side effect and mark the end of the stream. Examples include:
- `forEach(Consumer)`: Performs an action for each element of the stream.
- `toArray()`: Returns an array containing the elements of the stream.
- `reduce(BinaryOperator)`: Reduces the elements of the stream to a single value.
- `collect(Collector)`: Collects the elements of the stream into a collection or other data structure.
- `min(Comparator)`: Returns the minimum element of the stream according to the provided Comparator.
- `max(Comparator)`: Returns the maximum element of the stream according to the provided Comparator.
- `count()`: Returns the count of elements in the stream.
- `anyMatch(Predicate)`: Returns whether any elements of the stream match the provided predicate.
- `allMatch(Predicate)`: Returns whether all elements of the stream match the provided predicate.
- `noneMatch(Predicate)`: Returns whether no elements of the stream match the provided predicate.
- `findFirst()`: Returns an Optional describing the first element of the stream, or an empty Optional if the stream is empty.
- `findAny()`: Returns an Optional describing some element of the stream, or an empty Optional if the stream is empty.
### Parallel Streams
Java streams can be processed sequentially or in parallel. 
Parallel streams utilize multiple cores of the processor to improve performance when processing large datasets. 
To create a parallel stream, use the parallelStream() method on a collection or the parallel() method on a sequential stream.

### Sample Questions
1. Find the distinct numbers starts with 1 in a list.
2. How to join two streams
3. Merge two sorted list into a single sorted list using.
4. Check List of integers containing any prime number.
5. Sort the given list in ascending and descending order
6. Find the kth smallest element in an array
7. Find the kth highest element in an array
8. Print last element of an array
9. Find the sum of first two number in a given list
10. Product of first 3 numbers
11. Sum of unique numbers in a given list
12. Statistics: Find min, max, sum, avg, count in a given list
13. Given an integer array return true if it contains duplicate elements otherwise false.
14. Given the list of integers, find the first odd number of the list using stream functions?
15. Find the intersection of two list (Print common elements b/w list)
16. How to partition list of numbers into even and odd groups
17. To find the sum of non-repeated numbers(i.e., numbers that appear exactly once)
18. Remove the duplicates from the list and preserve the order.
19. Debug streams using peek()
20. Find out Strings start with a number
21. Check whether given String is palindrome or not
22. Given a list of fruits join the fruits with `[` as prefix, `]` as suffix and `,` as delimiter.
23. Find the words with K vowels in a given sentence
24. Given String, find first non-repeated characters in it.
25. Find a word with the highest length
26. Find the count of each character in a string?
27. Find the length of each word in a list 
28. Find the kth longest word in a list of words
29. Given a list of transactions find the sum of transaction amount for each day (transaction object has date and amount fields).
30. How to group by employees by age 
31. Group Employees by department and then count the number of employees in each department 
32. Calculate the average age of a list of Employees 
33. How to sort multiple filed using streams in Descending order
34. Convert a list of Employee objects to a map with employee ID as key and name as value.
35. Sort the Map values based on value
#### 1. Find the distinct numbers starts with 1 in a list.
```
List<Integer> numbers = Arrays.asList(1, 12, 14, 16, 46, 17, 19, 13);
numbers.stream()
        .filter(number -> String.valueOf(number).startsWith("1"))
        .collect(Collectors.toSet())
        .forEach(System.out::println); 
```
#### 2. How to join two streams
````
List<Integer> oddNumbers = Arrays.asList(1, 3, 5, 7, 9);
List<Integer> evenNumbers = Arrays.asList(2, 4, 6, 8);
Stream.concat(oddNumbers.stream(), evenNumbers.stream()).forEach(System.out::println); 
````
#### 3.Merge two sorted list into a single sorted list using.
```
Stream.concat(oddNumbers.stream(), evenNumbers.stream())
      .sorted().collect(Collectors.toList());
System.out.println(sortedList);
```
#### 4. Check List of integers containing any prime number
````
List<Integer> numbers = Arrays.asList(1, 12, 14, 16, 46, 17, 19, 13);
Set<Integer> primeNumbers =  numbers.stream()
                                            .filter(n -> IntStream.rangeClosed(2, (int) Math.sqrt(n)).noneMatch(i -> (n % i) == 0))
                                            .collect(Collectors.toSet());
System.out.println(primeNumbers);
````
#### 5. Sort the given list in ascending and descending order
```   
List<Double> decimals = Arrays.asList(2.645, 1.4142, 2.449, 1.732, 2.236);

System.out.println(decimals.stream()
                            .sorted().collect(Collectors.toList())); //ascending  
System.out.println(decimals.stream()
                            .sorted(Comparator.reverseOrder())
                            .collect(Collectors.toList()));         //descending
```
#### 6. Find the kth smallest element in an array
```
List<Integer> elements = Arrays.asList(10, 23, 4, 98, 34);
int k = 2;
elements.stream()
        .sorted()
        .skip(k - 1)
        .findFirst()
        .ifPresent(System.out::println);
int[] arr = {4, 5, 6, 1, 2, 7, 8}; 
Arrays.stream(arr)
        .sorted()
        .skip(k - 1)
        .findFirst().ifPresent(System.out::println);
```
#### 7. Find the kth highest element in an array
```
List<Integer> elements = Arrays.asList(10, 23, 4, 98, 34);
int k = 2;
elements.stream()
        .sorted(Comparator.reverseOrder())
        .skip(k - 1)
        .findFirst()
        .ifPresent(System.out::println); 
int[] arr = {4, 5, 6, 1, 2, 7, 8}; 
Arrays.stream(arr)   // Arrays.stream(arr) returns an IntStream, which is a primitive stream.
        .boxed()     //  You must use .boxed() to convert it to Stream<Integer> 
        .sorted(Comparator.reverseOrder())
        .skip(size - 1)
        .findFirst().ifPresent(System.out::println);
```
#### 8.Print last element of an array
```
int[] arr = {4, 5, 6, 1, 2, 7, 8}; 
Arrays.stream(arr)
        .skip(arr.length - 1)
        .findFirst()
        .ifPresent(System.out::println);
```
#### 9. Find the sum of first two number in a given list
```
List<Integer> numbers = Arrays.asList(9, 3, 4, 5, 6);
int sumOfFirstTwo = numbers.stream()
                            .limit(2)
                            .mapToInt(Integer::intValue)
                            .sum();
System.out.println(sumOfFirstTwo); 
```
#### 10. Product of first 3 numbers
```
List<Integer> numbers = Arrays.asList(9, 3, 4, 5, 6);
Optional<Integer> product = numbers.stream()
                                    .limit(3)
                                    .reduce((a,b) -> a * b);
product.ifPresent(System.out::println);
```
#### 11. Sum of unique numbers in a given list
```
List<Integer> numbers = Arrays.asList(9, 3, 4, 5, 6);
int total = numbers.stream()
                    .distinct()
                    .mapToInt(Integer::intValue)
                    .sum();
System.out.println("Total: "+total);
```
#### 12. Statistics: Find min, max, sum, avg, count in a given list
```
List<Integer> numbers = Arrays.asList(1, 12, 14, 16, 46, 17, 19, 13);
IntSummaryStatistics statistics = numbers.stream().mapToInt(p -> p).summaryStatistics();
System.out.println("Min: " + statistics.getMin());
System.out.println("Max: " + statistics.getMax());
System.out.println("Avg: " + statistics.getAverage());
System.out.println("Sum: " + statistics.getSum());
System.out.println("count: " + statistics.getCount());
```
#### 13. Given an integer array return true if it contains duplicate elements otherwise false.
```
int[] arr = {4, 5, 6, 1, 2, 7, 8, 2};
boolean hasDuplicate = Arrays.stream(arr).distinct().count() != arr.length;
System.out.println(hasDuplicate);

//With HashSet
Set<Integer> numStreamSet = new HashSet<>();
boolean response = Arrays.stream(arr).anyMatch(value -> !numStreamSet.add(value));
System.out.println("Streams response : is Array contains duplicates " + response);
```
#### 14. Given the list of integers, find the first odd number of the list using stream functions?
``` 
List<Integer> list = Arrays.asList(2, 3, 4, 5, 7, 9);
list.stream().filter(value -> value % 2 != 0).findFirst().ifPresent(System.out::println);
```
#### 15. Find the intersection of two list (Print common elements b/w list)
```
List<Integer> listOne = Arrays.asList(1, 2, 3, 4, 5);
List<Integer> listTwo = Arrays.asList(4, 5, 6, 7, 8);

//without streams
List<Integer>  intersectionList = new ArrayList<>(listOne);
intersectionList.retainAll(listTwo);
System.out.println(intersectionList);

//With streams
List<Integer> intersectionListStreams = listOne.stream().filter(listTwo::contains).collect(Collectors.toList());
System.out.println(intersectionListStreams);
```
#### 16. How to partition list of numbers into even and odd groups
```
List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
Map<Boolean, List<Integer>> partitionMap = list.stream()
                                                    .collect(Collectors.partitioningBy(e -> e %2 == 0));
System.out.println(partitionMap); // Output : {false=[1, 3, 5, 7, 9], true=[2, 4, 6, 8, 10]}
Map<String, List<Integer>> evenOddMap = list.stream()
                                                .collect(Collectors.groupingBy(e -> (e % 2 == 0) ? "Even" : "Odd"));
System.out.println(evenOddMap); // Output: {Even=[2, 4, 6, 8, 10], Odd=[1, 3, 5, 7, 9]}
```
#### 17. To find the sum of non-repeated numbers(i.e., numbers that appear exactly once)
``` 
List<Integer> numbersList = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
int sum = numbersList.stream()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) // Map<Integer, Long>
        .entrySet().stream()
        .filter(e -> e.getValue() == 1) // Keep only numbers that appear once
        .peek(e -> System.out.println("peek value is " + e))
        .mapToInt(Map.Entry::getKey)
        .sum();
System.out.println("Sum of non-repeated numbers: " + sum); //Output: 9
```
#### 18. Remove the duplicates from the list and preserve the order.
```
List<String> fruits = Arrays.asList("apple", "banana", "grape", "apple", "Orange");
fruits.stream().distinct().forEach(System.out::println);
```
#### 19. Debug streams using peek()
````
List<String> words = Arrays.asList("apple", "banana", "Orange", "Grape");
List<String> filteredWords =  words.stream()
                                    .peek(word -> System.out.println("Before filter "+word))
                                    .filter(word -> word.startsWith("a"))
                                    .peek(word -> System.out.println("After filter "+word))
                                    .map((String::toUpperCase))
                                    .peek(word -> System.out.println("After uppercase " + word))
                                    .collect(Collectors.toList());
System.out.println(filteredWords);
````
#### 20. Find out Strings start with a number
````
List<String> wordsWithNumbers = Arrays.asList("abc", "def", "3ghi", "4jkl", "5mno", "");
wordsWithNumbers.stream()
                .filter(word -> !word.isEmpty() && Character.isDigit(word.charAt(0)))
                .forEach(System.out::println);
````
#### 21. Check whether given String is palindrome or not
```
String string = "madam";
int n = string.length();
boolean isPalindrome = IntStream.rangeClosed(0, n/2)
                                .allMatch(i -> string.charAt(i) == string.charAt(n - 1 - i));
System.out.println(isPalindrome);
```
#### 22. Given a list of fruits join the fruits with `[` as prefix, `]` as suffix and `,` as delimiter.
```
List<String> fruits = Arrays.asList("apple", "banana", "grape", "apple", "orange");
String fruitsList = fruits.stream()
                            .distinct()
                            .map(fruit -> "[ " + fruit + " ]" )
                            .collect(Collectors.joining(",")); 
String listOfFruits = fruits.stream()
                            .distinct()
                            .collect(Collectors.joining(",", "[", "]"));  
System.out.println(fruitsList);  // Output: [ apple ],[ banana ],[ grape ],[ orange ]

System.out.println(listOfFruits); // Output:[apple,banana,grape,orange]
```
#### 23. Find the words with K vowels in a given sentence
```
private static final Set<Character> VOWELS = Set.of('a','e','i','o','u','A','E','I','O','U');
public static long countVowels(String word) {
    return word.chars()
               .filter(ch -> VOWELS.contains((char) ch))
               .count();
}
List<String> fruits = Arrays.asList("apple", "banana", "grape", "apple", "Orange");
int k = 2;
fruits.stream()
      .filter(word -> countVowels(word) >= k)
      .forEach(System.out::println);
```
#### 24. Given String, find first non-repeated characters in it.
```
String name = "compose";
name.chars()
    .mapToObj(ch -> (char) ch)
    .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) // LinkedHashMap keep it in order
    .entrySet().stream()
    .filter(entry -> entry.getValue() == 1) // for repeated use change the condition to >
    .map(Map.Entry::getKey)
    .findFirst().ifPresent(System.out::println);
```
#### 25. Find a word with the highest length 
```
List<String> fruits = Arrays.asList("ale", "banana", "grape", "ae", "orange", "kiwi");
int k = 2
fruits.stream()
        .max(Comparator.comparingInt(String::length))
        .ifPresent(System.out::println);
//        find a word with the nth highest length
fruits.stream()
        .sorted(Comparator.comparingInt(String::length).reversed()) //.sorted((w1, w2) -> Integer.compare(w2.length(), w1.length()))
        .skip(k)
        .findFirst()
        .ifPresent(System.out::println);
```
#### 26. Find the count of each character in a string?
```
String greet = "Welcome";
Map<Character, Long> charCoutMap = greet.chars()
                                         .mapToObj(c -> (char) c)
                                         .filter(ch -> ch != ' ')
                                         .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
System.out.println(charCoutMap);
```
#### 27. Find the length of each word in a list
``` 
List<String> fruits = Arrays.asList("apple", "banana", "Orange", "Grape", "apple");
Map<String, Integer> fruitsLengthMap =
        fruits.stream()
               .collect(Collectors.toMap(
                            Function.identity(),
                            String::length,
                            (existing, replace) -> existing));
System.out.println(fruitsLengthMap); // output: {banana=6, apple=5, Grape=5, Orange=6}
```
#### 28. Find the kth longest word in a list of words
```
List<String> fruits = Arrays.asList("apple", "banana", "Orange", "Grape", "apple");
fruits.stream()
        .sorted(Comparator.comparingInt(String::length)..reversed())
        .skip(2)
        .findFirst()
        .ifPresent(System.out::println); // Ouptput: 
words.stream().max(Comparator.comparingInt(String::length)).ifPresent(System.out::println); 
```
#### 29. Given a list of transactions find the sum of transaction amount for each day (transaction object has date and amount fields).
```
@Data
@AllArgsConstructor
public class Transaction {
    private final String date;
    private final double amount;
    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if (!(obj instanceof  Transaction)) return false;
        Transaction t = (Transaction) obj;
        return Objects.equals(date, t.date) &&
                amount == t.amount;
    }
    @Override
    public int hashCode() {
        return Objects.hash(date, amount);
    }
}
 List<Transaction> transactions = Arrays.asList(
    new Transaction("12-05-2022", 209.00),
    new Transaction("13-05-2022", 409.00),
    new Transaction("14-05-2022", 309.00),
    new Transaction("13-05-2022", 109.00),
    new Transaction("12-05-2022", 200.00)
    );
    Map<String, Double> dailyTransactions = transactions.stream()
    .collect(Collectors.groupingBy(Transaction::getData, Collectors.summingDouble(Transaction::getAmount)));
    dailyTransactions.forEach((date, value) -> System.out.println("On " + date + " the total transaction amount was $" + value ));
```
#### 30. How to group by employees by age
```
@Data
@AllArgsConstructor
public class Employee {
    private int id;
    private String name;
    private int age;
    private String department;
    @Override
    public String toString() {
        return name + " age " + age;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && age == employee.age && Objects.equals(name, employee.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }
}
List<Employee> empList = Arrays.asList(
                new Employee(1, "Sam", 25, "Science"),
                new Employee(2, "Peter", 35, "Arts"),
                new Employee(3, "Jackson", 45, "Commerce"),
                new Employee(4, "Jessi", 25, "Science"),
                new Employee(5, "John", 35, "Commerce"),
                new Employee(6, "Swiss", 45, "Science"),
                new Employee(7, "Helen", 25, "Arts"),
                new Employee(8, "Margaret", 35, "Commerce"),
                new Employee(9, "David", 45, "Arts")
        );
Map<Integer, List<Employee>> employeesAge = employees.stream()
                                                     .collect(Collectors.groupingBy(Employee::getAge));
System.out.println(employeesAge);
```
#### 31. Group Employees by department and then count the number of employees in each department
```
System.out.println(empList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting())));
Output: {Science=3, Commerce=3, Arts=3}
```
#### 32. Calculate the average age of a list of Employees
```
employees.stream().mapToInt(Employee::getAge).average().ifPresent(System.out::println);
double averageAge = employees.stream().collect(Collectors.averagingInt(Employee::getAge));
System.out.println("Employees Average age: "+ averageAge);
```
#### 33. How to sort multiple filed using streams in Descending order
``` 
employees.stream()
         .sorted(Comparator.comparingInt(Employee::getAge).thenComparing(Employee::getName))
         .forEach(System.out::println);
```
#### 34. Convert a list of Employee objects to a map with employee ID as key and name as value.
``` 
System.out.println( empList.stream().collect(Collectors.toMap(Employee::getId, Employee::getName)));
//Output: {1=Sam, 2=Peter, 3=Jackson, 4=Jessi, 5=John, 6=Swiss, 7=Helen, 8=Margaret, 9=David}
``` 
#### 35. Sort the Map values based on value.
```
Map<String, Integer> map = new HashMap<>();
        map.put("a", 2);
        map.put("b", 3);
        map.put("c", 1);
        map.put("d", 4);
        System.out.println("Original Map: "+map);
        Map<String, Integer> sortedByValue =  map.entrySet().stream()
                                                            .sorted(Map.Entry.comparingByValue())
                                                            .collect(Collectors.toMap(
                                                                                Map.Entry::getKey,
                                                                                Map.Entry::getValue,
                                                                               (existing, replace) -> existing,  // merge function (not used here)
                                                                                LinkedHashMap::new // maintains sort order)
                                                             );
System.out.println("Sorted Map:" + sortedByValue);
map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);

List<String> fruits = Arrays.asList("orange", "apple", "banana", "grape", "apple", "apricot", "avocado", "blueberry");
Map<Character, String> keepFirst = fruits.stream()
                                            .collect(Collectors.toMap(
                                                    word -> word.charAt(0),
                                                    word -> word,
                                                    (existing, replace) -> existing
                                            ));
System.out.println(keepFirst); // Output: {a=apple, b=banana, g=grape, o=orange}
Map<Character, String> keepLast = fruits.stream()
                                        .collect(Collectors.toMap(
                                                word -> word.charAt(0),
                                                Function.identity(),
                                                (existing, replace) -> replace
                                        ));
System.out.println(keepLast); //Output:  {a=avocado, b=blueberry, g=grape, o=orange}
keepLast.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
//Output: a=avocado  b=blueberry  g=grape o=orange
System.out.println("Reversed");
keepLast.entrySet().stream().sorted(Map.Entry.<Character, String>comparingByValue().reversed()).forEach(System.out::println);
//Output: o=orange g=grape  b=blueberry  a=avocado
```
### Basic to Intermediate Questions:
#### What is the difference between Stream.of(), Arrays.stream() and Collection.stream()?
##### 1. Stream.of()
- Purpose: Creates a stream from a fixed number of elements.
- Input: A varargs (array) or individual values.

```java
Stream<String> stream = Stream.of("A", "B", "C");
//With Arrays
String[] array = {"A", "B", "C"};
Stream<String> stream = Stream.of(array);  // creates a stream with one element if passed as a single object!
```
##### 2. Arrays.stream()
- Purpose: Creates a stream from an `array`.
- Input: Array (primitive or object).
```java
int[] numbers = {1, 2, 3};
IntStream intStream = Arrays.stream(numbers);
String[] strings = {"X", "Y"};
Stream<String> stringStream = Arrays.stream(strings);
```
- Special handling for primitives: Returns primitive streams (`IntStream`, `DoubleStream`, etc.), which are more efficient than `Stream<Integer>` etc.
##### 3. Collection.stream()
- Purpose: Creates a stream from a Collection (e.g., `List, Set,` etc.)
- Input: Any object implementing the Collection interface.
```java
List<String> list = Arrays.asList("A", "B", "C");
Stream<String> stream = list.stream();
```
##### Which to Use When?
- Use `Stream.of()`: When you want to stream a small number of known elements.
- Use `Arrays.stream()`: When you have an array, especially primitive arrays.
- Use `Collection.stream()`: When working with a List, Set, or any collection.
##### What are the main differences between intermediate and terminal operations in streams? Give examples.
In stream processing, intermediate operations are lazy, meaning they don't execute until a terminal operation is called.
They transform or filter a stream and return a new stream. 
Terminal operations, on the other hand, trigger the processing and produce a final result or side effect. 
They can't be chained with other operations and mark the end of the stream pipeline.
###### Intermediate Operations:
- Example: `filter(), map(), sorted(), distinct(), limit(), skip()`
- Purpose: To modify or transform the elements of the stream, returning a new stream.
- Execution: Lazy; not executed until a terminal operation is called.
- Chaining: Can be chained with other intermediate operations.
###### Terminal Operations:
- Example: `collect(), forEach(), reduce(), count(), anyMatch(), allMatch(), noneMatch()`
- Purpose: To trigger the stream processing and produce a final result or side effect.
- Execution: Eager; executes the entire stream pipeline.
- Chaining: Cannot be chained; must be the final operation in the pipeline.
##### What is the difference between map() and flatMap() in Java 8 Streams?
The main difference between `map` and `flatMap` lies in how they handle the function's return value.
`map` returns a single element for each input element, while `flatMap` returns a collection (which can be zero, one, or more elements) 
and then flattens this collection into a single, flat result. In essence, `flatMap` is like combining map and flatten operations.
###### map:
- Takes an input and transforms it into a single output for each input element.
- The output is a new collection with the transformed elements.
- The function applied by map typically returns a single, distinct value.
###### flatMap:
- Takes an input and transforms it into a collection (which can contain zero, one, or more elements) for each input element.
- This collection of collections is then flattened into a single, flat output collection.
- The function applied by flatMap typically returns a stream or list of elements, which are then flattened.
###### Example:
- Let's say you have a list of strings, and you want to extract all the vowels from each string
```
List<String> words = Arrays.asList("Hello", "World", "Java");

// Using map (would result in a nested list of lists)
List<List<Character>> vowels = words.stream()
                                    .map(word -> word.chars()
                                                       .filter(c -> "aeiou".indexOf(c) >= 0)
                                                       .mapToObj(c -> (char)c)
                                                       .collect(Collectors.toList()))
                                    .collect(Collectors.toList());  // Output: [[a, e], [a, a, a], [a, e], [a, e]]

// Using flatMap (flattens the result into a single list)
List<Character> allVowels = words.stream()
                                    .flatMap(word -> word.chars()
                                                          .filter(c -> "aeiou".indexOf(c) >= 0)
                                                           .mapToObj(c -> (char)c))
                                    .collect(Collectors.toList());   // Output: [a, e, a, a, a, a, e, a, e]

String[][] studentNames = new String[][]{
        {"Joe", "Peter" },
        {"Sam", "July"},
        {"Helen", "Parker"}
};
Arrays.stream(studentNames)
        .flatMap(Arrays::stream)
        .forEach(System.out::println); // Joe  Peter  Sam  July  Helen  Parker

List<List<String>> lists = Arrays.asList(
        Arrays.asList("Apple", "Dell", "Samsung", "Lenovo"),
        Arrays.asList("Tokyo", "Rome", "Moscow", "Paris"),
        Arrays.asList("Sushi", "Pizza", "pelmeni", "Croissant")
);

lists.stream()
     .flatMap(List::stream)
     .filter(word -> word.length() > 4)
     .forEach(System.out::println); // Output: Apple  Samsung  Lenovo  Tokyo  Moscow  Paris  Sushi  Pizza  pelmeni  Croissant  
```


##### What is lazy evaluation in Streams, and how does it improve performance?
Lazy evaluation in Java Streams means that intermediate operations (like `filter()`, `map()`, `sorted()`) are not executed immediately when the stream pipeline is created. 
Instead, they are deferred until a terminal operation (like `collect()`, `forEach()`, `reduce()`, etc.) is called.
###### How it improves performance:
- Short-circuiting: Stops processing early (e.g., with `findFirst()`, `limit()`). 
- Fused operations: Combines operations into a single pass (e.g., `map` + `filter`). 
- Avoids unnecessary computation: Only processes what's needed.
##### Explain the working of reduce() with an example.
The reduce() method combines all elements of a stream into a single result, using an accumulator function.
```java
Optional<T> reduce(BinaryOperator<T> accumulator);
T reduce(T identity, BinaryOperator<T> accumulator);
```
```
//Sum of Numbers
List<Integer> numbers = Arrays.asList(5, 2, 9, 1, 5);
// With identity
int numsSum = nums.stream()
.reduce(0, Integer::sum); // 0 is the identity, (a + b) is the accumulator
System.out.println(numsSum); // 22 

//Max number
Optional<Integer> max = numbers.stream()
                               .reduce(Integer::max);
max.ifPresent(System.out::println); // Output: 9

//combines strings 
List<String> words = Arrays.asList("Hello", " ", "World", "!");
String sentence = words.stream()
                      .reduce("", String::concat);
System.out.println(sentence); // Output: Hello World!

//product of elements
Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
int product = stream.reduce(1, (a, b) -> a * b);
System.out.println(product); // Output: 120
```
##### What are the performance implications of using sequential vs parallel streams? When would you choose one over the other?
`Parallel streams` in Java enable the processing of `stream` elements concurrently, potentially improving performance for suitable operations.
They use the `Fork/Join` framework to distribute the workload across multiple threads, leveraging available processor cores.
To create a parallel stream, one can use the `parallelStream()` method on a collection or the `parallel()` method on an existing `stream`.
````
List<Integer> listOfNumbers = Arrays.asList( 3, 4,1, 2);
listOfNumbers.parallelStream()
                .forEach(number ->
                System.out.println(number + " " + Thread.currentThread().getName()));

List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
// Create a parallel stream
numbers.parallelStream()
        .filter(nk -> nk % 2 == 0)
        .forEach(System.out::println); 

// Alternatively, convert a sequential stream to parallel
numbers.stream()
        .parallel()
        .filter(nh -> nh % 2 == 0)
        .forEach(System.out::println);
````