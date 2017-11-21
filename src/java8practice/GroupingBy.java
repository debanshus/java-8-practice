package java8practice;

import common.Item;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GroupingBy {

    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
                new Item("apple", 40.4, 10),
                new Item("orange", 60.3, 20),
                new Item("kiwi", 37.1, 30),
                new Item("apple", 40.4, 70),
                new Item("pineapple", 76.2, 40),
                new Item("pineapple", 86.6, 50),
                new Item("orange", 70.3, 25));

        /*
        Summing up to double using Collectors
         */
        Double sum = items
                .stream()
                .collect(Collectors.summingDouble(item -> item.getPrice()));
        System.out.println(sum);

        /*
        Grouping by Collectors
         */
        items.stream()
                .collect(Collectors.groupingBy(item -> item.getName()))
                .forEach((k, v) -> System.out.println(k + " : " + v));

    }
}
