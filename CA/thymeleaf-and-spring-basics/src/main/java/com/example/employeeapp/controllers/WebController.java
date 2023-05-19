package com.example.employeeapp.controllers;

import com.example.employeeapp.models.Employee;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
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
  private List<Employee> employees = new ArrayList<>(Arrays.asList(
      new Employee("Lukáš Kubec", "Hustej týpek", 15),
      new Employee("David Vomáčka", "Není hustej týpek", 38),
      new Employee("Franta Lojza", "Je to lojza", 45)
  ));

  @GetMapping("/")
  public String index(Model model, @RequestParam Optional<Integer> age) {
    List<Employee> result = new ArrayList<>();

    age.ifPresentOrElse(
        a -> result.addAll(
            employees.stream().filter(e -> e.getAge() > a).toList()),
        () -> result.addAll(employees)
    );

    age.ifPresent(a -> model.addAttribute("age", a));
    model.addAttribute("employees", result);
    return "index";
  }

  @PostMapping("/add-employee")
  public String addEmployee(Model model, @ModelAttribute Employee employee,
                            RedirectAttributes redirectAttributes) {
    employees.add(employee);
    model.addAttribute("employees", employees);

    redirectAttributes.addAttribute("id", employees.size());
    return "redirect:/{id}";
  }

  @GetMapping("/{id}")
  public String detail(Model model, @PathVariable Integer id) {
    model.addAttribute("employee", employees.get(id - 1));
    return "detail";
  }
}
