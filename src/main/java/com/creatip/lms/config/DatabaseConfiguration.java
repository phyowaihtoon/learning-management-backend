package com.creatip.lms.config;

import com.creatip.lms.security.SecurityUtils;
import java.util.Optional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("com.creatip.lms.repository")
@EnableJpaAuditing(auditorAwareRef = "springSecurityAuditorAware")
@EnableTransactionManagement
public class DatabaseConfiguration {

	@Bean(name = "springSecurityAuditorAware")
	public AuditorAware<String> springSecurityAuditorAware() {
		return () -> SecurityUtils.getCurrentUserLogin().filter(login -> !login.isBlank()).or(() -> Optional.of("system"));
	}
}
