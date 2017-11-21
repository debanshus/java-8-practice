package java8practice;

import common.Item;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapOperations {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("One", 1);
        map.put("Five", 5);
        map.put("Four", 4);
        map.put("Six", 6);
        map.put("Three", 3);
        map.put("Two", 2);

        List<Item> items = Arrays.asList(
                new Item("apple", 40.4, 10),
                new Item("orange", 60.3, 20),
                new Item("kiwi", 37.1, 30),
                new Item("apple", 42.4, 70),
                new Item("pineapple", 76.2, 40));

        /*
        Sorting a map using the natural ordering of keys
         */
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(System.out::println);
        System.out.println();

        /*
        Sorting a map using the natural ordering of values
         */
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);
        System.out.println();

        /*
        Sorting a map using the natural ordering of keys
        Collecting the resulting map into a new LinkedHashMap
        Removing duplicate values
         */
        Map<String, Integer> newMap = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        newMap.entrySet().stream().forEach(System.out::println);
        System.out.println();

        /*
        Converting a list to map
        Removing duplicate values
         */
        Map<String, Double> listToMap = items
                .stream()
                .collect(Collectors.toMap(Item::getName, Item::getPrice, (oldValue, newValue) -> oldValue));

        listToMap.entrySet().stream().forEach(System.out::println);
        System.out.println();

        /*
        Converting map keys to List, similarly we can do for map.values()
         */
        List<String> mapToList = map.keySet()
                .stream()
                .collect(Collectors.toList());
        mapToList.forEach(System.out::println);

    }
}
