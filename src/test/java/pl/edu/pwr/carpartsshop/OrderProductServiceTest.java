package pl.edu.pwr.carpartsshop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import pl.edu.pwr.carpartsshop.order.model.dto.OrderDto;
import pl.edu.pwr.carpartsshop.order.model.dto.OrderProductDto;
import pl.edu.pwr.carpartsshop.order.service.OrderProductService;
import pl.edu.pwr.carpartsshop.order.service.OrderService;
import pl.edu.pwr.carpartsshop.product.model.dto.ProductDto;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by lukasz on 1/12/17.
 */
@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class OrderProductServiceTest {

    @Autowired
    private OrderProductService orderProductService;
    @Autowired
    private OrderService orderService;

    private OrderDto orderDto = OrderDto.builder()
            .orderDate(new Date())
            .productDtoList(Arrays.asList(ProductDto.builder()
            .id(123)
            .company("www")
            .name("wwwq")
            .build()))
            .userId(12)
            .build();



    @Test
    public void addOrder() throws SQLException {
        OrderDto orderDto = orderService.saveOrder(this.orderDto);
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void deleteOrder() throws SQLException {
        OrderDto orderDto = orderService.saveOrder(this.orderDto);
        OrderProductDto orderProductDto = OrderProductDto.builder()
                .orderId(orderDto.getId())
                .productId(23)
                .build();
        OrderProductDto orderProductDto1 = orderProductService.saveOrderProduct(orderProductDto);
        orderProductService.getOrderProduct(orderProductDto1);
        orderProductService.deleteOrderProduct(orderProductDto1.getId());
        orderProductService.getOrderProduct(orderProductDto1);
    }
}
