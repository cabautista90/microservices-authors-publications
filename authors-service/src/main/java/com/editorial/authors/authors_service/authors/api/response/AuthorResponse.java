package com.editorial.authors.authors_service.authors.api.response;

import java.time.LocalDateTime;

public record AuthorResponse(
        Long id,
        String name,
        String email,
        String biography,
        LocalDateTime createdAt
) {}
