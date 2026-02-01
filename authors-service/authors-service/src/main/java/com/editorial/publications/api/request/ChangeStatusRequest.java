package com.editorial.publications.api.request;

import com.editorial.publications.domain.model.PublicationStatus;

public record ChangeStatusRequest(
        PublicationStatus status
) {}
