package com.morrs.usecase;

import com.morrs.api.input_ports.FindAllUsersApi;
import com.morrs.domain.entities.User;
import com.morrs.spi.output_ports.FindAllUsersSpi;

import java.util.List;

public class FindAllUsersUseCase implements FindAllUsersApi {

    private final FindAllUsersSpi findAllUsersSpi;

    public FindAllUsersUseCase(FindAllUsersSpi findAllUsersSpi) {
        this.findAllUsersSpi = findAllUsersSpi;
    }

    @Override
    public List<User> findAllUsers() {
        return findAllUsersSpi.findAllUsers();
    }
}
