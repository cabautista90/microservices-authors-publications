package com.editorial.publications.api.response;

import java.time.LocalDateTime;

import com.editorial.publications.domain.model.PublicationStatus;

public record PublicationResponse(
        Long id,
        String title,
        String content,
        Long authorId,
        PublicationStatus status,
        LocalDateTime createdAt
) {}
