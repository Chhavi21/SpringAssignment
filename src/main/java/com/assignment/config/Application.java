package com.assignment.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.assignment.dao.CountryDao;
import com.assignment.service.CountryService;

//This is a convenience annotation that is equivalent to 
//declaring @Configuration, @EnableAutoConfiguration and @ComponentScan.
@ComponentScan(basePackages = "com.assignment")
@SpringBootApplication
public class Application extends SpringBootServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CountryService countryService(){
        return new CountryService();
    }
    
    @Bean
    public CountryDao countryDao(){
        return new CountryDao();
    }
}	