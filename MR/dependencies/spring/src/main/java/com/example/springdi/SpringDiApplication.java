package com.example.springdi;

import com.example.springdi.models.Pokemon;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDiApplication implements CommandLineRunner {

  @PersistenceContext
  private EntityManager entityManager;

  public static void main(String[] args) {
    SpringApplication.run(SpringDiApplication.class, args);
  }

  @Override
  @Transactional
  public void run(String... args) throws Exception {
    Pokemon pikachu = new Pokemon("Pikachu");
    Pokemon bulbasaur = new Pokemon("Bulbasaur");

    entityManager.persist(pikachu);
    entityManager.persist(bulbasaur);
  }
}
