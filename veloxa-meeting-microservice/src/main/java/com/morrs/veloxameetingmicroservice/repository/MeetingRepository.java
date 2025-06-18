package com.morrs.veloxameetingmicroservice.repository;

import com.morrs.veloxameetingmicroservice.entity.Meeting;
import com.morrs.veloxameetingmicroservice.entity.User;
import com.morrs.veloxameetingmicroservice.exceptions.DuplicateKeyException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Component
@RequiredArgsConstructor
public class MeetingRepository {

    private final JdbcTemplate jdbcTemplate;


    public List<Meeting> findAll() {
        String sql = "SELECT " +
                "    m.id AS meeting_id, " +
                "    m.organizer_id, " +
                "    m.title, " +
                "    m.description, " +
                "    TO_CHAR(m.start_time, 'YYYY-MM-DD\"T\"HH24:MI:SS.MS\"Z\"') AS start_time, " +
                "    TO_CHAR(m.end_time, 'YYYY-MM-DD\"T\"HH24:MI:SS.MS\"Z\"') AS end_time, " +
                "    u.id AS user_id, " +
                "    u.surname, " +
                "    u.name, " +
                "    u.patronymic, " +
                "    u.email " +
                "FROM meetings m " +
                "LEFT JOIN meetings_users mu ON m.id = mu.meetings_id " +
                "LEFT JOIN users u ON mu.users_id = u.id " +
                "ORDER BY m.start_time DESC";

        return jdbcTemplate.query(sql, rs -> {
            Map<UUID, Meeting> meetingMap = new LinkedHashMap<>();

            while (rs.next()) {
                UUID meetingId = rs.getObject("meeting_id", UUID.class);

                Meeting meeting = meetingMap.computeIfAbsent(meetingId, id -> {
                    try {
                        return new Meeting(
                                id,
                                rs.getObject("organizer_id", UUID.class),
                                rs.getString("title"),
                                rs.getString("description"),
                                rs.getString("start_time"),
                                rs.getString("end_time"),
                                new ArrayList<>()
                        );
                    } catch (SQLException e) {
                        throw new RuntimeException("Error processing meeting data", e);
                    }
                });


                if (rs.getObject("user_id") != null) {
                    try {
                        User participant = new User(
                                rs.getObject("user_id", UUID.class),
                                rs.getString("surname"),
                                rs.getString("name"),
                                rs.getString("patronymic"),
                                rs.getString("email")
                        );
                        meeting.getParticipants().add(participant);
                    } catch (SQLException e) {
                        throw new RuntimeException("Error processing participant data", e);
                    }
                }
            }

            return new ArrayList<>(meetingMap.values());
        });
    }


    public Optional<Meeting> findById(UUID meetingId) {
        String sql = """
                    SELECT 
                        m.id AS meeting_id,
                        m.organizer_id,
                        m.title,
                        m.description,
                        TO_CHAR(m.start_time, 'YYYY-MM-DD"T"HH24:MI:SS.MS"Z"') AS start_time,
                        TO_CHAR(m.end_time, 'YYYY-MM-DD"T"HH24:MI:SS.MS"Z"') AS end_time,
                        u.id AS user_id,
                        u.surname,
                        u.name,
                        u.patronymic,
                        u.email
                    FROM meetings m
                    LEFT JOIN meetings_users mu ON m.id = mu.meetings_id
                    LEFT JOIN users u ON mu.users_id = u.id
                    WHERE m.id = ?
                    ORDER BY u.surname, u.name
                """;

        try {
            Meeting meeting = jdbcTemplate.query(sql, rs -> {
                Meeting result = null;
                List<User> participants = new ArrayList<>();

                while (rs.next()) {
                    if (result == null) {
                        result = new Meeting(
                                meetingId,
                                rs.getObject("organizer_id", UUID.class),
                                rs.getString("title"),
                                rs.getString("description"),
                                rs.getString("start_time"),
                                rs.getString("end_time"),
                                participants
                        );
                    }

                    if (rs.getObject("user_id") != null) {
                        participants.add(new User(
                                rs.getObject("user_id", UUID.class),
                                rs.getString("surname"),
                                rs.getString("name"),
                                rs.getString("patronymic"),
                                rs.getString("email")
                        ));
                    }
                }
                return result;
            }, meetingId);

            return Optional.ofNullable(meeting);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }


    public Meeting save(Meeting meeting) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

        LocalDateTime startTime = meeting.getStartTime() != null
                ? LocalDateTime.parse(meeting.getStartTime(), formatter)
                : null;

        LocalDateTime endTime = meeting.getEndTime() != null
                ? LocalDateTime.parse(meeting.getEndTime(), formatter)
                : null;

        jdbcTemplate.update(
                "INSERT INTO meetings (id, organizer_id, title, description, start_time, end_time) VALUES (?, ?, ?, ?, ?, ?)",
                meeting.getId(),
                meeting.getOrganizerId(),
                meeting.getTitle(),
                meeting.getDescription(),
                startTime,
                endTime
        );

        if (meeting.getParticipants() != null) {
            meeting.getParticipants().forEach(participant ->
                    jdbcTemplate.update(
                            "INSERT INTO meetings_users (meetings_id, users_id) VALUES (?, ?)",
                            meeting.getId(),
                            participant.getId()
                    )
            );
        }

        return meeting;
    }

    public void addUsersToMeeting(UUID meetingId, List<User> users) {
        try {
            users.forEach(user -> jdbcTemplate.update("INSERT INTO meetings_users (meetings_id, users_id) VALUES (?, ?)",
                    meetingId, user.getId()));
        } catch (org.springframework.dao.DuplicateKeyException e) {
            throw new DuplicateKeyException("Duplicate key exception");
        }
    }

    public void deleteMeeting(UUID meetingId) {
        jdbcTemplate.update("DELETE FROM meetings WHERE id = ?", meetingId);
    }
}
