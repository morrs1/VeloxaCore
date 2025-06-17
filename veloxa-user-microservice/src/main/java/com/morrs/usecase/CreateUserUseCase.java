package com.morrs.usecase;

import com.morrs.api.input_ports.CreateUserApi;
import com.morrs.domain.entities.User;
import com.morrs.spi.output_ports.CreateUserSpi;

import java.util.UUID;

public class CreateUserUseCase implements CreateUserApi {

    private final CreateUserSpi createUserSpi;

    public CreateUserUseCase(CreateUserSpi createUserSpi) {
        this.createUserSpi = createUserSpi;
    }

    @Override
    public User createUser(User user) {
        user.setId(UUID.randomUUID());
        return createUserSpi.createUser(user);
    }


}
