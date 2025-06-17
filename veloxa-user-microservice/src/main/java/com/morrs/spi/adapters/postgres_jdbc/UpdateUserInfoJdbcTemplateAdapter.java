package com.morrs.spi.adapters.postgres_jdbc;

import com.morrs.domain.entities.User;
import com.morrs.spi.exceptions.UserNotFoundException;
import com.morrs.spi.output_ports.UpdateUserInfoSpi;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@Scope("request")
@Transactional
public class UpdateUserInfoJdbcTemplateAdapter implements UpdateUserInfoSpi {

    private final JdbcTemplate jdbcTemplate;

    public UpdateUserInfoJdbcTemplateAdapter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<User> updateUser(User user) {
        try {
            jdbcTemplate.update("UPDATE users SET " +
                            "surname = ?," +
                            " name = ?," +
                            " patronymic = ?," +
                            " user_status = ?," +
                            " notification_way = ?," +
                            " role = ?," +
                            " email = ?," +
                            " telegram_id = ?," +
                            " profile_photo_link = ? WHERE id = ?",
                    user.getSurname().getValue(),
                    user.getName().getValue(),
                    user.getPatronymic().getValue(),
                    user.getUserStatus().getValue(),
                    user.getNotificationWay().getValue().toString(),
                    user.getRole().getValue(),
                    user.getEmail().getValue(),
                    user.getTelegramId().getValue(),
                    user.getProfilePhotoLink().getValue(),
                    user.getId());
        } catch (DataAccessException e) {
            throw new UserNotFoundException("Could not find user by id: " + user.getId());
        }
        return Optional.of(user);
    }
}
