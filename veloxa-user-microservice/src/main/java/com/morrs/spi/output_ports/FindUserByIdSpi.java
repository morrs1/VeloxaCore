package com.morrs.spi.output_ports;

import com.morrs.domain.entities.User;

import java.util.Optional;
import java.util.UUID;

@FunctionalInterface
public interface FindUserByIdSpi {

    Optional<User> findUserById(UUID id);

}
