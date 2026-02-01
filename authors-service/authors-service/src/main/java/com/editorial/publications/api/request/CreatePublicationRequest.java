package com.editorial.publications.api.request;

public record CreatePublicationRequest(
        String title,
        String content,
        Long authorId
) {}
