package com.editorial.publications.application.service.impl;

import com.editorial.publications.api.client.AuthorsClient;
import com.editorial.publications.api.mapper.PublicationMapper;
import com.editorial.publications.api.request.CreatePublicationRequest;
import com.editorial.publications.api.response.PublicationResponse;
import com.editorial.publications.application.service.PublicationService;
import com.editorial.publications.domain.factory.PublicationStatusFactory;
import com.editorial.publications.domain.model.Publication;
import com.editorial.publications.domain.model.PublicationStatus;
import com.editorial.publications.infrastructure.repository.PublicationRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicationServiceImpl implements PublicationService {

    private final PublicationRepository repository;
    private final AuthorsClient authorsClient;

    public PublicationServiceImpl(PublicationRepository repository,
                                  AuthorsClient authorsClient) {
        this.repository = repository;
        this.authorsClient = authorsClient;
    }

    @Override
    public PublicationResponse createPublication(CreatePublicationRequest request) {

        authorsClient.getAuthorById(request.authorId())
                .orElseThrow(() -> new RuntimeException("Autor no existe"));

        Publication publication = PublicationMapper.toEntity(request);
        return PublicationMapper.toResponse(repository.save(publication));
    }

    @Override
    public PublicationResponse getPublicationById(Long id) {
        Publication publication = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Publicación no encontrada"));

        return PublicationMapper.toResponse(publication);
    }

    @Override
    public List<PublicationResponse> getAllPublications() {
        return repository.findAll()
                .stream()
                .map(PublicationMapper::toResponse)
                .toList();
    }

    @Override
    public PublicationResponse changeStatus(Long id, PublicationStatus status) {
        Publication publication = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Publicación no encontrada"));

        PublicationStatusFactory.getStrategy(status)
                .changeStatus(publication);

        return PublicationMapper.toResponse(repository.save(publication));
    }
}
