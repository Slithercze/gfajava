package com.example.springdi.services;

import com.example.springdi.models.Pokemon;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

@Service
public class PokemonServiceFile implements PokemonService {

  @Override
  public Iterable<Pokemon> getAll(String name) {
    return new ArrayList<>();
  }
}
