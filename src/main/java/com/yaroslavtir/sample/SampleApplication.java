package com.yaroslavtir.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SampleApplication {

  public static void main(String[] args) {
    ConfigurableApplicationContext context = SpringApplication.run(SampleApplication.class, args);

  }

}
