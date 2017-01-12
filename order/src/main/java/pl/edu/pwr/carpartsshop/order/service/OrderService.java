package pl.edu.pwr.carpartsshop.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import pl.edu.pwr.carpartsshop.order.Repository.OrderRepository;
import pl.edu.pwr.carpartsshop.order.model.dto.OrderDto;

import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * Created by lukasz on 1/9/17.
 */
public class OrderService implements OrderRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public OrderDto saveOrder(OrderDto orderDto) throws SQLException {
        PreparedStatement statement = jdbcTemplate.getDataSource().getConnection().prepareStatement(SAVE_ORDER);

        return null;
    }

    @Override
    public OrderDto updateOrder(OrderDto orderDto) {

        return null;
    }
}
