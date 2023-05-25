package com.example.springdi.services;

import com.example.springdi.exceptions.PokemonException;
import com.example.springdi.models.Pokemon;
import com.example.springdi.repositories.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PokemonServiceCRUD implements PokemonService{

  private PokemonRepository pokemonRepository;

  @Autowired
  public PokemonServiceCRUD(PokemonRepository pokemonRepository) {
    this.pokemonRepository = pokemonRepository;
  }

  @Override
  public Iterable<Pokemon> getAll(String name) {
    if (name == null) {
      throw new PokemonException("chybí mi name", HttpStatus.BAD_REQUEST);
    }
    if (name.length() < 2) {
      throw new PokemonException("moc kratky jmeno kamo", HttpStatus.BAD_REQUEST);
    }

    return pokemonRepository.findAllByName(name);
  }
}
