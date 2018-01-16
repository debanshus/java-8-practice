package java8practice;

import common.Product;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Pipelining {

    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Apple", 50.0),
                new Product("Orange", 60.0),
                new Product("Kiwi", 45.0),
                new Product("Apple", 50.0),
                new Product("Apricot", 65.0),
                new Product("Walnut", 30.0),
                new Product("Blueberry", 15.0));

        products.stream()
                .filter(p -> {
                    System.out.println("Filtering " + p);
                    return p.getPrice() > 50;
                })
                .map(p -> {
                    System.out.println("Mapping " + p);
                    return p.getName();
                })
                .collect(Collectors.toSet());

        /*
        Output would be :
        Filtering Product{name=Apple, price=50.0}
        Filtering Product{name=Orange, price=60.0}
        Mapping Product{name=Orange, price=60.0}
        Filtering Product{name=Kiwi, price=45.0}
        Filtering Product{name=Apple, price=50.0}
        Filtering Product{name=Apricot, price=65.0}
        Mapping Product{name=Apricot, price=65.0}
        Filtering Product{name=Walnut, price=30.0}
        Filtering Product{name=Blueberry, price=15.0}
        
        Which shows that the filter and map is working on the stream of elements
        in a pipeline way i.e one at a time. 
         */
    }
}
