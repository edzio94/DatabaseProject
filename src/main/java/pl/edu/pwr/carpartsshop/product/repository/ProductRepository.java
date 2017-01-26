package pl.edu.pwr.carpartsshop.product.repository;

import org.springframework.stereotype.Repository;
import pl.edu.pwr.carpartsshop.product.model.dto.ProductDto;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by lukasz on 1/8/17.
 */
@Repository
public interface ProductRepository {
    String SAVE_PRODUCT = "INSERT INTO PRODUCT(company,name,price,amount) VALUES(?,?,?,?)";
    String GET_PRODUCT = "SELECT * FROM PRODUCT WHERE ID = ?";
    String DELETE_PRODUCT = "DELETE FROM PRODUCT WHERE ID = ?";
    String GET_ALL_PRODUCTS = "SELECT * FROM PRODUCT";
    String UPDATE_PRODUCT = "UPDATE PRODUCT SET company = ?, name = ? , price = ?, amount = ? WHERE id = ?";
    ProductDto saveProduct(ProductDto productDto) throws SQLException;
    ProductDto getProduct(int id);
    List<ProductDto> getProducts();
    void updateProduct(ProductDto productDto) throws SQLException;
}
