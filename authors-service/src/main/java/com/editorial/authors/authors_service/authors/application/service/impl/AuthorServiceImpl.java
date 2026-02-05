package com.editorial.authors.authors_service.authors.application.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.editorial.authors.authors_service.authors.api.mapper.AuthorMapper;
import com.editorial.authors.authors_service.authors.api.request.CreateAuthorRequest;
import com.editorial.authors.authors_service.authors.api.response.AuthorResponse;
import com.editorial.authors.authors_service.authors.application.service.AuthorService;
import com.editorial.authors.authors_service.authors.domain.model.Author;
import com.editorial.authors.authors_service.authors.repository.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public AuthorServiceImpl(
            AuthorRepository authorRepository,
            AuthorMapper authorMapper
    ) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    @Override
    public AuthorResponse createAuthor(CreateAuthorRequest request) {
        Author author = authorMapper.toEntity(request);
        Author saved = authorRepository.save(author);
        return authorMapper.toResponse(saved);
    }

    @Override
    public List<AuthorResponse> getAllAuthors() {
        return authorRepository.findAll()
                .stream()
                .map(authorMapper::toResponse)
                .toList();
    }

    @Override
    public AuthorResponse getAuthorById(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));
        return authorMapper.toResponse(author);
    }
}
