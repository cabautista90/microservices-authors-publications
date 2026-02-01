package com.editorial.authors.authors_service.authors.repository;

import com.editorial.authors.authors_service.authors.domain.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
