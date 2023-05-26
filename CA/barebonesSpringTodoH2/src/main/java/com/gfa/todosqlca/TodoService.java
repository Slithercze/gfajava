package com.gfa.todosqlca;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
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

    // for science!
    @Transactional
    public Todo create(String title) {
        return create(title, false);
    }

    @Transactional
    public Todo create(String title, boolean isUrgent) {
        Todo t = new Todo();
        t.setTitle(title);
        t.setIsUrgent(isUrgent);
        t.setIsDone(false);

        entityManager.persist(t);
        return t;
    }

    public Todo findByID(Long id) {
        return entityManager.find(Todo.class, id);
    }

    @Transactional
    public Todo update(Todo t) {
        entityManager.merge(t);
        return t;
    }

    @Transactional
    public Todo save(Todo t) {
        entityManager.persist(t);
        return t;
    }

    @Transactional
    public void remove(Todo t) {
        entityManager.remove(t);
    }
}
