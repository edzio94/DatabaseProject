package pl.edu.pwr.carpartsshop.product.model.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by lukasz on 1/8/17.
 */
@Getter
@Setter
@ToString
@Builder
public class ProductEntity {
    private int id;
    private String company;
    private String name;
    private int amount;
    private double price;
}
