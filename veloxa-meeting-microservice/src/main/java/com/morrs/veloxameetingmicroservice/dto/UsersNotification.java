package com.morrs.veloxameetingmicroservice.dto;

import com.morrs.veloxameetingmicroservice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class UsersNotification {
    private UUID id;
    private List<User> users;
}
