package com.editorial.publications_service.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.editorial.publications_service.api.client.AuthorsClient;
import com.editorial.publications_service.domain.model.Publication;
import com.editorial.publications_service.domain.repository.PublicationRepository;

@Service
public class PublicationServiceImpl implements PublicationService {

    private final PublicationRepository publicationRepository;
    private final AuthorsClient authorsClient;

    public PublicationServiceImpl(
            PublicationRepository publicationRepository,
            AuthorsClient authorsClient
    ) {
        this.publicationRepository = publicationRepository;
        this.authorsClient = authorsClient;
    }

    // 🔹 CREATE
    @Override
    public Publication createPublication(Publication publication) {

        boolean authorExists = authorsClient
                .getAuthorById(publication.getAuthorId())
                .isPresent();

        if (!authorExists) {
            throw new RuntimeException(
                    "El autor con ID " + publication.getAuthorId() + " no existe"
            );
        }

        return publicationRepository.save(publication);
    }

    // 🔹 READ ALL
    @Override
    public List<Publication> getAllPublications() {
        return publicationRepository.findAll();
    }

    // 🔹 READ BY ID
    @Override
    public Publication getPublicationById(Long id) {
        return publicationRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Publicación no encontrada con ID " + id)
                );
    }
}
