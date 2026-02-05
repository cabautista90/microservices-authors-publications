package com.editorial.authors.authors_service.authors.api.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.editorial.authors.authors_service.authors.api.request.CreateAuthorRequest;
import com.editorial.authors.authors_service.authors.api.response.AuthorResponse;
import com.editorial.authors.authors_service.authors.domain.model.Author;

@Component
public class AuthorMapper {

    public Author toEntity(CreateAuthorRequest request) {
        return new Author(
                request.name(),
                request.email(),
                request.biography(),
                LocalDateTime.now()
        );
    }

    public AuthorResponse toResponse(Author author) {
        return new AuthorResponse(
                author.getId(),
                author.getName(),
                author.getEmail(),
                author.getBiography(),
                author.getCreatedAt()
        );
    }
}