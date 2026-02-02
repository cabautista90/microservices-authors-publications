package com.editorial.publications.domain.factory;

import java.util.List;

import org.springframework.stereotype.Component;

import com.editorial.publications.domain.model.PublicationStatus;
import com.editorial.publications.domain.strategy.PublicationStatusStrategy;

@Component
public class PublicationStatusFactory {

    private final List<PublicationStatusStrategy> strategies;

    public PublicationStatusFactory(List<PublicationStatusStrategy> strategies) {
        this.strategies = strategies;
    }

    public PublicationStatusStrategy getStrategy(PublicationStatus status) {
        return strategies.stream()
                .filter(strategy -> strategy.supports(status))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("No strategy for status: " + status));
    }
}
