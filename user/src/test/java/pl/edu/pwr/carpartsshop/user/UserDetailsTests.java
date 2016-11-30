package pl.edu.pwr.carpartsshop.user;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import pl.edu.pwr.carpartsshop.user.model.userdetails.dto.UserDetailsDto;
import pl.edu.pwr.carpartsshop.user.model.userdetails.service.UserDetailsService;
import pl.edu.pwr.carpartsshop.web.AppInit;

import java.sql.SQLException;
import java.util.Date;

/**
 * Created by lukasz on 11/29/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppInit.class)
@TestPropertySource("classpath:application-test.properties")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserDetailsTests {
    @Autowired
    private UserDetailsService userDetailsService;

    private UserDetailsDto userDetailsDto1 = UserDetailsDto
            .builder()
            .surname("Hullun")
            .name("Matt")
            .userId(2)
            .address("Beer street, Liverpool")
            .isAdmin(false)
            .created(new Date())
            .build();
    @Before
    public void addDataToDatabase() throws SQLException {
        System.out.println("TESTSSS");
        userDetailsService.saveUserDetails(userDetailsDto1);
    }

    @Test
    public void shouldFindUserDetailsById() throws SQLException {
        UserDetailsDto userDetailsDto = userDetailsService.findUserDetailsById(userDetailsDto1.getId());
        Assert.assertNotNull("Find UserDetails by ID",userDetailsDto);
    }
    @Test
    public void shouldFindUserDetailsByUserId() {

    }
    @Test
    public void shouldDeleteUserDetailsById(){

    }
}
