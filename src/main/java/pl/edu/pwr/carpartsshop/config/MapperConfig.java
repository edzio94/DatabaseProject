package pl.edu.pwr.carpartsshop.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lukasz on 1/26/17.
 */
@Configuration
public class MapperConfig {
    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }
}
