package pl.edu.pwr.carpartsshop.user.userdetails.model.dto;

import lombok.*;

import java.util.Date;

/**
 * Created by lukasz on 11/29/16.
 */
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsDto {
    private int id;
    private Date created;
    private boolean isAdmin;
    private String name;
    private String surname;
    private String address;

}
