package com.editorial.publications.application.service;

import com.editorial.publications.api.request.CreatePublicationRequest;
import com.editorial.publications.api.response.PublicationResponse;
import com.editorial.publications.domain.model.PublicationStatus;

import java.util.List;

public interface PublicationService {

    PublicationResponse createPublication(CreatePublicationRequest request);

    PublicationResponse getPublicationById(Long id);

    List<PublicationResponse> getAllPublications();

    PublicationResponse changeStatus(Long id, PublicationStatus status);
}
