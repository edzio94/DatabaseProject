package pl.edu.pwr.carpartsshop.product.model.entity;

import lombok.*;

import javax.persistence.*;

/**
 * Created by lukasz on 1/8/17.
 */
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String company;
    private String name;
    private int amount;
    private double price;
}
