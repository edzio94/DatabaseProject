package pl.edu.pwr.carpartsshop.user.user.model.entity;


import lombok.*;
import pl.edu.pwr.carpartsshop.product.model.entity.ProductEntity;
import pl.edu.pwr.carpartsshop.user.userdetails.model.entity.UserDetailsEntity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by lukasz on 11/23/16.
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @Size(min = 3, max = 50)
    private String username;
    @Size(min = 3, max = 50)
    private String password;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn
    private UserDetailsEntity userDetailsEntity;
    @ManyToMany(fetch = FetchType.EAGER)
    List<ProductEntity> productsOrdered;

}
