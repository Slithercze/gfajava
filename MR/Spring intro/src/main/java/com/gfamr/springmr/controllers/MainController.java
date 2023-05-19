package com.gfamr.springmr.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nejakapath")
public class MainController {
  @PostMapping("svestky")
  public String svestky(@RequestParam(required = false) String dejmi) {
    if (dejmi == null) {
      return "Nic tu není";
    }
    System.out.println(dejmi);
    return dejmi;
  }

  @GetMapping("svestky/{kouzlo}")
  public String jinySvestky(@PathVariable String kouzlo) {
    // tady třeba půjdu do nějaký databáze a něco z ní získam.
    return kouzlo;
  }


}
