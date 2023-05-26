package com.gfa.todosqlca.controllers;

import com.gfa.todosqlca.services.TodoService;
import com.gfa.todosqlca.services.TodoServiceRepositoryImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class WebController {

    private TodoService todoService;

    public WebController(@Qualifier("todoServiceRepositoryImpl") TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("todos", todoService.getAll());
        return "index";
    }

    @PostMapping("add")
    public String add(@RequestParam String title, @RequestParam Optional<Boolean> isUrgent) {
        todoService.create(title, isUrgent.orElse(false));
        return "redirect:/";
    }
}
