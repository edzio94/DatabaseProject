package pl.edu.pwr.carpartsshop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pwr.carpartsshop.user.user.model.dto.UserDto;
import pl.edu.pwr.carpartsshop.user.user.service.UserService;
import pl.edu.pwr.carpartsshop.user.userdetails.model.dto.UserDetailsDto;

import java.util.Date;

/**
 * Created by lukasz on 12/14/16.
 */
@RequestMapping("/user")
@RestController
public class MainController {

    @Autowired
    private UserService userService;
    @RequestMapping("/test")
    public String returnTest(){
        return "TEST";
    }

    @RequestMapping("/getUser")
    public UserDto getUserById(){
        return UserDto.builder()
                .username("testowy")
                .password("@#!#@fdssdf32df")
                .userDetailsDto(UserDetailsDto.builder()
                .userId(1)
                .id(1)
                .address("Bujwida 33, Wrocław")
                .isAdmin(false)
                .created(new Date())
                        .name("Lukasz")
                        .surname("Nowy")
                .build())
                .build();
    }
}
