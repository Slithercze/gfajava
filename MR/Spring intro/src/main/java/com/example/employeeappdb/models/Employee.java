package com.example.employeeappdb.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// database entity has to have @Entity and @Id
@Entity
// @Table = name of table for this entity, optional
@Table(name = "employees")
public class Employee {
  // @Id = primary key
  @Id
  // @Generated value = e.g. "auto increment"
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  // @Column = optional
  @Column(name = "id", nullable = false)
  private Long id;

  private String name;
  private String description;
  private Integer age;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Employee(String name, String description, Integer age) {
    this.name = name;
    this.description = description;
    this.age = age;
  }

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
