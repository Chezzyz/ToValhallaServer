package ru.rsc.tovalhallaserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"ru.rsc.tovalhallaserver.domain.repository"})
public class JpaConfig {
}
