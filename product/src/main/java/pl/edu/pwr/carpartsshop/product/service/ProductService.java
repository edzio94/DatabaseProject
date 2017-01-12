package pl.edu.pwr.carpartsshop.product.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import pl.edu.pwr.carpartsshop.product.model.dto.ProductDto;
import pl.edu.pwr.carpartsshop.product.model.entity.ProductEntity;
import pl.edu.pwr.carpartsshop.product.repository.ProductRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lukasz on 1/8/17.
 */
@Service
public class ProductService implements ProductRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public ProductDto saveProduct(ProductDto productDto) throws SQLException {
        PreparedStatement statement = jdbcTemplate.getDataSource()
                .getConnection().prepareStatement(SAVE_PRODUCT, new String[]{"id"});
        statement.setString(1,productDto.getCompany());
        statement.setString(2,productDto.getName());
        statement.setDouble(3,productDto.getPrice());
        statement.setInt(4,productDto.getAmount());
        statement.execute();
        ResultSet generatedKeys = statement.getGeneratedKeys();
        if(generatedKeys.next()) {
            System.out.printf("TEST");
            productDto.setId(generatedKeys.getInt(1));
        }
        return productDto;
    }

    @Override
    public ProductDto getProdut(int id) {
        ProductEntity productEntity = jdbcTemplate.queryForObject(GET_PRODUCT, new Object[]{id}, new BeanPropertyRowMapper<>(ProductEntity.class));
        return new ModelMapper().map(productEntity,ProductDto.class);
    }

    @Override
    public void updateProduct(ProductDto productDto) throws SQLException {
        PreparedStatement statement = jdbcTemplate.getDataSource()
                .getConnection().prepareStatement(UPDATE_PRODUCT);
        statement.setString(1, productDto.getCompany());
        statement.setString(2,productDto.getName());
        statement.setDouble(3,productDto.getPrice());
        statement.setInt(4,productDto.getAmount());
        statement.setInt(5,productDto.getId());
        statement.execute();



    }
}
