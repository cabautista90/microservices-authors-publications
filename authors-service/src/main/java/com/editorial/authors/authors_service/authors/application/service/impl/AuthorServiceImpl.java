package com.editorial.authors.authors_service.authors.application.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.editorial.authors.api.request.CreateAuthorRequest;
import com.editorial.authors.api.response.AuthorResponse;
import com.editorial.authors.application.service.AuthorService;
import com.editorial.authors.authors_service.authors.api.mapper.AuthorMapper;
import com.editorial.authors.authors_service.authors.domain.model.Author;
import com.editorial.authors.authors_service.authors.repository.AuthorRepository;

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
        return authorRepository.findById(id)
                .map(author -> new AuthorResponse(
                        author.getId(),
                        author.getName(),
                        author.getEmail(),
                        author.getBiography(),
                        author.getCreatedAt()
                ))
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Autor no encontrado con ID: " + id
                        )
                );
    }
}