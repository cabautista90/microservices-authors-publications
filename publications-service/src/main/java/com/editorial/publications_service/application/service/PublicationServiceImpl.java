package com.editorial.publications_service.application.service;

import com.editorial.publications_service.api.client.AuthorsClient;
import com.editorial.publications_service.domain.model.Publication;
import com.editorial.publications_service.domain.repository.PublicationRepository;

import org.springframework.stereotype.Service;

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

    @Override
    public Publication save(Publication publication) {

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
}
