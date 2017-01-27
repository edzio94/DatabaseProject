package pl.edu.pwr.carpartsshop.user.user.model.dto;


import lombok.*;
import pl.edu.pwr.carpartsshop.product.model.dto.ProductDto;
import pl.edu.pwr.carpartsshop.user.userdetails.model.dto.UserDetailsDto;

import java.util.List;

/**
 * Created by lukasz on 11/23/16.
 */
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String username;
    private String password;
    private UserDetailsDto userDetailsDto;
    private List<ProductDto> productDtos;
}

