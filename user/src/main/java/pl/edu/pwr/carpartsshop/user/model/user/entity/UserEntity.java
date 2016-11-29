package pl.edu.pwr.carpartsshop.user.model.user.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.edu.pwr.carpartsshop.user.model.userdetails.entity.UserDetailsEntity;

/**
 * Created by lukasz on 11/23/16.
 */
@Getter
@Setter
@ToString
public class UserEntity {
    private int id;
    private int username;
    private int password;
    private UserDetailsEntity userDetailsEntity;

    public UserEntity() {
    }
    public UserEntity(int id, int username, int password, UserDetailsEntity userDetailsEntity) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userDetailsEntity = userDetailsEntity;
    }
}
