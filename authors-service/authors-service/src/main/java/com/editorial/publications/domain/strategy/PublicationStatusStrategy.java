package com.editorial.publications.domain.strategy;

import com.editorial.publications.domain.model.Publication;

public interface PublicationStatusStrategy {

    void changeStatus(Publication publication);
}
