package com.morrs.spi.adapters.postgres_jdbc;

import com.morrs.domain.entities.User;
import com.morrs.domain.values.user.*;
import com.morrs.spi.output_ports.FindAllUsersSpi;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class FindAllUsersJdbcTemplateAdapter implements FindAllUsersSpi {

    private final JdbcTemplate jdbcTemplate;

    public FindAllUsersJdbcTemplateAdapter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> findAllUsers() {
        return jdbcTemplate.query("SELECT * FROM users",
                (rs, rowNum) -> new User(
                        UUID.fromString(rs.getString("id")),
                        new Surname(rs.getString("surname")),
                        new Name(rs.getString("name")),
                        new Patronymic(rs.getString("patronymic")),
                        new UserStatus(rs.getString("user_status")),
                        new NotificationWay(NotificationWayEnum.valueOf(rs.getString("notification_way"))),
                        new Role(rs.getString("role")),
                        new Email(rs.getString("email")),
                        new Password(rs.getString("password")),
                        new TelegramId(rs.getInt("telegram_id")),
                        new ProfilePhotoLink(rs.getString("profile_photo_link"))
                )
        );
    }
}
