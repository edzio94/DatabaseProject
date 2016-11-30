package pl.edu.pwr.carpartsshop.user.model.userdetails.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by lukasz on 11/29/16.
 */
@Getter
@Setter
@Builder
public class UserDetailsEntity {
    private int id;
    private Date created;
    private boolean isAdmin;
    private String name;
    private String surname;
    private String address;
    private int userId;

    public UserDetailsEntity() {
    }

    public UserDetailsEntity(int id, Date created, boolean isAdmin, String name, String surname, String address,int userId) {
        this.id = id;
        this.created = created;
        this.isAdmin = isAdmin;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.userId = userId;
    }
}
