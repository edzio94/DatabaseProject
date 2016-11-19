package pl.edu.pwr.carpartsshop.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lukasz on 11/17/16.
 */
@Configuration
@ComponentScan
//@EnableAutoConfiguration
@SpringBootApplication
public class AppInit {
    public static void main(String[] args) {

        SpringApplication.run(AppInit.class, args);
    }
}
