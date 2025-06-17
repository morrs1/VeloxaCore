package com.morrs.api.mappers;

import com.morrs.api.presentation.UserPresentation;
import com.morrs.api.presentation.UserCreateRequest;
import com.morrs.api.presentation.UserUpdateInfoRequest;
import com.morrs.domain.entities.User;
import com.morrs.domain.values.user.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class UserMapper {
    @Mapping(target = "surname", expression = "java(user.getSurname().getValue())")
    @Mapping(target = "name", expression = "java(user.getName().getValue())")
    @Mapping(target = "patronymic", expression = "java(user.getPatronymic().getValue())")
    @Mapping(target = "userStatus", expression = "java(user.getUserStatus().getValue())")
    @Mapping(target = "notificationWay", expression = "java(user.getNotificationWay().getValue().toString())")
    @Mapping(target = "role", expression = "java(user.getRole().getValue())")
    @Mapping(target = "email", expression = "java(user.getEmail().getValue())")
    @Mapping(target = "telegramId", expression = "java(user.getTelegramId().getValue())")
    @Mapping(target = "profilePhotoLink", expression = "java(user.getProfilePhotoLink().getValue())")
    public abstract UserPresentation toUserPresentation(User user);

    public User toUserFromUserRequest(UserCreateRequest userCreateRequest) {
        return new User(
                null,
                new Surname(userCreateRequest.surname()),
                new Name(userCreateRequest.name()),
                new Patronymic(userCreateRequest.patronymic()),
                new UserStatus(userCreateRequest.userStatus()),
                new NotificationWay(NotificationWayEnum.valueOf(userCreateRequest.notificationWay())),
                new Role(userCreateRequest.role()),
                new Email(userCreateRequest.email()),
                new Password(userCreateRequest.password()),
                new TelegramId(userCreateRequest.telegramId()),
                new ProfilePhotoLink(userCreateRequest.profilePhotoLink())
        );
    }

    public User toUserFromUserUpdateInfoRequest(UserUpdateInfoRequest userUpdateInfoRequest) {
        return new User(
                userUpdateInfoRequest.id(),
                new Surname(userUpdateInfoRequest.surname()),
                new Name(userUpdateInfoRequest.name()),
                new Patronymic(userUpdateInfoRequest.patronymic()),
                new UserStatus(userUpdateInfoRequest.userStatus()),
                new NotificationWay(NotificationWayEnum.valueOf(userUpdateInfoRequest.notificationWay())),
                new Role(userUpdateInfoRequest.role()),
                new Email(userUpdateInfoRequest.email()),
                null,
                new TelegramId(userUpdateInfoRequest.telegramId()),
                new ProfilePhotoLink(userUpdateInfoRequest.profilePhotoLink())
        );
    }
}
