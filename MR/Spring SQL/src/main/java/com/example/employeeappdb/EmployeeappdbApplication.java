package com.example.employeeappdb;

import com.example.employeeappdb.models.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// CommandLineRunner -> on application start, run method run() in application class
@SpringBootApplication
public class EmployeeappdbApplication implements CommandLineRunner {

  // @PersistenceContext -> will create EntityManager for us, we don't need to create it
  @PersistenceContext
  // EntityManager -> is used to manage entities (CRUD operations)
  private EntityManager entityManager;

  public static void main(String[] args) {
    SpringApplication.run(EmployeeappdbApplication.class, args);
  }

  // run() method is called on application start
  @Override
  // @Transactional -> this method is one transaction, queries are executed in this method
  @Transactional
  public void run(String... args) throws Exception {
    // we have 3 employees entities in a list...
    List<Employee> employees = new ArrayList<>(Arrays.asList(
        new Employee("Lukáš Kubec", "Hustej týpek", 15),
        new Employee("David Vomáčka", "Není hustej týpek", 38),
        new Employee("Franta Lojza", "Je to lojza", 45)
    ));

    // ... and we persist each of them in database (save them to database)
    employees.forEach(employee -> entityManager.persist(employee));
  }
}
