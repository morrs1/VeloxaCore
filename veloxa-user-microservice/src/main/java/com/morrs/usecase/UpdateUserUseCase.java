package com.morrs.usecase;

import com.morrs.api.input_ports.UpdateUserInfoApi;
import com.morrs.domain.entities.User;
import com.morrs.spi.output_ports.UpdateUserInfoSpi;

public class UpdateUserUseCase implements UpdateUserInfoApi {

    private final UpdateUserInfoSpi updateUserInfoSpi;

    public UpdateUserUseCase(UpdateUserInfoSpi updateUserInfoSpi) {
        this.updateUserInfoSpi = updateUserInfoSpi;
    }

    @Override
    public User updateUserInfo(User user) {
        return updateUserInfoSpi.updateUser(user).orElse(null);
    }
}
