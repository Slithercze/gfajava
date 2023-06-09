package com.gfa.aliaser.repositories;

import com.gfa.aliaser.models.Alias;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AliasRepository extends CrudRepository<Alias, Long> {

    // needs indexing on column alias
    Optional<Alias> findAliasByAlias(String alias);
}
