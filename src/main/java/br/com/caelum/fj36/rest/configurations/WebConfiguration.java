package br.com.caelum.fj36.rest.configurations;

import javax.servlet.Filter;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

@Configuration
public class WebConfiguration {

    @Bean
    public Filter etagFilter() {
        return new ShallowEtagHeaderFilter();
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
