package com.morrs.usecase;

import com.morrs.api.input_ports.CreateUserApi;
import com.morrs.domain.entities.User;
import com.morrs.spi.output_ports.CreateUserSpi;

public class CreateUserUseCase implements CreateUserApi {

    private final CreateUserSpi createUserSpi;

    public CreateUserUseCase(CreateUserSpi createUserSpi) {
        this.createUserSpi = createUserSpi;
    }

    @Override
    public User createUser(User user) {
        return createUserSpi.createUser(user);
    }


}
