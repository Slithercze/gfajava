package com.gfa.todosqlca.services;

import com.gfa.todosqlca.Todo;
import com.gfa.todosqlca.services.TodoService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TodoServiceEntityImpl implements TodoService {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Todo> getAll() {
        return entityManager
                .createNativeQuery("select * from todo", Todo.class)
                .getResultList();
    }

    // for science!
    @Override
    @Transactional
    public Todo create(String title) {
        return create(title, false);
    }

    @Override
    @Transactional
    public Todo create(String title, boolean isUrgent) {
        Todo t = new Todo();
        t.setTitle(title);
        t.setIsUrgent(isUrgent);
        t.setIsDone(false);

        entityManager.persist(t);
        return t;
    }

    @Override
    public Todo findByID(Long id) {
        return entityManager.find(Todo.class, id);
    }

    @Override
    @Transactional
    public Todo update(Todo t) {
        entityManager.merge(t);
        return t;
    }

    @Override
    @Transactional
    public Todo save(Todo t) {
        entityManager.persist(t);
        return t;
    }

    @Override
    @Transactional
    public void remove(Todo t) {
        entityManager.remove(t);
    }
}
