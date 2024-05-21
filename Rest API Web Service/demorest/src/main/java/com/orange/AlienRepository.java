package com.orange;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AlienRepository {

  // List<Alien> aliens;
  Connection con = null;

  public AlienRepository() 
  {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://localhost/restdb", "root", "");
    } catch (Exception e) {      
      System.out.println(e.getMessage());
    }
  }

  public List<Alien> getAliens()
  {
    List<Alien> aliens = new ArrayList<>();
    try {
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery("select * from alien");
      while (rs.next()) {
        Alien a = new Alien();
        a.setId(rs.getInt(1));
        a.setName(rs.getString(2));
        a.setPoints(rs.getInt(3));
        
        aliens.add(a);
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return aliens;
  }

  public Alien getAlien(int id)
  {
    Alien alien = new Alien();
    try {
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery("select * from alien where id = " + id);
      if(rs.next()){
        alien.setId(rs.getInt(1));
        alien.setName((rs.getString(2)));
        alien.setPoints(rs.getInt(3));
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return alien;
  }

  public void createAlien(Alien a1) 
  {
    try {
        PreparedStatement ps = con.prepareStatement("insert into alien values(?,?,?)");
        ps.setInt(1, a1.getId());
        ps.setString(2, a1.getName());
        ps.setInt(3, a1.getPoints());
        ps.executeUpdate();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void updateAlien(Alien a1)
  {
    try {
      PreparedStatement ps = con.prepareStatement("update alien set name=?, points=? where id=?");
      ps.setString(1, a1.getName());
      ps.setInt(2, a1.getPoints());
      ps.setInt(3, a1.getId());
      ps.executeUpdate();
      
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void deleteAlien(int id) 
  {
    try {
      PreparedStatement ps = con.prepareStatement("delete from alien where id = ?");
      ps.setInt(1, id);      
      ps.executeUpdate();
  } catch (Exception e) {
    System.out.println(e.getMessage());
  }
  }

}
