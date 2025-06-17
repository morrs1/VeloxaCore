package com.morrs.spi.adapters.postgres_jdbc;

import com.morrs.domain.entities.User;
import com.morrs.domain.values.user.*;
import com.morrs.spi.output_ports.FindUserByIdSpi;
import com.morrs.spi.exceptions.UserNotFoundException;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Component()
@Scope("request")
@Transactional(readOnly = true)
public class FindUserByIdJdbcTemplateAdapter implements FindUserByIdSpi {

    private final JdbcTemplate jdbcTemplate;

    public FindUserByIdJdbcTemplateAdapter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<User> findUserById(UUID id) {
        User user;
        try {
            user = jdbcTemplate.queryForObject(
                    "SELECT * FROM users WHERE id = ?",
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
                    ),
                    id
            );
        } catch (EmptyResultDataAccessException e) {
            throw new UserNotFoundException("Could not find user by id: " + id);
        }
        return Optional.ofNullable(user);
    }

}
