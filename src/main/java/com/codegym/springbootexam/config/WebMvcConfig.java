package com.codegym.springbootexam.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;


@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    //i18n config
    @Override
    //LocaleChangeInterceptor se goi LocaleResolver de luu thong tin ve locale moi khi co thong tin locale trong request
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor interceptor=new LocaleChangeInterceptor();
        interceptor.setParamName("lang");
        registry.addInterceptor(interceptor);
    }

    @Bean
    //dinh file translate.properties va doc no va phan biet tung file theo cau truc [base name]_vi_VN.properties
    public MessageSource messageSource(){
        ResourceBundleMessageSource messageSource=new ResourceBundleMessageSource();
        messageSource.setBasename("message");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    //khi dc LocaleChangeInterceptor goi, LocalResolver se save thong tin ve local vao session cua tung nguoi dung
    public LocaleResolver localeResolver(){
        SessionLocaleResolver localeResolver=new SessionLocaleResolver();
        localeResolver.setDefaultLocale(new Locale("en"));
        return localeResolver;
    }

}
