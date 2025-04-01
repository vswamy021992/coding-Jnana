package org.example.java8programs;

import org.example.models.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8Programs {


    public static List<Employee> sortEmployeeByCityAndSalary(List<Employee> employeeList) {

        return employeeList.stream().sorted(Comparator.comparing(Employee::getCity)
                .thenComparing(Employee::getSalary)).toList();

    }
    public static long getTotalSalary(List<Employee> employeeList){

        return employeeList.stream().collect(Collectors.summarizingLong(Employee::getSalary)).getSum();
    }

    public static long getAvgSalary(List<Employee> employeeList){

        return employeeList.stream().collect(Collectors.averagingLong(Employee::getSalary)).longValue();
    }

    public static List<Employee> getDistinctEmployee(List<Employee> employeeList){

        return employeeList.stream().distinct().toList();
    }

    public static List<Employee> getUniqueEmployee(List<Employee> employeeList){
        Set<Employee> distinctEmployeeSet = new HashSet<>(employeeList);
        return distinctEmployeeSet.stream().toList();
    }

    public static List<Employee> getDuplicateEmployee(List<Employee> employeeList){
        Set<Employee> distinctEmployeeSet = new HashSet<>();
        return employeeList.stream().filter(emp->!distinctEmployeeSet.add(emp)).toList();
    }

    public static Map<Long, List<Employee>> groupEmployeeBySalary(List<Employee> employeeList){

        return employeeList.stream().collect(Collectors.groupingBy(Employee::getSalary));
    }

    public static Map<String, Set<String>>  getEmployeeNameWithCity(List<Employee> employeeList) {

        return  employeeList.stream().collect(Collectors.groupingBy(Employee::getCity, Collectors.mapping(Employee::getEmpName, Collectors.toSet())));
    }

    public static Map<Long, List<Employee>> sortEmployeeByCity(Map<Long, List<Employee>> employeeMap){

        return employeeMap.entrySet().stream().collect(Collectors.toMap(
                Map.Entry::getKey,
                entry-> entry.getValue().stream().sorted(Comparator.comparing(Employee::getCity)).toList(),
                (e1,e2)-> e1, TreeMap::new
        ));
    }

    public static List<Employee> getAllEmployee(Map<Long, List<Employee>> employeeMap){

        return employeeMap.values().stream().flatMap(List::stream).toList();
    }

    public static Map<Character, Long> getCharCount(String str){

      return str.chars().mapToObj(ch-> (char) ch).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static Map<String, Long> getWordCount(String str){
        Map<String, Long> wordCount = new HashMap<>();
        wordCount = Arrays.stream(str.split(""))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        wordCount = Arrays.stream(str.split(""))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(word-> word, LinkedHashMap::new, Collectors.counting()));
        return wordCount;
    }

    public static String nonReapiteadWord(String str){

        Optional<Character> nonRepeated = str.chars().mapToObj(i-> Character.toLowerCase((char) i))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) // store in a LinkedHashMap with the count
                .entrySet().stream()                       // EntrySet stream
                .filter(entry -> entry.getValue() == 1L)   // extracts characters with a count of 1
                .map(Map.Entry::getKey)              // get the keys of EntrySet
                .findFirst();
        Character ch = nonRepeated.orElse(null);
        System.out.println("First non repeated character"+ ch);

      return Arrays.stream(str.split("")).map(String::toLowerCase)
              .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
              .entrySet().stream().filter(word->word.getValue() > 1L).map(Map.Entry::getKey).findFirst().orElse(null)  ;
    }

    public static void sortMapElements(Map<String, Integer> mapValues){
        //Sort Map by value
        Map<String, Integer> mapResult = mapValues.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(mapResult);

        Map<String, Integer> mapResult1 = mapValues.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(mapResult1);

        Map<String, Integer> mapResult2 = mapValues.entrySet()
                .stream()
                .sorted((e1,e2) -> e1.getValue().compareTo(e2.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(mapResult2);

        Map<String, Integer> mapResult3 = mapValues.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(mapResult3);

        List<String>  keys = mapResult3.keySet().stream().toList();
        System.out.println(keys);
        List<Integer> values = mapResult3.values().stream().toList();
        System.out.println(values);
    }

    public static void printJavaEightArraySResult(){
        List<Integer> list = Arrays.asList(1,4,3,8,5,6,3);
        list.stream().filter(num ->num % 2 == 0 ).forEach(System.out::println);
        System.out.println(list.stream().filter(num ->num % 2 == 0 ).toList());

        int[] arr = {10,15,8,49,25,98,32};
        List<int[]> list2 = List.of(arr);
        Map<Boolean, List<Integer>> list1 = Arrays.stream(arr).boxed().collect(Collectors.partitioningBy(num ->num % 2== 0));
        System.out.println(list1);

        int[] arrayResult = {5,3,3,5,6,7,9,8,0};

        List<Integer> uniqueList = Arrays.stream(arrayResult).boxed().distinct().toList();
        List<Integer> desceSortList = Arrays.stream(arrayResult).boxed().sorted(Comparator.reverseOrder()).toList();
        System.out.println(Arrays.toString(uniqueList.toArray()));
        System.out.println(Arrays.toString(desceSortList.toArray()));

        Set<Integer> set = new HashSet<>();
        List<Integer> duplicateList = Arrays.stream(arrayResult).boxed().filter(num->!set.add(num)).toList();
        System.out.println(duplicateList);
        //


        //21. Write a Program to find the Maximum element in an array?
        int maxElement = Arrays.stream(arrayResult).max().getAsInt();
        System.out.println("" +maxElement);

    }

    public static void main(String[] args){
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee("Ramesh","Male", "Bangalore",10L));
        empList.add(new Employee("Suresh","Male", "Hyderabad",20L));
        empList.add(new Employee("Divya","Female", "Chennai",30L));
        empList.add(new Employee("Pooja","Female", "Delhi",40L));
        empList.add(new Employee("Pooja","Female", "Delhi",40L));

        List<Employee> sortedEmployeeList = sortEmployeeByCityAndSalary(empList);
        sortedEmployeeList.forEach(System.out::println);

        Map<Long, List<Employee>> employeeGroupBySalary = groupEmployeeBySalary(empList);

        employeeGroupBySalary.forEach((salary, employees) -> {
            System.out.println(salary);
            employees.forEach(System.out::println);
        } );

        Map<String, Set<String>> employeeNameWithCity = getEmployeeNameWithCity(empList);
        employeeNameWithCity.forEach((city, names) -> {
            System.out.println(city);
            names.forEach(System.out::println);
        } );

        Map<Long, List<Employee>> employeeSortByCity =  sortEmployeeByCity(employeeGroupBySalary);
        employeeSortByCity.forEach((salary, employees) -> {
            System.out.println(salary);
            employees.forEach(System.out::println);
        } );

        List<Employee>  sortedEmployee = getAllEmployee(employeeSortByCity);
        sortedEmployee.forEach(System.out::println);

        long totalSalary = getTotalSalary(sortedEmployee);
        long averageSalary = getAvgSalary(sortedEmployee);
        System.out.println("totalSalary:"+totalSalary+" " +"averageSalary:"+averageSalary);

        List<Employee> distinctEmployee = getDistinctEmployee(sortedEmployee);
        distinctEmployee.forEach(System.out::println);

        List<Employee> uniqueEmployee = getUniqueEmployee(sortedEmployee);
        uniqueEmployee.forEach(System.out::println);

        List<Employee> duplicatedEmployeeList = getDuplicateEmployee(empList);
        duplicatedEmployeeList.forEach(System.out::println);

        // Write a program to print the count of each character in a String?
        String str = "abacbcdfrr";

        Map<Character, Long> charCount = getCharCount(str);
        Map<String, Long> wordCount =  getWordCount(str);
        System.out.println(charCount);
        System.out.println(charCount);

        List<String> stringList = Arrays.asList("aa","bb","aa","cc","dd");

        System.out.println(charCount);

        Map<String, Integer> map = new HashMap<>();
        map.put("Laptop", 500);
        map.put("TV", 1000);
        map.put("Phone", 250);
        map.put("Watch", 50);

        sortMapElements(map);



    }
}
