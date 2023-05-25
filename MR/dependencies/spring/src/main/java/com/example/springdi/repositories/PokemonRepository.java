package com.example.springdi.repositories;

import com.example.springdi.models.Pokemon;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends CrudRepository<Pokemon, Long> {
  @Query(value = "SELECT * FROM pokemon WHERE name LIKE :name ", nativeQuery = true)
  List<Pokemon> findAllByName(String name);
}
