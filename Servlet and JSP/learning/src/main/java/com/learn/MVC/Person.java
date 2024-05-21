package com.learn.MVC;

import java.io.Serializable;

public class Person implements Serializable{

  private Integer id;
  private String nama;
  private Integer nim;
  private String alamat;
  
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public String getNama() {
    return nama;
  }
  public void setNama(String name) {
    this.nama = name;
  }
  public Integer getNim() {
    return nim;
  }
  public void setNim(Integer nim) {
    this.nim = nim;
  }
  public String getAlamat() {
    return alamat;
  }
  public void setAlamat(String alamat) {
    this.alamat = alamat;
  }
  @Override
  public String toString() {
    return "Person [id=" + id + ", nama=" + nama + ", nim=" + nim + ", alamat=" + alamat + "]";
  }

  
  
}
