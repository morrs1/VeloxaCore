package com.morrs.veloxameetingmicroservice.api.presentation;

import com.morrs.veloxameetingmicroservice.domain.entity.User;

import java.util.List;
import java.util.UUID;

public record UsersNotification(UUID id, List<User> users, String timeStart, String timeEnd) {

}
