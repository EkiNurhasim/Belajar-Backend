package com.example;

import java.sql.*;

public class StudentDAO {

  private Connection con;

  public void connect(){
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://localhost/db_mahasiswa", "root", "");
    } catch (Exception e) {
      System.out.println(e);
    }      
  }

  public void connectClose()
  {
    try {
      con.close();
    } catch (SQLException e) {
      System.out.println(e);
    }
  }

  public void getAllStudent(){
    try {      
      String query = "select * from tb_mahasiswa";
      Statement statement = con.createStatement();
      ResultSet result = statement.executeQuery(query);

      while (result.next()) {
        String data = result.getInt(1) + " | " + result.getString(2) + " | " + result.getInt(3) + " | " + result.getString(4);
        System.out.println(data);
      }
    } catch (SQLException e) {
      System.out.println(e);
    }    
  }

  public Student getStudentById(int id){
    
    try {
      String query = "select * from tb_mahasiswa where id  =" + id;
      Student student = new Student();
      student.id = id;

      Statement statement = con.createStatement();
      ResultSet res = statement.executeQuery(query);
      res.next();
      student.nama = res.getString(2);
      student.nim = res.getInt(3);
      student.alamat = res.getString(4);

      return student;

    } catch (SQLException e) {
      System.out.println(e);
    }

    return null;
  }

  public void addStudent(Student student){
    try {
      String query = "insert into tb_mahasiswa values (?,?,?,?)";
      PreparedStatement ps = con.prepareStatement(query);
      ps.setInt(1, student.id);
      ps.setString(2, student.nama);
      ps.setInt(3, student.nim);
      ps.setString(4, student.alamat);
      ps.executeUpdate();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void updateStudent(int id, Student student){
    try {
      String query = "update tb_mahasiswa set id=?, nama=?, nim=?, alamat=? where id = " + id;
      student.id = id;
      PreparedStatement ps = con.prepareStatement(query);
      ps.setInt(1, id);
      ps.setString(2, student.nama);
      ps.setInt(3, student.nim);
      ps.setString(4, student.alamat);
      ps.executeUpdate();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void deleteStudent(int id){
    try {
      String query = "delete from tb_mahasiswa where id = " + id;
      PreparedStatement ps = con.prepareStatement(query);
      ps.executeUpdate();
    } catch (SQLException e) {
      System.out.println(e);
    }
  }

}
