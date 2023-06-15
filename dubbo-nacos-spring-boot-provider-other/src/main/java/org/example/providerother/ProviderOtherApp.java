package org.example.providerother;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class ProviderOtherApp {

    public static void main(String[] args) {
        SpringApplication.run(ProviderOtherApp.class, args);
    }
}
