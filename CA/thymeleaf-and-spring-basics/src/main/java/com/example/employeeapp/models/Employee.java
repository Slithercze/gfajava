package com.example.employeeapp.models;

import org.springframework.stereotype.Component;

@Component
public class Employee {
  private String name;
  private String description;
  private Integer age;

  public Employee(String name, String description, Integer age) {
    this.name = name;
    this.description = description;
    this.age = age;
  }

  // Proč?
  public Employee() {}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }
}
