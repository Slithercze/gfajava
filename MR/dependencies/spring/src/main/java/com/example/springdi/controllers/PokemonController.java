package com.example.springdi.controllers;

import com.example.springdi.exceptions.PokemonException;
import com.example.springdi.models.ErrorMessage;
import com.example.springdi.services.PokemonService;
import com.example.springdi.services.PokemonServiceFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokemonController {

  private PokemonService pokemonService;

  @Autowired
  public PokemonController(
      @Qualifier("pokemonServiceCRUD") PokemonService pokemonService) {
    this.pokemonService = pokemonService;
  }


  @GetMapping("/pokemons")
  public ResponseEntity<?> getAll(@RequestParam(required = false) String name) {
    try {
      return ResponseEntity.ok().body(pokemonService.getAll(name));
    } catch (PokemonException exception) {
      return ResponseEntity.status(exception.getStatusCode()).body(new ErrorMessage(exception.getMessage()));
    }
  }
}
