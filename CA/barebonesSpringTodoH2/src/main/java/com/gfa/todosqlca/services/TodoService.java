package com.gfa.todosqlca.services;

import com.gfa.todosqlca.models.Todo;
import jakarta.transaction.Transactional;

import java.util.List;

public interface TodoService {
    List<Todo> getAll();

    // for science!
    @Transactional
    Todo create(String title);

    @Transactional
    Todo create(String title, boolean isUrgent);

    Todo findByID(Long id);

    @Transactional
    Todo update(Todo t);

    @Transactional
    Todo save(Todo t);

    @Transactional
    void remove(Todo t);
}
