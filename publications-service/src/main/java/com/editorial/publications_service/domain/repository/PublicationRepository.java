package com.editorial.publications_service.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.editorial.publications_service.domain.model.Publication;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long> {
}
