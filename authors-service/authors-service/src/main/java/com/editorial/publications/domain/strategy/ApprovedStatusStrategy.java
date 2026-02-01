package com.editorial.publications.domain.strategy;

import com.editorial.publications.domain.model.Publication;
import com.editorial.publications.domain.model.PublicationStatus;

public class ApprovedStatusStrategy implements PublicationStatusStrategy {

    @Override
    public void changeStatus(Publication publication) {
        publication.changeStatus(PublicationStatus.APPROVED);
    }
}
