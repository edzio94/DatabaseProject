package pl.edu.pwr.carpartsshop.order.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by lukasz on 1/9/17.
 */
@Getter
@Setter
@Builder
public class OrderProductDto {
    private int id;
    private int itemId;
    private int productId;
}
