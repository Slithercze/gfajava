package com.example.springdi.services;

import com.example.springdi.exceptions.PokemonException;
import com.example.springdi.models.Pokemon;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PokemonServiceDBImplementation implements PokemonService {
  @PersistenceContext
  private EntityManager entityManager;

  @Transactional
  public Iterable<Pokemon> getAll(String name) {
    if (name == null) {
      throw new PokemonException("chybí mi name", HttpStatus.BAD_REQUEST);
    }
    if (name.length() < 2) {
      throw new PokemonException("moc kratky jmeno kamo", HttpStatus.BAD_REQUEST);
    }

    return entityManager.createNativeQuery(
            "SELECT * FROM pokemon WHERE name LIKE ?", Pokemon.class
        ).setParameter(1, name)
        .getResultList();
  }
}
