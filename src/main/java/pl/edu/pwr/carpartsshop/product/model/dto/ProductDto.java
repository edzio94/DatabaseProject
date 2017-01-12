package pl.edu.pwr.carpartsshop.product.model.dto;

import lombok.*;

/**
 * Created by lukasz on 1/8/17.
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDto {
    private int id;
    private String company;
    private String name;
    private int amount;
    private double price;
}
