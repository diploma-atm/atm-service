package kz.diploma.atmservice;

import kz.diploma.adapter.access.AdapterFeignAutoConfiguration;
import kz.diploma.integration.yandex.IntegrationYandexAutoConfiguration;
import kz.diploma.library.shared.model.ModelsAutoConfiguration;
import kz.diploma.library.shared.model.entity.EntityScanner;
import kz.diploma.library.shared.model.repository.RepositoryScanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Import(value = { AdapterFeignAutoConfiguration.class, IntegrationYandexAutoConfiguration.class, ModelsAutoConfiguration.class })
public class AtmServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtmServiceApplication.class, args);
	}

}
