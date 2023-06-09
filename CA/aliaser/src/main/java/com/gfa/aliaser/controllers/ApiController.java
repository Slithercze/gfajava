package com.gfa.aliaser.controllers;

import com.gfa.aliaser.models.Alias;
import com.gfa.aliaser.models.dtos.AliasDTO;
import com.gfa.aliaser.models.dtos.SecretCodeDTO;
import com.gfa.aliaser.services.AliasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ApiController {
    private AliasService aliasService;

    public ApiController(AliasService aliasService) {
        this.aliasService = aliasService;
    }

    @PostMapping("/links")
    public ResponseEntity links(@RequestBody Alias alias) {
        Optional<Alias> found = aliasService.findByAlias(alias.getAlias());

        if (found.isPresent()) {
            return ResponseEntity.status(400).build();
        }

        aliasService.save(alias);
        return ResponseEntity.status(200).body(alias);
    }

    @GetMapping("/links")
    public ResponseEntity links() {
        List<AliasDTO> output = new ArrayList<>();

        aliasService.getAll().forEach(alias -> output.add(new AliasDTO(alias)));

        return ResponseEntity.status(200).body(output);
    }

    @DeleteMapping("/links/{id}")
    public ResponseEntity delete(@PathVariable long id, @RequestBody(required = false) SecretCodeDTO secret) {
        Optional<Alias> maybeAlias = aliasService.findById(id);

        if (maybeAlias.isEmpty()) {
            return ResponseEntity.status(404).build();
        } else if (secret == null || !maybeAlias.get().getSecretCode().equals(secret.secretCode)) {
            return ResponseEntity.status(403).build();
        }

        // if somebody deleted line 51, it'd be bad
        // might've been better idea to reverse the checking logic and wrap this line with conditions
        aliasService.delete(maybeAlias.get().getId());

        return ResponseEntity.status(204).build();
    }
}
