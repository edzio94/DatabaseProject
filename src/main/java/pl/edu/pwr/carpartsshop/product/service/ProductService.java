package pl.edu.pwr.carpartsshop.product.service;


import javaslang.collection.Stream;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import pl.edu.pwr.carpartsshop.product.model.dto.ProductDto;
import pl.edu.pwr.carpartsshop.product.model.entity.ProductEntity;
import pl.edu.pwr.carpartsshop.product.repository.ProductRepository;
import pl.edu.pwr.carpartsshop.user.user.repository.UserRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by lukasz on 1/8/17.
 */
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper mapper;

    public ProductDto saveProduct(String id,ProductDto productDto) {
        if (userRepository.findOne(id).getUserDetailsEntity().isAdmin()) {
            ProductEntity map = mapper.map(productDto, ProductEntity.class);
            ProductEntity save = productRepository.save(map);
            return mapper.map(save, ProductDto.class);
        }
        else
            return null;

    }


    public ProductDto getProduct(int id) {
        return mapper.map(productRepository.findOne(id),ProductDto.class);
    }


    public List<ProductDto> getProducts() {
        return Stream.ofAll(productRepository.findAll())
                .map(i -> mapper.map(i,ProductDto.class))
                .toJavaList();
    }



    public void updateProduct(ProductDto productDto) throws SQLException {

    }
    public void deleteProduct(ProductDto productDto) throws SQLException {

    }

}
