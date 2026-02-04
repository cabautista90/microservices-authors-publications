package com.editorial.publications_service.api.response;

public record AuthorResponse(
        Long id,
        String name,
        String email
) {
}
