package com.gfa.aliaser.services;

import com.gfa.aliaser.models.Alias;
import com.gfa.aliaser.repositories.AliasRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.Random;

@Service
public class AliasService {
    private AliasRepository repo;

    public AliasService(AliasRepository repo) {
        this.repo = repo;
    }

    public Optional<Alias> findByAlias(String alias) {
        return repo.findAliasByAlias(alias);
    }

    public Optional<Alias> findById(long id) {
        return repo.findById(id);
    }

    public void delete(long id) {
        repo.deleteById(id);
    }

    public String accessUrl(Alias a) {
        a.setHitCount(a.getHitCount() + 1); // this'll blow into your face if used in production! ☠️ – ask for atomicity
        save(a);
        return a.getUrl();
    }

    public Iterable<Alias> getAll() {
        return repo.findAll();
    }

    public Alias attachRandomCode(Alias a) {
        a.setSecretCode(String.format("%04d", new Random().nextInt(10000)));
        return a;
    }

    public Alias save(Alias a) {
        if (a.getSecretCode() == null) {
            a = attachRandomCode(a);
        }
        return repo.save(a);
    }
}
