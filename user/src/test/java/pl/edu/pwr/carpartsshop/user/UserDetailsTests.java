package pl.edu.pwr.carpartsshop.user;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import pl.edu.pwr.carpartsshop.user.userdetails.model.dto.UserDetailsDto;
import pl.edu.pwr.carpartsshop.user.userdetails.service.UserDetailsService;

import java.sql.SQLException;
import java.util.Date;

/**
 * Created by lukasz on 11/29/16.
 */
@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
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
//        System.out.println("TESTSSS");
        userDetailsService.saveUserDetails(userDetailsDto1);

    }

    @Test
    public void shouldFindUserDetailsById() throws SQLException {
        UserDetailsDto userDetailsDto = userDetailsService.findUserDetailsById(userDetailsDto1.getId());

        Assert.assertNull("Find UserDetails by ID",userDetailsDto);
    }
}
