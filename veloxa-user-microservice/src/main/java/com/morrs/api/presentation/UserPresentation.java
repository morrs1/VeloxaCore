package com.morrs.api.presentation;

import java.util.UUID;

public record UserPresentation(
        UUID id,
        String surname,
        String name,
        String patronymic,
        String userStatus,
        String notificationWay,
        String role,
        Integer telegramId,
        String profilePhotoLink
) {
}
