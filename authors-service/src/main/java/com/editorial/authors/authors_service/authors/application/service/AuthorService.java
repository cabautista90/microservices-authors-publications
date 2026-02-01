package com.editorial.authors.application.service;

import com.editorial.authors.api.request.CreateAuthorRequest;
import com.editorial.authors.api.response.AuthorResponse;

import java.util.List;

public interface AuthorService {

    AuthorResponse createAuthor(CreateAuthorRequest request);

    List<AuthorResponse> getAllAuthors();

    AuthorResponse getAuthorById(Long id);
}
