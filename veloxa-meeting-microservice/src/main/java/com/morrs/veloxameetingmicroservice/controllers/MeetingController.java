package com.morrs.veloxameetingmicroservice.controllers;

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
        return meetingService.save(meeting);
    }

    @PatchMapping("/{id}")
    public Meeting update(@RequestBody List<User> users, @PathVariable UUID id) {
        return meetingService.update(id, users);
    }

    @DeleteMapping("/{id}")
    public Meeting delete(@PathVariable UUID id) {
        return meetingService.delete(id);
    }
}
