package pl.edu.pwr.carpartsshop.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import pl.edu.pwr.carpartsshop.order.Repository.OrderProductRepository;

/**
 * Created by lukasz on 1/9/17.
 */
public class OrderProductService implements OrderProductRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
}
