package pl.edu.pwr.carpartsshop.order.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import pl.edu.pwr.carpartsshop.order.Repository.OrderProductRepository;
import pl.edu.pwr.carpartsshop.order.model.dto.OrderProductDto;
import pl.edu.pwr.carpartsshop.order.model.entity.OrderProductEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lukasz on 1/9/17.
 */
@Service
public class OrderProductService implements OrderProductRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public OrderProductDto saveOrderProduct(OrderProductDto orderProductDto) throws SQLException {
        PreparedStatement ps = jdbcTemplate.getDataSource().getConnection().prepareStatement(SAVE_ORDER_PRODUCT);
        ps.setInt(1,orderProductDto.getProductId());
        ps.setInt(2,orderProductDto.getOrderId());
        ps.execute();
        ResultSet generatedKeys = ps.getGeneratedKeys();
        if(generatedKeys.next()) {
            orderProductDto.setId(generatedKeys.getInt(1));
        }
        return orderProductDto;
    }

    @Override
    public OrderProductDto getOrderProduct(OrderProductDto orderProductDto) throws SQLException {
        OrderProductEntity orderProductEntity = jdbcTemplate.queryForObject(GET_ORDER_PRODUCT, new Object[]{orderProductDto.getId()}, new BeanPropertyRowMapper<>(OrderProductEntity.class));
        return new ModelMapper().map(orderProductEntity,OrderProductDto.class);
    }


    @Override
    public void deleteOrderProduct(int id) {
        jdbcTemplate.update(DELETE_PRODUCT,new Object[]{id});
    }

}
