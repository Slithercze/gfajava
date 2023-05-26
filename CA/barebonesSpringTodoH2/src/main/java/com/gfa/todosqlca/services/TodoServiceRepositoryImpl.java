package com.gfa.todosqlca.services;

import com.gfa.todosqlca.models.Todo;
import com.gfa.todosqlca.repositories.TodoRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceRepositoryImpl implements TodoService {
//    @PersistenceContext
//    private EntityManager entityManager;


//    private TodoRepository todoRepository;
    private CrudRepository<Todo, Long> todoRepository;

    public TodoServiceRepositoryImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public Iterable<Todo> getAll() {
        return todoRepository.findAll();
    }

    // for science!
    @Override
    public Todo create(String title) {
        return create(title, false);
    }

    @Override
    public Todo create(String title, boolean isUrgent) {
        Todo t = new Todo();
        t.setTitle(title);
        t.setIsUrgent(isUrgent);
        t.setIsDone(false);

        return todoRepository.save(t);
    }

    @Override
    public Todo findByID(Long id) {
        return todoRepository.findById(id).orElse(null);
    }

    @Override
    public Todo update(Todo t) {
        save(t);
        return t;
    }

    @Override
    @Transactional
    public Todo save(Todo t) {
        todoRepository.save(t);
        return t;
    }

    @Override
    @Transactional
    public void remove(Todo t) {
        todoRepository.delete(t);
    }
}
