package ru.otus.spring01.homework_1.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class ApplicationConfig {

    @Bean
    public MessageSource messageSourceQa() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("i18n/qa");
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }

    @Bean
    public MessageSource messageSourceFirstLastName() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("i18n/fln");
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }

}
