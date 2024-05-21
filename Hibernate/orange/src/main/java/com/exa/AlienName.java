package com.exa;

import jakarta.persistence.Embeddable;

@Embeddable
public class AlienName {
  private String fname;
  private String midname;
  private String lname;
  
  public String getFname() {
    return fname;
  }
  public void setFname(String fname) {
    this.fname = fname;
  }
  public String getMidname() {
    return midname;
  }
  public void setMidname(String midname) {
    this.midname = midname;
  }
  public String getLname() {
    return lname;
  }
  public void setLname(String lname) {
    this.lname = lname;
  }
  @Override
  public String toString() {
    return "AlienName [fname=" + fname + ", midname=" + midname + ", lname=" + lname + "]";
  }
  
}
