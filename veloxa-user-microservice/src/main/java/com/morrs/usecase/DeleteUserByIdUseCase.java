package com.morrs.usecase;

import com.morrs.api.input_ports.DeleteUserByIdApi;
import com.morrs.domain.entities.User;
import com.morrs.spi.output_ports.DeleteUserByIdSpi;
import com.morrs.spi.output_ports.FindUserByIdSpi;

import java.util.UUID;

public class DeleteUserByIdUseCase implements DeleteUserByIdApi {

    private final DeleteUserByIdSpi deleteUserByIdSpi;
    private final FindUserByIdSpi findUserByIdSpi;

    public DeleteUserByIdUseCase(DeleteUserByIdSpi deleteUserByIdSpi, FindUserByIdSpi findUserByIdSpi) {
        this.deleteUserByIdSpi = deleteUserByIdSpi;
        this.findUserByIdSpi = findUserByIdSpi;
    }

    @Override
    public User deleteUserById(UUID id) {
        var user = findUserByIdSpi.findUserById(id);
        deleteUserByIdSpi.deleteUserById(id);
        return user.orElse(null);
    }
}
