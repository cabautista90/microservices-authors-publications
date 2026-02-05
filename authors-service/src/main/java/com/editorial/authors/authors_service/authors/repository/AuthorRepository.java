package com.editorial.authors.authors_service.authors.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.editorial.authors.authors_service.authors.domain.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}