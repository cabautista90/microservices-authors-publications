package com.editorial.publications.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "publications")
public class Publication extends PublicationBase {

    protected Publication() {}

    public Publication(String title, String content, Long authorId) {
        this.title = title;
        this.content = content;
        this.authorId = authorId;
    }

    public void changeStatus(PublicationStatus status) {
        this.status = status;
    }
}
