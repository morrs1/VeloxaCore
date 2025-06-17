package com.morrs.api.presentation;

import java.util.UUID;

public record UserUpdateInfoRequest(
        UUID id,
        String surname,
        String name,
        String patronymic,
        String userStatus,
        String notificationWay,
        String role,
        String email,
        Integer telegramId,
        String profilePhotoLink
) {
}