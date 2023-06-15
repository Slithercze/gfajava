package com.gfa.trialtrial.models.dtos;

/*
{
  "content": "- coffee\n- tomatoes\n- apples"
}
 */

import com.gfa.trialtrial.models.Task;

public class DeleteResponseDto {
  private String content;

  public DeleteResponseDto(Task task) {
    this.content = task.getContent();
  }

  public String getContent() {
    return content;
  }
}
