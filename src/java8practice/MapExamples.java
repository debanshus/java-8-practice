package java8practice;

import common.Item;
import common.Product;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MapExamples {

    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
                new Item("apple", 40.4, 10),
                new Item("orange", 60.3, 20),
                new Item("kiwi", 37.1, 30),
                new Item("apple", 40.4, 70),
                new Item("pineapple", 76.2, 40));

        /*
        1. Convering object of type Item to object of type Product using Map
        2. map method accepts a Function which is functional interface having
        one abstract method which takes a value of one type and returns a 
        result of another type.
         */
        List<Product> products = items
                .stream()
                .map(item -> new Product(item.getName(), item.getPrice()))
                .collect(Collectors.toList());

        /*
        Printing 
         */
        products.forEach((p) -> System.out.println(p));

        /*
        1. Converting object of type Item to object of type String using Map
         */
        Set<String> upperCaseNames = items
                .stream()
                .map(item -> item.getName().toUpperCase())
                .collect(Collectors.toSet());

        /*
        Printing 
         */
        upperCaseNames.forEach(System.out::println);

    }
}
