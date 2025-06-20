package com.morrs.api.presentation;

public record UserCreateRequest(
        String surname,
        String name,
        String patronymic,
        String userStatus,
        String notificationWay,
        String role,
        String email,
        String password,
        Integer telegramId,
        String profilePhotoLink
) {
}
