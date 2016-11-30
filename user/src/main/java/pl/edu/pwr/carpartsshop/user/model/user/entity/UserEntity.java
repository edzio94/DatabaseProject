package pl.edu.pwr.carpartsshop.user.model.user.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.edu.pwr.carpartsshop.user.model.userdetails.dto.UserDetailsDto;
import pl.edu.pwr.carpartsshop.user.model.userdetails.entity.UserDetailsEntity;

/**
 * Created by lukasz on 11/23/16.
 */
@Getter
@Setter
@ToString
public class UserEntity {
    private String username;
    private String password;
    private UserDetailsEntity userDetailsEntity;

    public UserEntity() {
    }

    public UserEntity(String username, String password, UserDetailsEntity userDetailsEntity) {
        this.username = username;
        this.password = password;
        this.userDetailsEntity = userDetailsEntity;
    }
}
