package kz.diploma.atmservice.config;

import kz.diploma.adapter.access.AdapterFeignAutoConfiguration;
import kz.diploma.auth.access.AuthAccessAutoConfiguration;
import kz.diploma.integration.yandex.IntegrationYandexAutoConfiguration;
import kz.diploma.library.shared.error_handling.ErrorHandlingAutoConfiguration;
import kz.diploma.library.shared.model.ModelsAutoConfiguration;
import kz.diploma.shared.library.security.CorsFilterConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {
        AdapterFeignAutoConfiguration.class,
        IntegrationYandexAutoConfiguration.class,
        AuthAccessAutoConfiguration.class,
        ModelsAutoConfiguration.class,
        ErrorHandlingAutoConfiguration.class,
        CorsFilterConfiguration.class,
})
public class DefaultConfiguration {
}
