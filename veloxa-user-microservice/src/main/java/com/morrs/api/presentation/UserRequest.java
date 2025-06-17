package com.morrs.api.presentation;

import java.util.UUID;

public record UserRequest(
        UUID id,
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
