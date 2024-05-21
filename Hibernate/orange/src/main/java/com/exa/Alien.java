package com.exa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "alien_table")
public class Alien {

  @Id
  @Column(name = "alien_id")
  private int aid;

  // @Transient // dont store this to database
  @Column(name = "alien_name")
  private AlienName aname;

  @Column(name = "alien_color")
  private String color;
  
  public int getAid() {
    return aid;
  }
  public void setAid(int aid) {
    this.aid = aid;
  }
  public AlienName getAname() {
    return aname;
  }
  public void setAname(AlienName aname) {
    this.aname = aname;
  }
  public String getColor() {
    return color;
  }
  public void setColor(String color) {
    this.color = color;
  }
  @Override
  public String toString() {
    return "Alien [aid=" + aid + ", aname=" + aname + ", color=" + color + "]";
  }
}
