package ru.sbrf.course.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"ru.sbrf.course.domain"})
@EnableJpaRepositories(basePackages = {"ru.sbrf.course.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}