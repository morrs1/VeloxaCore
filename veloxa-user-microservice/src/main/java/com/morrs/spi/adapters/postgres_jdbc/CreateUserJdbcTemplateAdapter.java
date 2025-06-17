package com.morrs.spi.adapters.postgres_jdbc;

import com.morrs.domain.entities.User;
import com.morrs.spi.output_ports.CreateUserSpi;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class CreateUserJdbcTemplateAdapter implements CreateUserSpi {

    private final JdbcTemplate jdbcTemplate;

    public CreateUserJdbcTemplateAdapter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User createUser(User user) {
        jdbcTemplate.update(
                "INSERT INTO users (" +
                        "id," +
                        " surname," +
                        " name," +
                        " patronymic," +
                        " user_status," +
                        " notification_way," +
                        " role," +
                        " email," +
                        " password," +
                        " telegram_id," +
                        " profile_photo_link" +
                        ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                user.getId(),
                user.getSurname().getValue(),
                user.getName().getValue(),
                user.getPatronymic().getValue(),
                user.getUserStatus().getValue(),
                user.getNotificationWay().getValue().toString(),
                user.getRole().getValue(),
                user.getEmail().getValue(),
                user.getPassword().getValue(),
                user.getTelegramId().getValue(),
                user.getProfilePhotoLink().getValue()
        );
        return user;
    }
}
