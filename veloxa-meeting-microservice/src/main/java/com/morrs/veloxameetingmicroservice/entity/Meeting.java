package com.morrs.veloxameetingmicroservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Meeting {

    UUID id;
    UUID organizerId;
    String title;
    String description;
    String startTime; //TODO поменять на LocalDateTime
    String endTime; //TODO поменять на LocalDateTime
    List<User> participants;

}
