package java8practice;

import common.Product;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ReuseStream {

    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Apple", 50.0),
                new Product("Orange", 60.0),
                new Product("Kiwi", 45.0),
                new Product("Apricot", 65.0),
                new Product("Walnut", 30.0),
                new Product("Blueberry", 15.0));

        /*
        Prints the Products to the console using Method references
        But reusing the stream to print the Names will 
        throw java.lang.IllegalStateException
         */
        Stream<Product> stream = products.stream();
        stream.forEach(System.out::println);
        stream.forEach((p) -> System.out.println(p.getName()));

        /*
        Using Supplier functional interface we can get a supplier of stream,
        which gives us a new stream every time we cal get()
         */
        Supplier<Stream<List<Product>>> streamSupplier = () -> Stream.of(products);

        streamSupplier.get().forEach(System.out::println);

        streamSupplier.get().forEach((p) -> {
            p.forEach(System.out::println);
        });

    }
}
