package com.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {

//        1. remove duplicate keep the order
        List<String> fruits = Arrays.asList("orange", "apple", "banana", "grape", "apple",  "apricot", "avocado", "blueberry");
        fruits.stream().distinct().forEach(System.out::println);

//        2. Find the distinct numbers which starts with 1 in a list.
        List<Integer> numbers = Arrays.asList(1, 12, 14, 16, 46, 17, 19, 13);
        numbers.stream()
                .filter(number -> String.valueOf(number).startsWith("1"))
                .collect(Collectors.toSet())
                .forEach(System.out::println);

//        3. Join two streams
        List<Integer> oddNumbers = Arrays.asList(1, 3, 5, 7, 9);
        List<Integer> evenNumbers = Arrays.asList(2, 4, 6, 8);
        Stream.concat(oddNumbers.stream(), evenNumbers.stream()).forEach(System.out::println);

//        4.Merge two sorted list into a single sorted list using.
        List<Integer> sortedList =
                Stream.concat(oddNumbers.stream(), evenNumbers.stream()).sorted().collect(Collectors.toList());
        System.out.println(sortedList);

//        5. Check List of integers containing prime numbers
        Set<Integer> primeNumbers =   numbers.stream()
                .filter(n -> IntStream.rangeClosed(2, (int) Math.sqrt(n)).noneMatch(i -> (n % i) == 0))
                .collect(Collectors.toSet());
        System.out.println(primeNumbers);
//        6.Debug streams using Peak().
        List<String> words = Arrays.asList("apple", "banana", "Orange", "Grape");
        List<String> filteredWords =  words.stream()
                .peek(word -> System.out.println("Before filter "+word))
                .filter(word -> word.startsWith("a"))
                .peek(word -> System.out.println("After filter "+word))
                .map((String::toUpperCase))
                .peek(word -> System.out.println("After uppercase " + word))
                .collect(Collectors.toList());
        System.out.println(filteredWords);
//      7.Find strings start with a number
        List<String> wordsWithNumbers = Arrays.asList("abc", "def", "3ghi", "4jkl", "5mno", "");
        wordsWithNumbers.stream()
                .filter(word -> !word.isEmpty() && Character.isDigit(word.charAt(0)))
                .forEach(System.out::println);
//      8. Check whether given String is palindrome or not
        String string = "madam";
        int n = string.length();
        boolean isPalindrome = IntStream.rangeClosed(0, n/2)
                .allMatch(i -> string.charAt(i) == string.charAt(n - 1 - i));
        System.out.println(isPalindrome);

//      9. Sort the given list in ascending and descending order
        List<Double> decimals = Arrays.asList(2.645, 1.4142, 2.449, 1.732, 2.236);
        System.out.println(decimals.stream()
                .sorted().collect(Collectors.toList()));
        System.out.println(decimals.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList()));
//      10. Find the kth smallest element in a list
        int k = 3;
        numbers.stream()
                .sorted()
                .skip(k - 1)
                .findFirst()
                .ifPresent(System.out::println);
        //Find nth largest element in array
        int[] arr = {4, 5, 6, 1, 2, 7, 8, 2};
        int size = 3;
        Arrays.stream(arr)
                .sorted()
                .skip(size - 1)
                .findFirst().ifPresent(System.out::println);
//      11. Find the kth highest element in an array
        numbers.stream().sorted(Comparator.reverseOrder()).skip(k - 1).findFirst().ifPresent(System.out::println);
        Arrays.stream(arr)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(size - 1)
                .findFirst().ifPresent(System.out::println);

//      12.Print last element of an array
        Arrays.stream(arr).skip(arr.length - 1).findFirst().ifPresent(System.out::println);

//        13. Given a list of fruits join the fruits with '[' as prefix, ']' as suffix and ',' as delimiter.
        String fruitsList = fruits.stream()
                .distinct()
                .map(fruit -> "[ " + fruit + " ]" )
                .collect(Collectors.joining(","));
        String listOfFruits = fruits.stream()
                .distinct()
                .collect(Collectors.joining(",", "[", "]"));
        System.out.println(fruitsList);  // Output: [ apple ],[ banana ],[ grape ],[ orange ]
        System.out.println(listOfFruits); // Output:[apple,banana,grape,orange]

//        14. Find the sum of first two number in a given list
        System.out.println(numbers.stream()
                .limit(2)
                .mapToInt(Integer::intValue)
                .sum());

//         15. product of first 3 numbers
        Optional<Integer> product = numbers.stream()
                                    .limit(3)
                                    .reduce((a,b) -> a * b);
        product.ifPresent(System.out::println);
//        16. sum of unique numbers in a given list
        int total = numbers.stream().distinct().mapToInt(Integer::intValue).sum();
        System.out.println("Total: " + total);
//        17. Find the words with K vowels in a given sentence?
        fruits.stream().filter(word -> word.chars()
                                            .mapToObj(ch -> (char) ch)
                                            .filter(ch ->  "aeiouAEIOU".indexOf(ch) != -1)
                                            .count() >= k )
                        .forEach(System.out::println);
//      18. Given String, find first non-repeated characters in it.
        String name = "compose";
        name.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))         //LinkedHashMap keep it in order
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst().ifPresent(System.out::println);
//      19. Statistics find min, max, sum, avg, count in a given list
        IntSummaryStatistics statistics = numbers.stream().mapToInt(p -> p).summaryStatistics();
        System.out.println("Min: " + statistics.getMin());
        System.out.println("Max: " + statistics.getMax());
        System.out.println("Avg: " + statistics.getAverage());
        System.out.println("Sum: " + statistics.getSum());
        System.out.println("count: " + statistics.getCount());
//      20. find a word with the highest length
        fruits.stream()
                .max(Comparator.comparingInt(String::length))
                .ifPresent(System.out::println);
//      Find a word with the nth highest length
        fruits.stream()
                .sorted(Comparator.comparingInt(String::length).reversed()) // .sorted((w1, w2) -> Integer.compare(w2.length(), w1.length()))
                .skip(2)
                .findFirst()
                .ifPresent(System.out::println);
//      21. Given a list of transactions find the sum of transaction amount for each day (transaction object has date and amount fields).
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
//      22.Given an integer array return true if it contains duplicate elements otherwise false.
        boolean hasDuplicate = Arrays.stream(arr).distinct().count() != arr.length;
        System.out.println(hasDuplicate);
        Set<Integer> numStreamSet = new HashSet<>();
        boolean response = Arrays.stream(arr).anyMatch(value -> !numStreamSet.add(value));
        System.out.println("Streams response : is Array contains duplicates " + response);

//        23. Write a program to print the count of each character in a string?
        String greet = "Welcome";
        Map<Character, Long> charCoutMap = greet.chars()
                                                    .mapToObj(c -> (char) c)
                                                    .filter(ch -> ch != ' ')
                                                    .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        System.out.println(charCoutMap);

//         24. Given the list of integers, find the first odd number of the list using stream functions?
        numbers.stream().filter(value -> value % 2 != 0).findFirst().ifPresent(System.out::println);

//        25. Find the intersection of two list (Print common elements b/w list)
        List<Integer> listOne = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> listTwo = Arrays.asList(4, 5, 6, 7, 8);

        //without streams
        List<Integer>  intersectionList = new ArrayList<>(listOne);
        intersectionList.retainAll(listTwo);
        System.out.println(intersectionList);

        //With streams
        List<Integer> intersectionListStreams = listOne.stream().filter(listTwo::contains).collect(Collectors.toList());
        System.out.println(intersectionListStreams);

//        26. How to group by employees by age
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Sam", 25),
                new Employee(2, "Peter", 35),
                new Employee(3, "Jackson", 45),
                new Employee(4, "Jessi", 25),
                new Employee(5, "John", 35),
                new Employee(6, "Swiss", 45),
                new Employee(7, "Helen", 25),
                new Employee(8, "Margaret", 35),
                new Employee(9, "David", 45)
        );
        Map<Integer, List<Employee>> employeesAge = employees.stream()
                .collect(Collectors.groupingBy(Employee::getAge));
        employeesAge.forEach((key, value) -> System.out.println(key +" years old  Employee list: " + value) );


//         27. How to partition list of numbers into even and odd groups
        Map<Boolean, List<Integer>> partitionMap = numbers.stream().collect(Collectors.partitioningBy(e -> e %2 == 0));
        System.out.println(partitionMap);
        Map<String, List<Integer>> evenOddMap = numbers.stream().collect(Collectors.groupingBy(e -> (e % 2 == 0) ? "Even" : "Odd"));
        System.out.println(evenOddMap);

//      28 Calculate the average age of a list of Employees
         employees.stream().mapToInt(Employee::getAge).average().ifPresent(System.out::println);
         double averageAge = employees.stream().collect(Collectors.averagingInt(Employee::getAge));
         System.out.println("Employees Average age: "+ averageAge);

//     29. How to sort multiple filed using streams in Descending order
       employees.stream()
                .sorted(Comparator.comparingInt(Employee::getAge).thenComparing(Employee::getName))
                 .forEach(System.out::println);

//     30.  Find the length of each word in a list
        Map<String, Integer> fruitsLengthMap =  fruits.stream()
                                                        .collect(Collectors.toMap(
                                                                    Function.identity(),
                                                                    String::length,
                                                                    (existing, replace) -> existing));
        System.out.println(fruitsLengthMap);
//     31. Find the kth longest word in a list of words
        words.stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .skip(2)
                .findFirst()
                .ifPresent(System.out::println);
        System.out.println(words);
        words.stream().max(Comparator.comparingInt(String::length)).ifPresent(System.out::println);


//     32. To find the sum of non-repeated numbers(i.e., numbers that appear exactly once) using Java Streams, you can do this in two steps:
        List<Integer> numbersList = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        int sum = numbersList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) // Map<Integer, Long>
                .entrySet().stream()
                .filter(e -> e.getValue() == 1) // Keep only numbers that appear once
                .peek(e -> System.out.println("peek value is " + e))
                .mapToInt(Map.Entry::getKey)
                .sum();
        System.out.println("Sum of non-repeated numbers: " + sum);
//     33. Sort the Map values based on value.
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 2);
        map.put("b", 3);
        map.put("d", 4);
        map.put("c", 1);
        System.out.println("Original Map: "+map);
        Map<String, Integer> sortedByValue =
                map.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue())
                        .collect(Collectors.toMap(
                                        Map.Entry::getKey,
                                        Map.Entry::getValue,
                                        (existing, replace) -> existing,
                                        LinkedHashMap::new));
       System.out.println("Sorted Map:" + sortedByValue);
       Map<Character, String> keepFirst = fruits.stream()
                .collect(Collectors.toMap(
                        word -> word.charAt(0),
                        word -> word,
                        (existing, replace) -> existing
                ));
        System.out.println("Keep First .. "+keepFirst);
        Map<Character, String> keepLast = fruits.stream()
                .collect(Collectors.toMap(
                        word -> word.charAt(0),
                        Function.identity(),
                        (existing, replace) -> replace
                ));
        System.out.println("keepLast....." + keepLast);
        System.out.println("Reversed");
        keepLast.entrySet().stream().sorted(Map.Entry.<Character, String>comparingByValue().reversed()).forEach(System.out::println);


//	   34.You have a list of employees. How would you group them by department and then count the number of employees in each department?
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
        System.out.println("Employee...");
        System.out.println(empList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting())));
    }
}
