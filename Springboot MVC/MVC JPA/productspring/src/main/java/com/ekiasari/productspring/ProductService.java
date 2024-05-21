package com.ekiasari.productspring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  @Autowired
  ProductDB db;

  public List<Product> getAllProducts() {
    return db.findAll();
  }

  public Product getProduct(int id) {
    return null;
  }

  public List<Product> getProductWithText(String name) {
    return null;
  }

  public void addProduct(Product p) {
    // db.save(p);
  }
}
