package com.editorial.publications.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "publications")
public class Publication extends PublicationBase {

    // Constructor requerido por JPA
    protected Publication() {
    }

    // Constructor de dominio
    public Publication(String title, String content, Long authorId) {
        this.title = title;
        this.content = content;
        this.authorId = authorId;
        this.status = PublicationStatus.DRAFT;
    }

    // ===== Getters =====

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public PublicationStatus getStatus() {
        return status;
    }

    public java.time.LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // ===== Lógica de dominio =====

    public void changeStatus(PublicationStatus status) {
        this.status = status;
    }
}
