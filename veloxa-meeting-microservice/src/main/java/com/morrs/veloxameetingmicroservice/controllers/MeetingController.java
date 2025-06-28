package com.morrs.veloxameetingmicroservice.controllers;

import com.morrs.veloxameetingmicroservice.brokerUtils.DataSender;
import com.morrs.veloxameetingmicroservice.dto.UsersNotification;
import com.morrs.veloxameetingmicroservice.entity.Meeting;
import com.morrs.veloxameetingmicroservice.entity.User;
import com.morrs.veloxameetingmicroservice.services.MeetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/meeting")
@RequiredArgsConstructor
public class MeetingController {

    private final MeetingService meetingService;
    private final DataSender dataSender;

    @GetMapping()
    public List<Meeting> findAll() {
        return meetingService.findAll();
    }

    @GetMapping("/{id}")
    public Meeting findById(@PathVariable UUID id) {
        return meetingService.findById(id);
    }

    @PostMapping()
    public Meeting save(@RequestBody Meeting meeting) {
        dataSender.send(new UsersNotification(
                UUID.randomUUID(),
                meeting.getParticipants(),
                meeting.getStartTime(),
                meeting.getEndTime()
        ));
        return meetingService.save(meeting);
    }

    @PatchMapping("/{id}")
    public Meeting update(@RequestBody List<User> users, @PathVariable UUID id) {
        var meeting = meetingService.findById(id);
        dataSender.send(new UsersNotification(
                UUID.randomUUID(),
                users,
                meeting.getStartTime(),
                meeting.getEndTime()
        ));
        return meetingService.update(id, users);
    }

    @DeleteMapping("/{id}")
    public Meeting delete(@PathVariable UUID id) {
        return meetingService.delete(id);
    }
}
