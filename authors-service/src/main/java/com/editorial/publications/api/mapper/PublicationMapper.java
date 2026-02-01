package com.editorial.publications.api.mapper;

import com.editorial.publications.api.request.CreatePublicationRequest;
import com.editorial.publications.api.response.PublicationResponse;
import com.editorial.publications.domain.model.Publication;

public class PublicationMapper {

    private PublicationMapper() {}

    public static Publication toEntity(CreatePublicationRequest request) {
        return new Publication(
                request.title(),
                request.content(),
                request.authorId()
        );
    }

    public static PublicationResponse toResponse(Publication publication) {
        return new PublicationResponse(
                publication.getId(),
                publication.getTitle(),
                publication.getContent(),
                publication.getAuthorId(),
                publication.getStatus(),
                publication.getCreatedAt()
        );
    }
}
