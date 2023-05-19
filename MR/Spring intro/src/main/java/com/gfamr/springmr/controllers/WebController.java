package com.gfamr.springmr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

  @GetMapping("/blabla")
  public String stranka(Model model, @RequestParam String nejakyText) {
    model.addAttribute("text", nejakyText);
    return "stranka";
  }
}
