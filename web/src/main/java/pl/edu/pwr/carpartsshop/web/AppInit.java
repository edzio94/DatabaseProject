package pl.edu.pwr.carpartsshop.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by lukasz on 11/17/16.
 */

@SpringBootApplication (scanBasePackages = "pl.edu.pwr")
public class AppInit {

    public static void main(String[] args) {
        SpringApplication.run(AppInit.class, args);
    }

}
