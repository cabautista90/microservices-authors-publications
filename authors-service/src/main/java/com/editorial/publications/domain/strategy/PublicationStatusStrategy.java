package com.editorial.publications.domain.strategy;

import com.editorial.publications.domain.model.Publication;
import com.editorial.publications.domain.model.PublicationStatus;

public interface PublicationStatusStrategy {

    boolean supports(PublicationStatus status);

    void changeStatus(Publication publication);
}
