package com.learn;

public class ProfileObject {

  String name;
  int age;
  String address;
  
  public ProfileObject(String name, int age, String address) {
    this.name = name;
    this.age = age;
    this.address = address;
  }
  
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }
  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }
  @Override
  public String toString() {
    return "ProfileObject [name=" + name + ", age=" + age + ", address=" + address + "]";
  }

  
  
}
