package pl.edu.pwr.carpartsshop.user.model.userdetails.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * Created by lukasz on 11/29/16.
 */
@Builder
@Getter
@Setter
@ToString
public class UserDetailsDto {
    private int id;
    private Date created;
    private boolean isAdmin;
    private String name;
    private String surname;
    private String address;

    public UserDetailsDto() {
    }

    public UserDetailsDto(int id, Date created, boolean isAdmin, String name, String surname, String address) {
        this.id = id;
        this.created = created;
        this.isAdmin = isAdmin;
        this.name = name;
        this.surname = surname;
        this.address = address;
    }
}
