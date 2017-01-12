package pl.edu.pwr.carpartsshop.order.model.entity;

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
public class OrderEntity {
    private int id;
    private int userId;
    private Date orderDate;

}
