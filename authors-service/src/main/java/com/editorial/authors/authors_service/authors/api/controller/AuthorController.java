package com.editorial.authors.authors_service.authors.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.editorial.authors.authors_service.authors.api.request.CreateAuthorRequest;
import com.editorial.authors.authors_service.authors.api.response.AuthorResponse;
import com.editorial.authors.authors_service.authors.application.service.AuthorService;

@CrossOrigin(origins = "http://localhost:5173")
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
