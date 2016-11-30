package pl.edu.pwr.carpartsshop.user.model.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.edu.pwr.carpartsshop.user.model.userdetails.dto.UserDetailsDto;

/**
 * Created by lukasz on 11/23/16.
 */
@Getter
@Setter
@Builder
@ToString
public class UserDto {
    private String username;
    private String password;
    private UserDetailsDto userDetailsDto;


    public UserDto() {
    }

    public UserDto(String username, String password, UserDetailsDto userDetailsDto) {
        this.username = username;
        this.password = password;
        this.userDetailsDto = userDetailsDto;
    }
}

