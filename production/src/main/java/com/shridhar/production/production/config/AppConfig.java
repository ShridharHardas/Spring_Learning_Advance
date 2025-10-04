package com.shridhar.production.production.config;

import com.shridhar.production.production.auth.AuditingAwareImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "getAuditingAwareImpl")
public class AppConfig {

    @Bean
    ModelMapper getModelMapper() {
        return new ModelMapper();
    }

    @Bean
    AuditingAwareImpl getAuditingAwareImpl() {
        return new AuditingAwareImpl();
    }
}
