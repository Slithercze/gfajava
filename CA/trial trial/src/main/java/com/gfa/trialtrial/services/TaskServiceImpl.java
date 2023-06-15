package com.gfa.trialtrial.services;

import com.gfa.trialtrial.models.Task;
import com.gfa.trialtrial.repositories.TaskRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService{

  private final List<String> types = List.of("shopping list", "reminder", "motivational");
  private final TaskRepository taskRepository;

  @Autowired
  public TaskServiceImpl(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  @Override
  public Task save(Task task) {
    return taskRepository.save(task);
  }

  @Override
  public List<Task> getAll() {
    return taskRepository.findAll();
  }

  @Override
  public List<Task> getByType(String type) {
    return taskRepository.findByType(type);
  }

  @Override
  public Optional<Task> delete(Long id) {
    Optional<Task> task = taskRepository.findById(id);
    if (task.isPresent()) {
      taskRepository.delete(task.get());
    }
    return task;
  }

  @Override
  public boolean typeExist(String type) {
    return types.contains(type);
  }
}
