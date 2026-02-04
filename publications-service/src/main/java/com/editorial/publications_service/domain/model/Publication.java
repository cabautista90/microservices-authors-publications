package com.editorial.publications_service.domain.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "publications")
public class Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(length = 2000)
    private String content;

    @Column(nullable = false)
    private Long authorId; // ID que viene desde authors-service

    @Column(nullable = false)
    private String status; // DRAFT, APPROVED, REJECTED

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    // 🔹 Constructor vacío (OBLIGATORIO para JPA)
    protected Publication() {
    }

    // 🔹 Constructor útil
    public Publication(String title, String content, Long authorId, String status) {
        this.title = title;
        this.content = content;
        this.authorId = authorId;
        this.status = status;
        this.createdAt = LocalDateTime.now();
    }

    // 🔹 Getters & Setters

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
