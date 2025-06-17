package com.morrs.spi.output_ports;

import java.util.UUID;

@FunctionalInterface
public interface DeleteUserByIdSpi {

    int deleteUserById(UUID id);

}
