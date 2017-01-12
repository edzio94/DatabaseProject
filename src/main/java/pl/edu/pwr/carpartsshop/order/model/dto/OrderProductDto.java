package pl.edu.pwr.carpartsshop.order.model.dto;

import lombok.*;

/**
 * Created by lukasz on 1/9/17.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderProductDto {
    private int id;
    private int productId;
    private int orderId;
}
