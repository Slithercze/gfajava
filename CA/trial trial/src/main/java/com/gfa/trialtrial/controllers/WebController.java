package com.gfa.trialtrial.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
  @GetMapping("/")
  public String index() {
    return "list";
  }

  @GetMapping("/new")
  public String form() {
    return "form";
  }
}
