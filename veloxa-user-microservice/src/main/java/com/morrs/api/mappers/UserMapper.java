package com.morrs.api.mappers;

import com.morrs.api.presentation.UserPresentation;
import com.morrs.api.presentation.UserRequest;
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

    public User toUserFromUserRequest(UserRequest userRequest) {
        return new User(
                null,
                new Surname(userRequest.surname()),
                new Name(userRequest.name()),
                new Patronymic(userRequest.patronymic()),
                new UserStatus(userRequest.userStatus()),
                new NotificationWay(NotificationWayEnum.valueOf(userRequest.notificationWay())),
                new Role(userRequest.role()),
                new Email(userRequest.email()),
                new Password(userRequest.password()),
                new TelegramId(userRequest.telegramId()),
                new ProfilePhotoLink(userRequest.profilePhotoLink())
        );
    }
}
