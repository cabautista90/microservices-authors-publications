package com.editorial.authors.api.controller;

import com.editorial.authors.api.request.CreateAuthorRequest;
import com.editorial.authors.api.response.AuthorResponse;
import com.editorial.authors.application.service.AuthorService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    // 🔹 POST - Crear autor
    @PostMapping
    public ResponseEntity<AuthorResponse> createAuthor(
            @RequestBody CreateAuthorRequest request) {

        AuthorResponse response = authorService.createAuthor(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // 🔹 GET - Listar todos los autores
    @GetMapping
    public ResponseEntity<List<AuthorResponse>> getAllAuthors() {
        return ResponseEntity.ok(authorService.getAllAuthors());
    }

    // 🔹 GET - Buscar autor por ID
    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponse> getAuthorById(@PathVariable Long id) {
        return ResponseEntity.ok(authorService.getAuthorById(id));
    }
}
