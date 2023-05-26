package com.gfa.todosqlca.controllers;

import com.gfa.todosqlca.models.Todo;
import com.gfa.todosqlca.services.TodoService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
public class ApiController {
    private TodoService todoService;

    public ApiController(@Qualifier("todoServiceRepositoryImpl") TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity index() {
        List<Todo> todos = todoService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(todos);
    }

    @PostMapping
    public ResponseEntity add(@RequestBody Todo t) {
        if (t.isDone() == null || t.isUrgent() == null || t.getTitle() == null) {
            return ResponseEntity.status(400).body(t);
        }
        todoService.save(t);

        return ResponseEntity.status(201).body(t);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody Todo todo) {
        Todo oldTodo = todoService.findByID(id);

        if (oldTodo == null) {
            return ResponseEntity.status(400).body("Invalid ID");
        }

        todo.setId(id); // we better use the one from the path, as defined by REST

        todoService.update(todo);

        return ResponseEntity.status(202).body(todo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        Todo t = todoService.findByID(id);

        if (t != null) {
            todoService.remove(t);
        }

        return ResponseEntity.status(200).body("okacko");
    }
}
