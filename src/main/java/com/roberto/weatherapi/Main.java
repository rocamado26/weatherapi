package com.roberto.weatherapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.scheduling.annotation.EnableAsync;

import static java.lang.System.getenv;

@SpringBootApplication
@EnableAsync
@PropertySource("classpath:application.yaml")
public class Main {

    public static void main(String[] args) {

        ConfigurableEnvironment environment = new StandardEnvironment();
        environment.setActiveProfiles(getenv("PROFILE_ACTIVE"));
        int cores = Runtime.getRuntime().availableProcessors();
        SpringApplication sa = new SpringApplication(Main.class);
        sa.setEnvironment(environment);
        sa.run(args);
    }

}