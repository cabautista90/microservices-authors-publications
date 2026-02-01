package com.editorial.publications.domain.factory;

import com.editorial.publications.domain.model.PublicationStatus;
import com.editorial.publications.domain.strategy.*;

public class PublicationStatusFactory {

    public static PublicationStatusStrategy getStrategy(PublicationStatus status) {
        return switch (status) {
            case IN_REVIEW -> new InReviewStatusStrategy();
            case APPROVED -> new ApprovedStatusStrategy();
            case PUBLISHED -> new PublishedStatusStrategy();
            case REJECTED -> new RejectedStatusStrategy();
            default -> throw new IllegalArgumentException("Estado no soportado");
        };
    }
}
