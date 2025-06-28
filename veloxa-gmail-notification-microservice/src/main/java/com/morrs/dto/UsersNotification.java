package com.morrs.dto;

import com.morrs.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersNotification {
    private UUID id;
    private List<User> users;
    private String timeStart;
    private String timeEnd;
}
