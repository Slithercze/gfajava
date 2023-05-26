package com.gfa.todosqlca.repositories;

import com.gfa.todosqlca.models.Todo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TodoRepository extends CrudRepository<Todo, Long> {

    @Override
    List<Todo> findAll();
}
