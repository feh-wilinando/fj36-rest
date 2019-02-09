package br.com.caelum.fj36.rest.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

import javax.servlet.Filter;

@Configuration
public class WebConfiguration {
    @Bean
    public Filter etagFilter() {
        return new ShallowEtagHeaderFilter();
    }
}
