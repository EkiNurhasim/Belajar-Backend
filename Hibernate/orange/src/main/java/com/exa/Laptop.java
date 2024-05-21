package com.exa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Laptop {

  @Id
  private int lid;
  private String lname;
  @ManyToOne
  private Student student;
  
  public int getLid() {
    return lid;
  }
  public void setLid(int lid) {
    this.lid = lid;
  }
  public String getLname() {
    return lname;
  }
  public void setLname(String lname) {
    this.lname = lname;
  }
  public Student getStudent() {
    return student;
  }
  public void setStudent(Student student) {
    this.student = student;
  }
  @Override
  public String toString() {
    return "Laptop [lid=" + lid + ", lname=" + lname + "]";
  }
  
}
