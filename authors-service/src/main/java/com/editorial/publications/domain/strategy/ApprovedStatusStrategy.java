package com.editorial.publications.domain.strategy;

import org.springframework.stereotype.Component;

import com.editorial.publications.domain.model.Publication;
import com.editorial.publications.domain.model.PublicationStatus;

@Component
public class ApprovedStatusStrategy implements PublicationStatusStrategy {

    @Override
    public boolean supports(PublicationStatus status) {
        return status == PublicationStatus.APPROVED;
    }

    @Override
    public void changeStatus(Publication publication) {
        publication.changeStatus(PublicationStatus.APPROVED);
    }
}
