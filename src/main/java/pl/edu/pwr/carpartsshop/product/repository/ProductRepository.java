package pl.edu.pwr.carpartsshop.product.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pwr.carpartsshop.product.model.dto.ProductDto;
import pl.edu.pwr.carpartsshop.product.model.entity.ProductEntity;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by lukasz on 1/8/17.
 */
@Repository
public interface ProductRepository extends CrudRepository<ProductEntity,Integer> {

}
