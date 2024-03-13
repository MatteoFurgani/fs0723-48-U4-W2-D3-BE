package entities;

import java.time.LocalDate;
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
        products.add(new Product(5L, "Book5", "Fumetti", 150.0));

        List<Product> filteredProducts = products.stream().filter(product -> product.getCategory().equals("Books"))
                .filter(product -> product.getPrice() > 100.0).collect(Collectors.toList());

        filteredProducts.forEach(product -> System.out.println(product.getName() + " - " + product.getPrice()));

        //---------------------------------------ESERCIZIO2---------------------------------------

        System.out.println("--------------ESERCIZIO2--------------");

        Product product1 = new Product(1L, "Pannolini", "Baby", 15.0);
        Product product2 = new Product(2L, "Omogeneizzati", "Baby", 9.0);
        Product product3 = new Product(4L, "Peluche", "Giochi", 20.0);

        Customer customer1 = new Customer(1L, "Mario", 1);
        Customer customer2 = new Customer(2L, "Luigi", 2);

        List<Product> products1 = new ArrayList<>();
        products1.add(product1);
        products1.add(product2);

        Order order1 = new Order(1L, "In Transito", LocalDate.of(2024,3,2),
                LocalDate.of(2024,3,25), products1, customer1);

        List<Product> products2 = new ArrayList<>();
        products2.add(product3);

        Order order2 = new Order(2L, "Consegnato", LocalDate.of(2024,2,28),
                LocalDate.of(2024,3,12), products2, customer2);

        List<Order> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);

        List<Order> filteredOrders = orders.stream().filter(order -> order.getProducts().stream()
                .anyMatch(product -> "Baby".equals(product.getCategory()))).collect(Collectors.toList());

        System.out.println("Ordini categoria Baby:");
        for (Order order : filteredOrders) {
            System.out.println("ID ordine: " + order.getId());
            System.out.println("Stato: " + order.getStatus());
            System.out.println("Data aquisto: " + order.getOrderDate());
            System.out.println("Data consegna: " + order.getDeliveryDate());
            System.out.println("Prodotti:");
            for (Product product : order.getProducts()) {
                System.out.println("- " + product.getName() + " (" + product.getCategory() + ")");
            }
            System.out.println("Cliente: " + order.getCustomer().getName());
            System.out.println();
        }

        //---------------------------------------ESERCIZIO3---------------------------------------

        System.out.println("--------------ESERCIZIO3--------------");

        Product prodotto1 = new Product(1L, "Divisa calcio", "Boys", 65.0);
        Product prodotto2 = new Product(2L, "Scarpini", "Boys", 110.0);
        Product prodotto3 = new Product(3L, "Guanti", "Boys", 40.0);
        Product prodotto4 = new Product(4L, "Trucchi", "Girls", 65.0);
        Product prodotto5 = new Product(5L, "Giocattoli", "Toys", 55.0);

        List<Product> productList = new ArrayList<>();
        productList.add(prodotto1);
        productList.add(prodotto2);
        productList.add(prodotto3);
        productList.add(prodotto4);
        productList.add(prodotto5);

        List<String> boysProducts = productList.stream()
                .filter(product -> "Boys".equals(product.getCategory())).map(product -> {
                    double discountedPrice = product.getPrice() * 0.9;
                    return "- " + product.getName() + " " + product.getPrice() + ", prezzo scontato(10%): " + discountedPrice;
                }).collect(Collectors.toList());


        System.out.println("Prodotti Boys:");
        for (String product : boysProducts) {
            System.out.println(product);
        }

        //---------------------------------------ESERCIZIO4---------------------------------------

        System.out.println("--------------ESERCIZIO4--------------");

        Product articolo1 = new Product(1L, "Televisore", "Elettronica", 980.0);
        Product articolo2 = new Product(2L, "Telefono Samsung", "Telefonia", 750.0);
        Product articolo3 = new Product(3L, "lavatrice", "Elettronica", 400.0);
        Product articolo4 = new Product(4L, "Asciugatrice", "Elettronica", 400.0);
        Product articolo5 = new Product(5L, "Soundbar", "Elettronica", 220.0);

        Customer cliente1 = new Customer(1L, "Carlo", 2);
        Customer cliente2 = new Customer(2L, "Davide", 4);
        Customer cliente3 = new Customer(3L, "Giulio", 2);

        List<Product> prodotti1 = new ArrayList<>();
        prodotti1.add(articolo1);
        prodotti1.add(articolo2);

        Order ordine1 = new Order( 1L, "Consegnato", LocalDate.of(2021,3,15),
                LocalDate.of(2021,3,19), prodotti1, cliente1);

        List<Product> prodotti2 = new ArrayList<>();
        prodotti2.add(articolo3);
        prodotti2.add(articolo4);

        Order ordine2 = new Order( 2L, "Consegnato", LocalDate.of(2021,2,21),
                LocalDate.of(2021,2,25), prodotti2, cliente2);

        List<Product> prodotti3 = new ArrayList<>();
        prodotti3.add(articolo5);

        Order ordine3 = new Order( 3L, "In Transito", LocalDate.of(2021,5,5),
                LocalDate.of(2021,5,14), prodotti3, cliente3);

        List<Order> ordini = new ArrayList<>();
        ordini.add(ordine1);
        ordini.add(ordine2);
        ordini.add(ordine3);


        System.out.println("Prodotti ordinati da clienti di livello 2 tra il 01-Feb-2021 e il 01-Apr-2021:");
        for (Order order : ordini) {
            if (order.getCustomer().getTier() == 2 && order.getOrderDate().isAfter(LocalDate.of(2021, 1, 31))
                    && order.getOrderDate().isBefore(LocalDate.of(2021, 4, 2))) {
                System.out.println("Cliente: " + order.getCustomer().getName());
                for (Product product : order.getProducts()) {
                    System.out.println("- " + product.getName() + " (" + product.getCategory() + ")");
                }
            }
        }




    }
}
