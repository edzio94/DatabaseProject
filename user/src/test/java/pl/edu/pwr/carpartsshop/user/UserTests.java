package pl.edu.pwr.carpartsshop.user;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by lukasz on 11/23/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserTests {
    @Test
    public void check(){
        Assert.assertTrue(2 == 2);
    }
    @Test
    public void shouldAddUser(){

    }
    @Test
    public void shouldDeleteUser(){

    }
    @Test
    public void checkIfValidUser(){

    }

}
