package pl.edu.pwr.carpartsshop.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lukasz on 11/17/16.
 */
@RestController
public class MainController {


    @RequestMapping("/")
    public String helloWorld(){
        return "HelloWorld";
    }
}
