package pl.edu.pwr.carpartsshop.order.model.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by lukasz on 1/9/17.
 */
@Getter
@Setter
@Builder
public class OrderProductEntity {
    private int id;
    private int productId;
    private int orderId;

}
