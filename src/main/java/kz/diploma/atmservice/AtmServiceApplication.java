package kz.diploma.atmservice;

import kz.diploma.adapter.access.AdapterFeignAutoConfiguration;
import kz.diploma.integration.yandex.IntegrationYandexAutoConfiguration;
import kz.diploma.library.shared.error_handling.ErrorHandlingAutoConfiguration;
import kz.diploma.library.shared.model.ModelsAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(value = { AdapterFeignAutoConfiguration.class, IntegrationYandexAutoConfiguration.class, ModelsAutoConfiguration.class, ErrorHandlingAutoConfiguration.class })
public class AtmServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtmServiceApplication.class, args);
	}

}
