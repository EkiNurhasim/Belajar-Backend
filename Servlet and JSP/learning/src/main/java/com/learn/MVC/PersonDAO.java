package com.learn.MVC;

import java.sql.*;

public class PersonDAO{

  private Connection con;
  private final String url = "jdbc:mysql://localhost/db_mahasiswa";
  private final String user = "root";
  private final String pass = "";


  public int addPerson(Person person){
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      con = DriverManager.getConnection(url, user, pass);
      PreparedStatement ps = con.prepareStatement("insert into tb_mahasiswa values (?,?,?,?)");
      ps.setInt(1, person.getId());
      ps.setString(2, person.getNama());
      ps.setInt(3, person.getNim());
      ps.setString(4, person.getAlamat());
      return ps.executeUpdate();    
      
    } catch (Exception e) {
      System.out.println(e);
    }
    return 0;    
  }

  public Person showPerson(int id){
    
    Person person = new Person();

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      con = DriverManager.getConnection(url, user, pass);
      PreparedStatement ps = con.prepareStatement("select * from tb_mahasiswa where id = " + id);
      ResultSet result = ps.executeQuery();
      
      if(result.next()){
        person.setId(result.getInt("id"));
        person.setNama(result.getString("nama"));
        person.setNim(result.getInt("nim"));
        person.setAlamat(result.getString("alamat"));
      }

    } catch (Exception e) {      
      System.out.println(e.getMessage());
    }
    return person;
  }
}
