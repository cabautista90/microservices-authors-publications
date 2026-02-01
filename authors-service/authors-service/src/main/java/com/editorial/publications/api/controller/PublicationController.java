package com.editorial.publications.api.controller;

import com.editorial.publications.api.request.ChangeStatusRequest;
import com.editorial.publications.api.request.CreatePublicationRequest;
import com.editorial.publications.api.response.PublicationResponse;
import com.editorial.publications.application.service.PublicationService;
import com.editorial.publications.domain.model.PublicationStatus;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publications")
public class PublicationController {

    private final PublicationService publicationService;

    public PublicationController(PublicationService publicationService) {
        this.publicationService = publicationService;
    }

    // 🔹 Crear publicación
    @PostMapping
    public ResponseEntity<PublicationResponse> createPublication(
            @RequestBody CreatePublicationRequest request) {

        return new ResponseEntity<>(
                publicationService.createPublication(request),
                HttpStatus.CREATED
        );
    }

    // 🔹 Listar publicaciones
    @GetMapping
    public ResponseEntity<List<PublicationResponse>> getAllPublications() {
        return ResponseEntity.ok(publicationService.getAllPublications());
    }

    // 🔹 Obtener publicación por ID
    @GetMapping("/{id}")
    public ResponseEntity<PublicationResponse> getPublicationById(
            @PathVariable Long id) {

        return ResponseEntity.ok(publicationService.getPublicationById(id));
    }

    // 🔹 Cambiar estado editorial
    @PatchMapping("/{id}/status")
    public ResponseEntity<PublicationResponse> changeStatus(
            @PathVariable Long id,
            @RequestBody ChangeStatusRequest request) {

        PublicationStatus status = request.status();
        return ResponseEntity.ok(
                publicationService.changeStatus(id, status)
        );
    }
}
