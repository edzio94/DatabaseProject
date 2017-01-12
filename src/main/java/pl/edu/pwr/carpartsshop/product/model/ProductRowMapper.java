package pl.edu.pwr.carpartsshop.product.model;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import pl.edu.pwr.carpartsshop.product.model.entity.ProductEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lukasz on 1/12/17.
 */
public class ProductRowMapper implements ResultSetExtractor<ProductEntity> {
    @Override
    public ProductEntity extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        return ProductEntity.builder()
        .id(resultSet.getInt(1))
                .company(resultSet.getString(2))
                .name(resultSet.getString(3))
                .amount(resultSet.getInt(4))
                .price(resultSet.getDouble(5))
                .build();
    }
}
