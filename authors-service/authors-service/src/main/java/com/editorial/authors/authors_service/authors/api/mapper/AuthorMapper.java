package com.editorial.authors.api.mapper;

import com.editorial.authors.api.request.CreateAuthorRequest;
import com.editorial.authors.api.response.AuthorResponse;
import com.editorial.authors.domain.Author;

import java.time.LocalDateTime;

public class AuthorMapper {

    private AuthorMapper() {
        // Evita instanciación (Utility class)
    }

    public static Author toEntity(CreateAuthorRequest request) {
        return Author.builder()
                .name(request.name())
                .email(request.email())
                .biography(request.biography())
                .createdAt(LocalDateTime.now())
                .build();
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
