package pl.edu.pwr.carpartsshop.web;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import pl.edu.pwr.carpartsshop.web.controller.MainController;
import pl.edu.pwr.carpartsshop.web.controller.UserController;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/**
 * Created by lukasz on 11/23/16.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(MainController.class)
public class MockMvcIntegrationTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void shouldReturnHelloWorldInRest() throws Exception {
        this.mvc
                .perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("HelloWorld"));
    }
}
