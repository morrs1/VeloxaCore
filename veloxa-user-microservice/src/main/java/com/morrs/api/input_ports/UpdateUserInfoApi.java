package com.morrs.api.input_ports;

import com.morrs.domain.entities.User;

@FunctionalInterface
public interface UpdateUserInfoApi {
    User updateUserInfo(User user);
}
