package com.ekiasari;

import java.util.List;

public class ProductService {

  ProductDB db = new ProductDB();

  public void addProduct(Product p) {
    db.save(p);
  }

  public List<Product> getAllProducts() {
    return db.getAll();
  }

  public Product getProduct(int id) {
    return db.getProductById(id);
  }

  public List<Product> getProductWithText(String name) {
    return db.getProductByText(name);
  }

}
