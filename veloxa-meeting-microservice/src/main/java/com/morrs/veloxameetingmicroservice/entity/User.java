package com.morrs.veloxameetingmicroservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class User {
    private UUID id;
    private String surname;
    private String name;
    private String patronymic;
    private String email;
}
