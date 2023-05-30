package com.gfa.apiproxy;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientSsl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@RestController

public class ApiController {
    private WebClient web = WebClient.builder().build();

    private String path = "./responses/";

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
    @RequestMapping("/")
    public ResponseEntity index(HttpServletRequest request) throws NoSuchAlgorithmException, IOException {

        String url = null;

        try {
            url = request.getQueryString().split("=",2)[1];
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        String body;
        if (url != null) {

            MessageDigest digest = MessageDigest.getInstance("SHA-1");

            byte[] bytes = digest.digest(url.getBytes());

            BigInteger bi = new BigInteger(1, bytes);

            String s = bi.toString(16);

            Path p = Path.of(path + s);

            if (Files.exists(p)) {
                body = Files.readString(p);
            } else {
                body = web.get().uri(url).retrieve().bodyToMono(String.class).block();

                Files.writeString(p, body, StandardCharsets.UTF_8);
            }
        } else {
            body = "{}";
        }

//        String body = Files.readString(Path.of("src/main/resources/static/search.json"));

        return ResponseEntity
                .status(200)
                .body(body);

    }
}
