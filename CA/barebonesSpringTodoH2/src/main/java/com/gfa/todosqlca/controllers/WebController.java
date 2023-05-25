package com.gfa.todosqlca.controllers;

import com.gfa.todosqlca.Todo;
import com.gfa.todosqlca.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class WebController {

    private TodoService todoService;

    public WebController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("todos", todoService.getAll());
        return "index";
    }

    @PostMapping("add")
    public String add(@RequestParam String title) {
        todoService.create(title);
        return "redirect:/";
    }
}
