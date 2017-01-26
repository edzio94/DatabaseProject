package pl.edu.pwr.carpartsshop.order.model.entity;

import lombok.*;

/**
 * Created by lukasz on 1/9/17.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderProductEntity {
    private int id;
    private int productId;
    private int orderId;

}
