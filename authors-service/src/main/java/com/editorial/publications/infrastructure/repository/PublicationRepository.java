package com.editorial.publications.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.editorial.publications.domain.model.Publication;

public interface PublicationRepository extends JpaRepository<Publication, Long> {
}
