package pl.edu.pwr.carpartsshop.order.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import pl.edu.pwr.carpartsshop.product.model.dto.ProductDto;

import java.util.Date;
import java.util.List;

/**
 * Created by lukasz on 1/9/17.
 */
@Getter
@Setter
@Builder
public class OrderDto {
    private int id;
    private int userId;
    List<ProductDto> productDtoList;
    private Date orderDate;
}
