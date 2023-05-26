package com.gfa.todosqlca.services;

import com.gfa.todosqlca.models.Todo;
import jakarta.transaction.Transactional;

public interface TodoService {
    Iterable<Todo> getAll();

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
