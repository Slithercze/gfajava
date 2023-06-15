package com.gfa.trialtrial.controllers;

import com.gfa.trialtrial.models.Task;
import com.gfa.trialtrial.models.dtos.DeleteResponseDto;
import com.gfa.trialtrial.models.dtos.ErrorDto;
import com.gfa.trialtrial.models.dtos.GetTaskWitoutTypeDto;
import com.gfa.trialtrial.services.TaskService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

  private final TaskService taskService;

  @Autowired
  public ApiController(TaskService taskService) {
    this.taskService = taskService;
  }

  @GetMapping("/notes")
  public ResponseEntity<?> getNotes(@RequestParam Optional<String> type) {
    if (type.isPresent()) {
      if (!taskService.typeExist(type.get())) {
        return ResponseEntity.badRequest().body(new ErrorDto(type.get() + " type is not existing"));
      }
      return ResponseEntity.ok(taskService.getByType(type.get()));
    }

    return ResponseEntity.ok(
        taskService.getAll().stream()
            .map(task -> new GetTaskWitoutTypeDto(task))
    );
  }

  @PostMapping("/notes")
  public ResponseEntity<?> saveNote(@RequestBody Task task) {
    return ResponseEntity.ok(taskService.save(task));
  }

  @DeleteMapping("/notes/{id}")
  public ResponseEntity<?> deleteNote(@PathVariable Long id) {
    Optional<Task> maybeTask = taskService.delete(id);
    if (maybeTask.isEmpty()) {
      return ResponseEntity.badRequest().build();
    }

    Task task = maybeTask.get();
    if (!task.getType().equals("motivational")) {
      return ResponseEntity.ok(new DeleteResponseDto(maybeTask.get()));
    } else {
      return ResponseEntity.ok().build();
    }
  }
}
