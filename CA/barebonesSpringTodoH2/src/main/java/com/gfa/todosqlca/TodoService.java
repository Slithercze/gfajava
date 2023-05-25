package com.gfa.todosqlca;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TodoService {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Todo> getAll() {
        return entityManager
                .createNativeQuery("select * from todo", Todo.class)
                .getResultList();
    }

    public Todo findByID(Long id) {
        return entityManager.find(Todo.class, id);
    }

    public Todo update(Todo t) {
        entityManager.merge(t);
        return t;
    }

    public Todo save(Todo t) {
        entityManager.persist(t);
        return t;
    }

    public void remove(Todo t) {
        entityManager.remove(t);
    }
}
