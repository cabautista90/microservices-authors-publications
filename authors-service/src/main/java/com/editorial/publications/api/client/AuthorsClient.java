package com.editorial.publications.api.client;

import java.util.Optional;

import com.editorial.publications.api.client.dto.AuthorDTO;

public interface AuthorsClient {

    Optional<AuthorDTO> getAuthorById(Long authorId);
}
