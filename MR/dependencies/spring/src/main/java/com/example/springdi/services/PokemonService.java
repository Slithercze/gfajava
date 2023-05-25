package com.example.springdi.services;

import com.example.springdi.models.Pokemon;

public interface PokemonService {
  Iterable<Pokemon> getAll(String name);
}

