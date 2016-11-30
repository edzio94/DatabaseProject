package pl.edu.pwr.carpartsshop.user;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import pl.edu.pwr.carpartsshop.user.model.user.dto.UserDto;
import pl.edu.pwr.carpartsshop.user.model.user.service.UserService;
import pl.edu.pwr.carpartsshop.user.model.userdetails.dto.UserDetailsDto;
import pl.edu.pwr.carpartsshop.web.AppInit;

import java.sql.SQLException;
import java.util.Date;

/**
 * Created by lukasz on 11/23/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppInit.class)
@TestPropertySource("classpath:application-test.properties")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserTests {

    @Autowired
    private UserService userService;

    private UserDto userDto = UserDto.builder()
            .username("matteo")
            .password("qqqq")
            .userDetailsDto(UserDetailsDto
                    .builder()
                    .surname("Hullun")
                    .name("Matt")
                    .address("Beer street, Liverpool")
                    .id(1)
                    .isAdmin(false)
                    .created(new Date())
                    .build())
            .build();
    @Before
    public void addOneUserToDatabaseWithUserDetails() throws SQLException {
        userService.saveUser(userDto);
    }

    @Test
    public void check(){
        Assert.assertTrue(2 == 2);
    }

    @Test

    public void shouldAddUser() throws SQLException {
        userDto.setUsername("Matt2");
        userDto.getUserDetailsDto().setAdmin(true);
        userDto.getUserDetailsDto().setAddress("Beer avenue, Liverpool");
        userService.saveUser(userDto);

    }
    @Test
    public void shouldDeleteUser(){

    }
    @Test
    public void checkIfValidUser(){

    }
    @Test
    public void shouldFindUserIdByUsername(){
        Assert.assertEquals(1,userService.findUserIdByUsername(userDto.getUsername()));
    }

}
