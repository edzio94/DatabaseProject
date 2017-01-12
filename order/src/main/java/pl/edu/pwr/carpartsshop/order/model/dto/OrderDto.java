package pl.edu.pwr.carpartsshop.order.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by lukasz on 1/9/17.
 */
@Getter
@Setter
@Builder
public class OrderDto {
    private int id;
    private int userId;
    private Date orderDate;
}
