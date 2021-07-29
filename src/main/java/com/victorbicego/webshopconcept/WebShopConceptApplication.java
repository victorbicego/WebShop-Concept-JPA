package com.victorbicego.webshopconcept;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebShopConceptApplication implements CommandLineRunner {

    public WebShopConceptApplication(WebShopFunctions webShopFunctions) {
        this.webShopFunctions = webShopFunctions;
    }

    WebShopFunctions webShopFunctions;

    public static void main(String[] args) {
        SpringApplication.run(WebShopConceptApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        webShopFunctions.webShopMainMenu();
    }
}
