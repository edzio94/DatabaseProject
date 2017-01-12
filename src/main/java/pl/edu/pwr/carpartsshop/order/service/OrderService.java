package pl.edu.pwr.carpartsshop.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import pl.edu.pwr.carpartsshop.order.Repository.OrderRepository;
import pl.edu.pwr.carpartsshop.order.model.dto.OrderDto;
import pl.edu.pwr.carpartsshop.order.model.dto.OrderProductDto;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by lukasz on 1/9/17.
 */
@Service
public class OrderService implements OrderRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private OrderProductService orderProductService;

    @Override
    public OrderDto saveOrder(OrderDto orderDto) throws SQLException {
        PreparedStatement statement = jdbcTemplate.getDataSource().getConnection().prepareStatement(SAVE_ORDER, new String[] {"id"});
        statement.setInt(1,orderDto.getUserId());
        statement.setDate(2, new Date(new java.util.Date().getTime()));
        statement.execute();
        ResultSet generatedKeys = statement.getGeneratedKeys();
        if(generatedKeys.next()) {
            orderDto.setId(generatedKeys.getInt(1));
        }

            orderDto.getProductDtoList().stream()
                    .map(x -> OrderProductDto
                            .builder()
                            .orderId(orderDto.getId())
                            .productId(x.getId())
                            .build()).forEach((orderProductDto) -> {
                try {
                    orderProductService.saveOrderProduct(orderProductDto);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });

        return orderDto;
    }

    @Override
    public OrderDto updateOrder(OrderDto orderDto) {

    return null;
    }
}
