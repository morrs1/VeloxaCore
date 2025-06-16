package com.morrs.usecase;

import com.morrs.api.input_ports.FindUserByIdApi;
import com.morrs.domain.entities.User;
import com.morrs.spi.output_ports.FindUserByIdSpi;

import java.util.UUID;

public class FindUserByIdUseCase implements FindUserByIdApi {

    private final FindUserByIdSpi findUserByIdSpi;

    public FindUserByIdUseCase(FindUserByIdSpi findUserByIdSpi) {
        this.findUserByIdSpi = findUserByIdSpi;
    }

    @Override
    public User findUserById(UUID id) {
        return findUserByIdSpi.findUserById(id).orElse(null);
    }
}
