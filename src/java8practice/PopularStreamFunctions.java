package java8practice;

import common.Product;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PopularStreamFunctions {

    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Apple", 50.0),
                new Product("Orange", 60.0),
                new Product("Kiwi", 45.0),
                new Product("Apple", 50.0),
                new Product("Apricot", 65.0),
                new Product("Walnut", 30.0),
                new Product("Blueberry", 15.0));

        /*
        forEach method which accepts a Consumer which is a functional 
        interface having one abstract method which takes one value and returns nothing.
         */
        products.forEach(p -> System.out.println(p));

        /*
        filter method acceps a Predicate which is functional interface having
        one abstract method which takes one value and returns a boolean.
         */
        products.stream()
                .filter(p -> p.getName().startsWith("A"))
                .forEach(p -> System.out.println(p));

        /*
        count is a terminal method which return the count of the elements 
        in the stream on which the count method is called
         */
        long count = products.stream()
                .filter(p -> p.getName().startsWith("A"))
                .count();
        System.out.println("Count = " + count);

        /*
        map method accepts a Function which is functional interface having
        one abstract method which takes a value of one type and returns a result of another type.
        here, p -> p.getName().toUpperCase() is a lambda expression representing 
        a method which accepts value of type Person and return value of type String.
         */
        products.stream()
                .map(p -> p.getName().toUpperCase())
                .forEach(n -> System.out.println(n));

        /*
        reduce method accepts an Identity, which is the initial value of the 
        reduction operation to be performed and a BinaryOperator interface having
        one abstract method which takes two values of the same type and returns 
        a value of the same type.
         */
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer sum = numbers
                .stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println("Sum = " + sum);

        /*
        Since the initial value is 0, the whole product is 0
         */
        Integer product = numbers
                .stream()
                .reduce(0, (a, b) -> a * b);
        System.out.println("Product = " + product);

        /*
        allMatch returns true if every element in the stream matches the 
        predicate condition
         */
        if (products.stream().allMatch(p -> p.getPrice() != null)) {
            System.out.println("Price is not is empty");
        }

        /*
        anyMatch returns true if every element in the stream matches the 
        predicate condition
         */
        if (products.stream().anyMatch(p -> p.getName().equals("apple"))) {
            System.out.println("Has Apple");
        }

        /*
        distinct removes the duplicate object from the stream
        in the Product class if we remove the equals & hashcode method, then
        this distinct does remove the 2 apple's object added in the list as they 
        are 2 different object
         */
        products.stream().distinct().forEach(System.out::println);

        /*
        Collects the stream elements to string joined with the delimeter passed
        */
        String string = products
                .stream()
                .map(p -> p.getName())
                .collect(Collectors.joining(" , "));
        System.out.println("Joined String: " + string);

    }
}
