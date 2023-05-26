package com.gfa.todosqlca.repositories;

import com.gfa.todosqlca.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {
}
