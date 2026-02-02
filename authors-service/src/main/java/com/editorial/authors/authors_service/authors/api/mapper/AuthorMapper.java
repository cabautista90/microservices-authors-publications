package com.editorial.authors.authors_service.authors.api.mapper;

import com.editorial.authors.authors_service.authors.domain.model.Author;
import com.editorial.authors.api.request.CreateAuthorRequest;
import com.editorial.authors.api.response.AuthorResponse;

import java.time.LocalDateTime;

public class AuthorMapper {

    private AuthorMapper() {
        // Utility class
    }

    public static Author toEntity(CreateAuthorRequest request) {
        return new Author(
                request.name(),
                request.email(),
                request.biography(),
                LocalDateTime.now()
        );
    }

    public static AuthorResponse toResponse(Author author) {
        return new AuthorResponse(
                author.getId(),
                author.getName(),
                author.getEmail(),
                author.getBiography(),
                author.getCreatedAt()
        );
    }
}
