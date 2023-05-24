package com.gfa.todosqlca;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/")
    public ResponseEntity index() {
        List<Todo> todos = entityManager
                .createNativeQuery("select * from todo", Todo.class)
                .getResultList();

        return ResponseEntity.status(HttpStatus.OK).body(todos);
    }

    @PostMapping("/")
    @Transactional
    public ResponseEntity add(@RequestBody Todo t) {
        if (t.isDone() == null || t.isUrgent() == null || t.getTitle() == null) {
            return ResponseEntity.status(400).body(t);
        }
        entityManager.persist(t);

        return ResponseEntity.status(201).body(t);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity update(@PathVariable Long id, @RequestBody Todo todo) {
        Todo oldTodo = entityManager.find(Todo.class, id);

        if (oldTodo == null) {
            return ResponseEntity.status(400).body("Invalid ID");
        }

        todo.setId(id); // we better use the one from the path, as defined by REST
        entityManager.merge(todo);

        return ResponseEntity.status(202).body(todo);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {

        Todo t = entityManager.find(Todo.class, id);

        if (t != null) {
            entityManager.remove(t);
        }

        return ResponseEntity.status(200).body("okacko");
    }
}
