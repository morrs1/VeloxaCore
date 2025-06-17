package com.morrs.spi.output_ports;

import com.morrs.domain.entities.User;

import java.util.List;

@FunctionalInterface
public interface FindAllUsersSpi {

    List<User> findAllUsers();

}
