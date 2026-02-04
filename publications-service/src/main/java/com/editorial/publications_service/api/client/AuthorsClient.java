package com.editorial.publications_service.api.client;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.editorial.publications_service.api.response.AuthorResponse;

@Component
public class AuthorsClient {

    private final WebClient webClient;

    public AuthorsClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Optional<AuthorResponse> getAuthorById(Long authorId) {
        try {
            AuthorResponse author = webClient
                    .get()
                    .uri("http://localhost:8081/api/authors/{id}", authorId) // ✅ URL COMPLETA
                    .retrieve()
                    .bodyToMono(AuthorResponse.class)
                    .block();

            return Optional.ofNullable(author);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
