package com.editorial.authors.authors_service.authors.api.request;

public record CreateAuthorRequest(
        String name,
        String email,
        String biography
) {}
