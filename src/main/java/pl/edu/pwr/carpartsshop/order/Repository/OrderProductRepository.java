package pl.edu.pwr.carpartsshop.order.Repository;

import org.springframework.stereotype.Repository;
import pl.edu.pwr.carpartsshop.order.model.dto.OrderProductDto;

import java.sql.SQLException;

/**
 * Created by lukasz on 1/9/17.
 */
@Repository
public interface OrderProductRepository {
    String SAVE_ORDER_PRODUCT = "INSERT INTO ORDERPRODUCT(productId, orderId) VALUES (?,?)";
    String DELETE_PRODUCT = "DELETE FROM ORDERPRODUCT WHERE id = ?";
    OrderProductDto saveOrderProduct(OrderProductDto orderProductDto) throws SQLException;
    void deleteOrderProduct(int id);
}
