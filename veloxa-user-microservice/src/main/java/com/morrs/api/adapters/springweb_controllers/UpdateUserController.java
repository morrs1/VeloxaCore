package com.morrs.api.adapters.springweb_controllers;

import com.morrs.api.input_ports.UpdateUserInfoApi;
import com.morrs.api.mappers.UserMapper;
import com.morrs.api.presentation.UserPresentation;
import com.morrs.api.presentation.UserUpdateInfoRequest;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateUserController {

    private final UserMapper userMapper;
    private final UpdateUserInfoApi updateUserInfoApi;

    public UpdateUserController(UserMapper userMapper, UpdateUserInfoApi updateUserInfoApi) {
        this.userMapper = userMapper;
        this.updateUserInfoApi = updateUserInfoApi;
    }

    @PatchMapping("api/user")
    public UserPresentation updateUser(@RequestBody UserUpdateInfoRequest userUpdateInfoRequest) {
        return userMapper.toUserPresentation(
                updateUserInfoApi.updateUserInfo(
                        userMapper.toUserFromUserUpdateInfoRequest(userUpdateInfoRequest)
                )
        );
    }
}
