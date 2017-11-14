package java8practice;

import java.util.Arrays;
import java.util.List;

public class LambdaPractice2 {

    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Apple", 50),
                new Product("Orange", 60),
                new Product("Kiwi", 45),
                new Product("Apricot", 65),
                new Product("Walnut", 30),
                new Product("Blueberry", 15));

        //forEach method which accepts a Consumer which is a functional 
        //interface having one abstract method which takes one value and returns nothing.
        products.forEach(p -> System.out.println(p));

        //filter method acceps a Predicate which is functional interface having
        //one abstract method which takes one value and returns a boolean.
        products.stream()
                .filter(p -> p.getName().startsWith("A"))
                .forEach(p -> System.out.println(p));

        //count is a terminal method which return the count of the elements 
        //in the stream on which the count method is called
        long count = products.stream()
                .filter(p -> p.getName().startsWith("A"))
                .count();
        System.out.println("Count = " + count);

        //map method accepts a Function which is functional interface having
        //one abstract method which takes a value and returns a result.
        //here, p -> p.getName().toUpperCase() is a lambda expression representing 
        //a method which accepts value of type Person and return value of type String.
        products.stream()
                .map(p -> p.getName().toUpperCase())
                .forEach(n -> System.out.println(n));

        //reduce method accepts an Identity, which is the initial value of the 
        //reduction operation to be performed and a BinaryOperator interface having
        //one abstract method which takes two values of the same type and returns 
        //a value of the same type.
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer sum = numbers.stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println("Sum = " + sum);

        //Since the initial value is 0, the whole product is 0
        Integer product = numbers.stream()
                .reduce(0, (a, b) -> a * b);
        System.out.println("Product = " + product);

    }
}
