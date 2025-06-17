package com.morrs;

import com.morrs.spi.adapters.postgres_jdbc.CreateUserJdbcTemplateAdapter;
import com.morrs.spi.adapters.postgres_jdbc.DeleteUserByIdJdbcTemplateAdapter;
import com.morrs.spi.adapters.postgres_jdbc.FindUserByIdJdbcTemplateAdapter;
import com.morrs.spi.adapters.postgres_jdbc.UpdateUserInfoJdbcTemplateAdapter;
import com.morrs.usecase.CreateUserUseCase;
import com.morrs.usecase.DeleteUserByIdUseCase;
import com.morrs.usecase.FindUserByIdUseCase;
import com.morrs.usecase.UpdateUserUseCase;
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

    @Bean
    public CreateUserUseCase createUserUseCase(JdbcTemplate jdbcTemplate) {
        return new CreateUserUseCase(new CreateUserJdbcTemplateAdapter(jdbcTemplate));
    }

    @Bean
    public UpdateUserUseCase updateUserUseCase(JdbcTemplate jdbcTemplate) {
        return new UpdateUserUseCase(new UpdateUserInfoJdbcTemplateAdapter(jdbcTemplate));
    }

    @Bean
    public DeleteUserByIdUseCase deleteUserByIdUseCase(JdbcTemplate jdbcTemplate) {
        return new DeleteUserByIdUseCase(
                new DeleteUserByIdJdbcTemplateAdapter(jdbcTemplate),
                new FindUserByIdJdbcTemplateAdapter(jdbcTemplate)
        );
    }
}
