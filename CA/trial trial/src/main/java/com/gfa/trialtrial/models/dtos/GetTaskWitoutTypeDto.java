package com.gfa.trialtrial.models.dtos;

/*
  {
    "id": 2,
    "title": "You can do it",
    "content": "In order to SUCCEED, you first have to believe in yourself."
  }
 */

import com.gfa.trialtrial.models.Task;

public class GetTaskWitoutTypeDto {
  private Long id;
  private String title;
  private String content;

  public GetTaskWitoutTypeDto(Task task) {
    this.id = task.getId();
    this.content = task.getContent();
    this.title = task.getTitle();
  }

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getContent() {
    return content;
  }
}
