package com.example.mrbackendapi.controllers;

import com.example.mrbackendapi.dtos.JokeDTO;
import com.example.mrbackendapi.models.Joke;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
// every endpoint path in this controller starts with '/jokes'
@RequestMapping("/jokes")
public class JokeController {
    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("")
    @Transactional
    public List<JokeDTO> list() {
        List<Joke> resultList = entityManager.createNativeQuery("select * from joke;", Joke.class).getResultList();
        // map db entity instances to DTOs, which are sent to the user
        return resultList.stream().map(joke -> jokeToDTO(joke)).collect(Collectors.toList());
    }

    @PostMapping("")
    @Transactional
    // @RequestBody Joke - Jackson creates an instance of a Joke with the data in the request body,
    // according to the rules we set with @JsonIgnore and @JsonProperty
    public ResponseEntity<?> create(@RequestBody JokeDTO jokeDTO) {
        // if a certain property isn't valid (e.g.: if (joke.getJoke() == null))
        if (jokeDTO.getUrl() == null) {
            // then we respond with status 400 -> client error
            return ResponseEntity.badRequest().body("Missing values!");
        }
        // translate received data from user to db entity instance
        Joke joke = dtoToJoke(jokeDTO);
        // which can get saved to the DB
        entityManager.persist(joke);
        // ResponseEntity creates the response that is sent to the user
        // we call jokeToDTO to convert the db entity to a DTO, which is how we talk to users
        return ResponseEntity.status(201).body(joke);
    }

    // method that "translates" DTO to actual object
    private Joke dtoToJoke(JokeDTO jokeDTO) {
        Joke joke = new Joke();
        joke.setJoke(jokeDTO.getJoke());
        joke.setUrl(jokeDTO.getUrl());
        joke.setIcon_url(jokeDTO.getIconUrl());
        return joke;
    }

    // the other direction - translate db entity instance to DTO
    private JokeDTO jokeToDTO(Joke joke) {
        JokeDTO jokeDTO = new JokeDTO();
        jokeDTO.setJoke(joke.getJoke());
        jokeDTO.setUrl(joke.getUrl());
        return jokeDTO;
    }

}

