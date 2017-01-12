package pl.edu.pwr.carpartsshop.order.Repository;

import org.springframework.stereotype.Repository;
import pl.edu.pwr.carpartsshop.order.model.dto.OrderDto;

import java.sql.SQLException;

/**
 * Created by lukasz on 1/9/17.
 */
@Repository
public interface OrderRepository {
    String SAVE_ORDER = "INSERT INTO userOrder(userId,orderDate) VALUES (?,?)";
    OrderDto saveOrder(OrderDto orderDto) throws SQLException;
    OrderDto updateOrder(OrderDto orderDto);
}
