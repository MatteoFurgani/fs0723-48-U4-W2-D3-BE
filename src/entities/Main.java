package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //---------------------------------------ESERCIZIO1---------------------------------------

        System.out.println("--------------ESERCIZIO1--------------");

        List<Product> products = new ArrayList<>();
        products.add(new Product(1L, "Book1", "Books", 115.0));
        products.add(new Product(2L, "Book2", "Books", 100.0));
        products.add(new Product(3L, "Book3", "Books", 75.0));
        products.add(new Product(4L, "Book4", "Books", 120.0));
        products.add(new Product(5L, "Book5", "Books", 50.0));

        List<Product> filteredProducts = products.stream().filter(product -> product.getCategory().equals("Books")).filter(product -> product.getPrice() > 100.0).collect(Collectors.toList());

        filteredProducts.forEach(product -> System.out.println(product.getName() + " - " + product.getPrice()));

        //---------------------------------------ESERCIZIO2---------------------------------------

        System.out.println("--------------ESERCIZIO2--------------");

    }
}
