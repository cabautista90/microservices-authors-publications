package com.editorial.authors.authors_service.authors.application.service;

import java.util.List;

import com.editorial.authors.authors_service.authors.api.request.CreateAuthorRequest;
import com.editorial.authors.authors_service.authors.api.response.AuthorResponse;

public interface AuthorService {

    AuthorResponse createAuthor(CreateAuthorRequest request);

    List<AuthorResponse> getAllAuthors();

    AuthorResponse getAuthorById(Long id);
}