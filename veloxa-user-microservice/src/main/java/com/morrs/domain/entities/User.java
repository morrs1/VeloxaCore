package com.morrs.domain.entities;

import com.morrs.domain.values.user.*;

import java.util.UUID;

public class User extends BaseEntity {

    private Surname surname;
    private Name name;
    private Patronymic patronymic;
    private UserStatus userStatus;
    private NotificationWay notificationWay;
    private Role role;
    private Email email;
    private Password password;
    private TelegramId telegramId;
    private ProfilePhotoLink profilePhotoLink;


    public User(
            UUID id,
            Surname surname,
            Name name,
            Patronymic patronymic,
            UserStatus userStatus,
            NotificationWay notificationWay,
            Role role,
            Email email,
            Password password,
            TelegramId telegramId,
            ProfilePhotoLink profilePhotoLink
    ) {
        super(id);
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.userStatus = userStatus;
        this.notificationWay = notificationWay;
        this.role = role;
        this.email = email;
        this.password = password;
        this.telegramId = telegramId;
        this.profilePhotoLink = profilePhotoLink;
    }

    public Surname getSurname() {
        return surname;
    }

    public Name getName() {
        return name;
    }

    public Patronymic getPatronymic() {
        return patronymic;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public NotificationWay getNotificationWay() {
        return notificationWay;
    }

    public Role getRole() {
        return role;
    }

    public Email getEmail() {
        return email;
    }

    public Password getPassword() {
        return password;
    }

    public TelegramId getTelegramId() {
        return telegramId;
    }

    public ProfilePhotoLink getProfilePhotoLink() {
        return profilePhotoLink;
    }

    public void setSurname(Surname surname) {
        this.surname = surname;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public void setPatronymic(Patronymic patronymic) {
        this.patronymic = patronymic;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public void setNotificationWay(NotificationWay notificationWay) {
        this.notificationWay = notificationWay;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    public void setTelegramId(TelegramId telegramId) {
        this.telegramId = telegramId;
    }

    public void setProfilePhotoLink(ProfilePhotoLink profilePhotoLink) {
        this.profilePhotoLink = profilePhotoLink;
    }
}
