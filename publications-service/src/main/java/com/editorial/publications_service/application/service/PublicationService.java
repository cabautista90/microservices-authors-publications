package com.editorial.publications_service.application.service;

import java.util.List;

import com.editorial.publications_service.domain.model.Publication;

public interface PublicationService {

    Publication createPublication(Publication publication);

    List<Publication> getAllPublications();

    Publication getPublicationById(Long id);
}
