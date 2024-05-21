package com.exa;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
// @Table(name = "student_table")
// @Cacheable
// @Cache(usage =  CacheConcurrencyStrategy.READ_ONLY)
public class Student {

  @Id
  private int rollid;
  private String name;
  private int marks;
  @OneToMany(fetch = FetchType.EAGER, mappedBy = "student")
  private List<Laptop> laptop = new ArrayList<Laptop>();
  
  public int getRollid() {
    return rollid;
  }
  public void setRollid(int rollid) {
    this.rollid = rollid;
  }
  public String getName() {
    return name;
  }
  public void setName(String sname) {
    this.name = sname;
  }
  public int getMarks() {
    return marks;
  }
  public void setMarks(int marks) {
    this.marks = marks;
  }
  public List<Laptop> getLaptop() {
    return laptop;
  }
  public void setLaptop(List<Laptop> laptop) {
    this.laptop = laptop;
  }
  @Override
  public String toString() {
    return "Student [rollid=" + rollid + ", sname=" + name + ", marks=" + marks + "]";
  }  
}
