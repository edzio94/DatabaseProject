package pl.edu.pwr.carpartsshop.user.user.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javaslang.collection.Stream;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;
import pl.edu.pwr.carpartsshop.product.model.dto.ProductDto;
import pl.edu.pwr.carpartsshop.product.model.entity.ProductEntity;
import pl.edu.pwr.carpartsshop.product.repository.ProductRepository;
import pl.edu.pwr.carpartsshop.product.service.ProductService;
import pl.edu.pwr.carpartsshop.user.user.model.dto.UserDto;
import pl.edu.pwr.carpartsshop.user.user.model.entity.UserEntity;
import pl.edu.pwr.carpartsshop.user.user.repository.UserRepository;
import pl.edu.pwr.carpartsshop.user.userdetails.model.dto.UserDetailsDto;
import pl.edu.pwr.carpartsshop.user.userdetails.model.entity.UserDetailsEntity;
import pl.edu.pwr.carpartsshop.user.userdetails.service.UserDetailsService;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


/**
 * Created by lukasz on 11/23/16.
 */
@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;
    private static Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private ModelMapper mapper;

    public void saveUser(UserDto userDto) {
        UserEntity map = mapper.map(userDto, UserEntity.class);
        map.setUserDetailsEntity(mapper.map(userDto.getUserDetailsDto(), UserDetailsEntity.class));
        userRepository.save(map);
    }
    public void addProductToUser(UserDto userDto, int productId) {
        UserEntity x = userRepository.findOne(userDto.getUsername());
        ProductEntity product = productRepository.findOne(productId);
        if(product != null) {
            x.getProductsOrdered().add(product);
        }
    }

    public List<UserDto> getAll() {
       return Stream.ofAll(userRepository.findAll())
                .map(x -> {
                            UserDto dto = mapper.map(x, UserDto.class);
                            dto.setUserDetailsDto(mapper.map(x.getUserDetailsEntity(), UserDetailsDto.class));
                            return dto;
                        }
                )
                .toJavaList();
    }
    public void deleteProduct(String userId,Integer productId) {
        UserEntity one = userRepository.findOne(userId);
        one.setProductsOrdered(one.getProductsOrdered().stream().filter(i -> i.getId() != productId).collect(Collectors.toList()));
    }

    public void deleteUser(String id){
        userRepository.delete(id);
    }

    public UserDto getUser(String id){
        UserEntity one = userRepository.findOne(id);
        UserDto userDto = mapper.map(one,UserDto.class);
        userDto.setUserDetailsDto(mapper.map(one.getUserDetailsEntity(),UserDetailsDto.class));
        userDto.setProductDtos(mapper.map(one.getProductsOrdered(),List.class));
        return userDto;
    }
    @Transactional
    public boolean modifyUser(UserDto userDto){
        UserEntity one = userRepository.findOne(userDto.getUsername());
        if (one != null) {
            one = mapper.map(userDto,UserEntity.class);
            one.setUserDetailsEntity(mapper.map(userDto.getUserDetailsDto(),UserDetailsEntity.class));
            userRepository.save(one);
            return true;
        }
        return false;
    }

}
