package com.morrs;

import com.morrs.spi.adapters.postgres_jdbc.FindUserByIdJdbcTemplateAdapter;
import com.morrs.usecase.FindUserByIdUseCase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class VeloxaUserMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VeloxaUserMicroserviceApplication.class, args);
    }


    @Bean
    public FindUserByIdUseCase findUserByIdUseCase(JdbcTemplate jdbcTemplate) {
        return new FindUserByIdUseCase(new FindUserByIdJdbcTemplateAdapter(jdbcTemplate));
    }
}
