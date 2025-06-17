package com.morrs.spi.adapters.postgres_jdbc;

import com.morrs.spi.output_ports.DeleteUserByIdSpi;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
@Scope("request")
@Transactional
public class DeleteUserByIdJdbcTemplateAdapter implements DeleteUserByIdSpi {

    private final JdbcTemplate jdbcTemplate;

    public DeleteUserByIdJdbcTemplateAdapter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int deleteUserById(UUID id) {
        return jdbcTemplate.update("DELETE FROM users WHERE id = ?", id);
    }
}
