package com.ekiasari;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDB {

  Connection con = null;

  public ProductDB() {
    try {
      con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "122");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void save(Product p) {

    String query = "insert into product (name, type, place, warranty) values (?,?,?,?)";
    try {
      PreparedStatement ps = con.prepareStatement(query);
      ps.setString(1, p.getName());
      ps.setString(2, p.getType());
      ps.setString(3, p.getPlace());
      ps.setInt(4, p.getWarranty());
      ps.execute();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public List<Product> getAll() {
    List<Product> products = new ArrayList<>();
    String query = "select name, type, place, warranty from product";
    try {
      PreparedStatement ps = con.prepareStatement(query);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        Product p = new Product();
        p.setName(rs.getString(1));
        p.setType(rs.getString(2));
        p.setPlace(rs.getString(3));
        p.setWarranty(rs.getInt(4));
        products.add(p);
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return products;
  }

  public Product getProductById(int id) {
    String query = "select name, type, place, warranty from product where id = " + id;
    try {
      PreparedStatement ps = con.prepareStatement(query);
      ResultSet rs = ps.executeQuery();
      rs.next();
      Product p = new Product();
      p.setName(rs.getString(1));
      p.setType(rs.getString(2));
      p.setPlace(rs.getString(3));
      p.setWarranty(rs.getInt(4));
      return p;
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return null;
  }

  public List<Product> getProductByText(String str) {
    String query = "select name, type, place, warranty from product where name LIKE '%" + str + "%' OR type LIKE '%"
        + str + "%' OR place LIKE '%"
        + str + "%'";
    List<Product> products = new ArrayList<>();

    try {
      PreparedStatement ps = con.prepareStatement(query);
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        Product p = new Product();
        p.setName(rs.getString(1));
        p.setType(rs.getString(2));
        p.setPlace(rs.getString(3));
        products.add(p);
      }
      return products;

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return products;
  }

}
