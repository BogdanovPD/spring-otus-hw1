package ru.otus.spring01.homework_1.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.io.FilterInputStream;
import java.util.Scanner;

@Configuration
public class ApplicationConfig {

    @Bean
    @Scope("prototype")
    public Scanner scanner(FilterInputStream fis) {
        return new Scanner(fis);
    }

    @Bean
    public FilterInputStream fis() {
        return new FilterInputStream(System.in){public void close(){}};
    }

    @Bean
    public MessageSource messageSourceQa() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("i18n/qa");
        ms.setDefaultEncoding("windows-1251");
        return ms;
    }

    @Bean
    public MessageSource messageSourceFirstLastName() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("i18n/fln");
        ms.setDefaultEncoding("windows-1251");
        return ms;
    }

}
