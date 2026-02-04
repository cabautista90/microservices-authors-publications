package com.editorial.publications_service.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.editorial.publications_service.application.service.PublicationService;
import com.editorial.publications_service.domain.model.Publication;

@RestController
@RequestMapping("/api/publications")
public class PublicationController {

    private final PublicationService publicationService;

    public PublicationController(PublicationService publicationService) {
        this.publicationService = publicationService;
    }

    // 🔹 POST - Crear publicación
    @PostMapping
    public ResponseEntity<Publication> create(@RequestBody Publication publication) {
        return new ResponseEntity<>(
                publicationService.createPublication(publication),
                HttpStatus.CREATED
        );
    }

    // 🔹 GET - Listar publicaciones
    @GetMapping
    public ResponseEntity<List<Publication>> findAll() {
        return ResponseEntity.ok(publicationService.getAllPublications());
    }

    // 🔹 GET - Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Publication> findById(@PathVariable Long id) {
        return ResponseEntity.ok(publicationService.getPublicationById(id));
    }
}
