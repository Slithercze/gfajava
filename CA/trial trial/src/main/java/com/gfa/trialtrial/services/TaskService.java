package com.gfa.trialtrial.services;

import com.gfa.trialtrial.models.Task;
import java.util.List;
import java.util.Optional;

public interface TaskService {

  Task save(Task task);

  List<Task> getAll();

  List<Task> getByType(String type);

  Optional<Task> delete(Long id);

  boolean typeExist(String type);
}
