package com.example.employeeappdb.controllers;

import com.example.employeeappdb.models.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class WebController {
  @PersistenceContext
  private EntityManager entityManager;

  @SuppressWarnings("unchecked")
  @GetMapping("/")
  public String index(Model model, @RequestParam Optional<Integer> age) {
    List<Employee> employees;

    if(age.isPresent()) {
      // select employees older than age
      employees = entityManager.createNativeQuery("SELECT * FROM employees e WHERE e.age > ?", Employee.class)
          .setParameter(1, age.get())
          .getResultList();
    } else {
      // select all employees
      employees = entityManager.createNativeQuery("SELECT * FROM employees", Employee.class)
          .getResultList();
    }

    age.ifPresent(a -> model.addAttribute("age", a));
    model.addAttribute("employees", employees);
    return "index";
  }

  @PostMapping("/add-employee")
  @Transactional
  public String addEmployee(@ModelAttribute Employee employee,
                            RedirectAttributes redirectAttributes) {
    // save one employee
    entityManager.persist(employee);
    redirectAttributes.addAttribute("id", employee.getId());
    return "redirect:/{id}";
  }

  @GetMapping("/{id}")
  public String detail(Model model, @PathVariable Long id) {
    // select one employee with id...
    Employee employee = entityManager.find(Employee.class, id);
    model.addAttribute("employee", employee);
    return "detail";
  }
}
