package com.shridhar.production.production.auth;

import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Optional;

public class AuditingAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Shridhar Hardas");
    }
}

