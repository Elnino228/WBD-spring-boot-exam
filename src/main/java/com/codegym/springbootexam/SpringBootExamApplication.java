package com.codegym.springbootexam;

import com.codegym.springbootexam.service.CityService;
import com.codegym.springbootexam.service.NationService;
import com.codegym.springbootexam.service.impl.CityServiceImpl;
import com.codegym.springbootexam.service.impl.NationServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class SpringBootExamApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootExamApplication.class, args);
	}

	@Bean
	public CityService cityService(){
		return new CityServiceImpl();
	}

	@Bean
	public NationService nationService(){
		return new NationServiceImpl();
	}
}
