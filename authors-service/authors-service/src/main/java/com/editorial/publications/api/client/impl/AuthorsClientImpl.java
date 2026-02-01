package com.editorial.publications.api.client.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.editorial.publications.api.client.AuthorsClient;
import com.editorial.publications.api.client.dto.AuthorDTO;

@Component
public class AuthorsClientImpl implements AuthorsClient {

    private final RestTemplate restTemplate;
    private final String authorsServiceUrl;

    public AuthorsClientImpl(
            RestTemplate restTemplate,
            @Value("${services.authors.url}") String authorsServiceUrl) {
        this.restTemplate = restTemplate;
        this.authorsServiceUrl = authorsServiceUrl;
    }

    @Override
    public Optional<AuthorDTO> getAuthorById(Long authorId) {
        try {
            String url = authorsServiceUrl + "/api/authors/" + authorId;
            ResponseEntity<AuthorDTO> response =
                    restTemplate.getForEntity(url, AuthorDTO.class);

            return Optional.ofNullable(response.getBody());

        } catch (RestClientException ex) {
            return Optional.empty();
        }
    }
}
