package com.morrs.spi;

import com.morrs.domain.entities.User;

import java.util.Optional;
import java.util.UUID;

@FunctionalInterface
public interface FindUserByIdSpi {

    Optional<User> findUserById(UUID id);

}
