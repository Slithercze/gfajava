package com.gfa.trialtrial.repositories;

import com.gfa.trialtrial.models.Task;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {

  List<Task> findAll();

  List<Task> findByType(String type);
}
