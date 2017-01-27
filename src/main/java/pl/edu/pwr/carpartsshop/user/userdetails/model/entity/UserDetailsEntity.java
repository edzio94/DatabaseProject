package pl.edu.pwr.carpartsshop.user.userdetails.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by lukasz on 11/29/16.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "userdetails")
@Entity
public class UserDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date created;
    private boolean isAdmin;
    private String name;
    private String surname;
    private String address;

}
