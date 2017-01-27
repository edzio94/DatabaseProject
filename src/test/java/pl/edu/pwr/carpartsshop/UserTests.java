package pl.edu.pwr.carpartsshop;

import com.fasterxml.jackson.core.JsonProcessingException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.edu.pwr.carpartsshop.product.model.dto.ProductDto;
import pl.edu.pwr.carpartsshop.product.service.ProductService;
import pl.edu.pwr.carpartsshop.user.user.model.dto.UserDto;
import pl.edu.pwr.carpartsshop.user.user.service.UserService;
import pl.edu.pwr.carpartsshop.user.userdetails.model.dto.UserDetailsDto;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by lukasz on 11/23/16.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserTests  {

    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;
    private UserDto userDto = UserDto.builder()
            .username("matteo")
            .password("qqqq")
            .userDetailsDto(UserDetailsDto
                    .builder()
                    .surname("Hullun")
                    .name("Matt")
                    .address("Beer street, Liverpool")
                    .isAdmin(true)
                    .created(new Date())
                    .build())
            .build();
    @Before
    public void addOneUserToDatabaseWithUserDetails() throws SQLException, JsonProcessingException {

        userService.saveUser(userDto);
    }

    @Test
    public void check(){
        Assert.assertTrue(2 == 2);
    }

    @Test
    public void shouldAddUser() throws SQLException, JsonProcessingException {

        assertThat(userService.getAll().size()).isEqualTo(2);
    }
    @Test
    public void shouldAddProductToUser(){
        ProductDto productDto = ProductDto.builder()
                .amount(213)
                .price(11.33)
                .name("Klocki Hamulcowe")
                .company("Moja company")
                .build();
        System.out.println("PRODUCT: "+productDto.toString());
        ProductDto productDto1 = productService.saveProduct(userDto.getUsername(),productDto);
        userService.addProductToUser(userDto,productDto1.getId());
        UserDto user = userService.getUser(userDto.getUsername());
        assertThat(user.getProductDtos().size()).isEqualTo(1);
        userDto.setUsername("Matt2");
        userDto.getUserDetailsDto().setAdmin(true);
        userDto.getUserDetailsDto().setAddress("Beer avenue, Liverpool");
        userService.saveUser(userDto);
        userService.addProductToUser(userDto,productDto1.getId());
    }
    @Test
    public void shouldDeleteProductFromUser(){
        ProductDto productDto = ProductDto.builder()
                .amount(213)
                .price(11.33)
                .name("Klocki Hamulcowe")
                .company("Moja company")
                .build();
        System.out.println("PRODUCT: "+productDto.toString());
        ProductDto productDto1 = productService.saveProduct(userDto.getUsername(),productDto);
        userService.addProductToUser(userDto,productDto1.getId());
        UserDto user = userService.getUser(userDto.getUsername());
        assertThat(user.getProductDtos().size()).isEqualTo(1);
        userService.deleteProduct(user.getUsername(),productDto1.getId());
        assertThat(userService.getUser(user.getUsername()).getProductDtos().size()).isEqualTo(0);
    }

    @Test
    public void shouldDeleteUser() throws JsonProcessingException {
        userDto.setUsername("Matt2");
        userDto.getUserDetailsDto().setAdmin(true);
        userDto.getUserDetailsDto().setAddress("Beer avenue, Liverpool");
        userService.saveUser(userDto);
        userService.deleteUser(userDto.getUsername());
        assertThat(userService.getAll().size()).isEqualTo(1);
    }
    @Test
    public void checkIfValidUser(){

    }
    @Test
    public void shouldFindUserIdByUsername(){
        List<UserDto> all = userService.getAll();
//        Assert.assertEquals(all.get(0).,userService.findUserIdByUsername(userDto.getUsername()));
    }

    @Test
    public void shouldModifyUser() {
        String newPwd = "newPaswd";
        userDto = userService.getUser(userDto.getUsername());
        userDto.setPassword(newPwd);
        userService.saveUser(userDto);
        assertThat(userService.getUser(userDto.getUsername()).getPassword()).isEqualTo(newPwd);
    }

}