package com.ekiasari;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        ProductService service = new ProductService();
        // service.addProduct(new Product("Asus Vivobook", "Laptop", "White Table",
        // 2023));
        // service.addProduct(new Product("Asus ROG", "Laptop", "Chair", 2013));
        // service.addProduct(new Product("HP", "Laptop", "Bookshelf", 2022));
        // service.addProduct(new Product("LG TV", "Televisin", "Wall", 2021));
        // service.addProduct(new Product("Book of Java", "Book", "Table", 2019));
        // service.addProduct(new Product("Asus Zenfone", "Smartphone", "Armchair",
        // 2017));

        // List<Product> products = service.getAllProducts();
        // for (Product item : products) {
        // System.out.println(item);
        // }

        // System.out.println("=============================================================");

        // Product p1 = service.getProduct(12);
        // System.out.println(p1);

        System.out.println("=============================================================");

        List<Product> p2 = service.getProductWithText("Laptop");
        for (Product item : p2) {
            System.out.println(item);
        }
    }
}