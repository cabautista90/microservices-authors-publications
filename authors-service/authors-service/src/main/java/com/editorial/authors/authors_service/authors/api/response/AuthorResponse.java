package com.editorial.authors.api.response;

import java.time.LocalDateTime;

public record AuthorResponse(
        Long id,
        String name,
        String email,
        String biography,
        LocalDateTime createdAt
) {}
