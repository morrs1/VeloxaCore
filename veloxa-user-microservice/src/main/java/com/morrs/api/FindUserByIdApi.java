package com.morrs.api;

import com.morrs.domain.entities.User;

import java.util.UUID;

@FunctionalInterface
public interface FindUserByIdApi {

    User findUserById(UUID id);
}
