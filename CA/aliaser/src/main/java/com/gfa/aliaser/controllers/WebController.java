package com.gfa.aliaser.controllers;

import com.gfa.aliaser.models.Alias;
import com.gfa.aliaser.services.AliasService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class WebController {
    private AliasService aliasService;

    public WebController(AliasService aliasService) {
        this.aliasService = aliasService;
    }

    @GetMapping("")
    public String index() {
        return "views/index.html";
    }

    @GetMapping("a/{alias}")
    public String redirect(@PathVariable String alias) {
        Optional<Alias> maybeAlias = aliasService.findByAlias(alias);

        if (maybeAlias.isPresent()) {
            return "redirect:" + aliasService.accessUrl(maybeAlias.get());
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
