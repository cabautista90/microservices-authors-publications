package com.editorial.authors.api.request;

public record CreateAuthorRequest(
        String name,
        String email,
        String biography
) {}
