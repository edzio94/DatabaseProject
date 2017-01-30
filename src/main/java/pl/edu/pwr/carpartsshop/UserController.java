package pl.edu.pwr.carpartsshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwr.carpartsshop.user.user.model.dto.UserDto;
import pl.edu.pwr.carpartsshop.user.user.repository.UserRepository;
import pl.edu.pwr.carpartsshop.user.user.service.UserService;

/**
 * Created by lukasz on 1/27/17.
 */
@RequestMapping("/user")
@RestController
public class UserController {
@Autowired
private UserService userService;

    @PostMapping("/addUser")
    public String addUser(@RequestBody UserDto userDto) {
        userService.saveUser(userDto);
        return "User added to database";
    }
    @PostMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable String id){
        userService.deleteUser(id);
        return "User deleted from database";
    }
    @PostMapping("/addProduct/{id}")
    public String addProductToUser(@PathVariable int id,@RequestBody UserDto userDto) {
        userService.addProductToUser(userDto,id);
        return "Executed add product to database";
    }
    @PostMapping("/modifyUser")
    public String modifyUser(@RequestBody UserDto userDto){
        userService.modifyUser(userDto);
            return "Modifying user";

    }

}
