package com.editorial.authors.application.service.impl;

import com.editorial.authors.api.mapper.AuthorMapper;
import com.editorial.authors.api.request.CreateAuthorRequest;
import com.editorial.authors.api.response.AuthorResponse;
import com.editorial.authors.application.service.AuthorService;
import com.editorial.authors.domain.Author;
import com.editorial.authors.domain.repository.AuthorRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public AuthorResponse createAuthor(CreateAuthorRequest request) {
        Author author = AuthorMapper.toEntity(request);
        Author savedAuthor = authorRepository.save(author);
        return AuthorMapper.toResponse(savedAuthor);
    }

    @Override
    public List<AuthorResponse> getAllAuthors() {
        return authorRepository.findAll()
                .stream()
                .map(AuthorMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public AuthorResponse getAuthorById(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found with id: " + id));
        return AuthorMapper.toResponse(author);
    }
}
