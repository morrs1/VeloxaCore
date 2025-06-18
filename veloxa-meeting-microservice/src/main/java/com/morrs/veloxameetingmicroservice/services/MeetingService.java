package com.morrs.veloxameetingmicroservice.services;

import com.morrs.veloxameetingmicroservice.entity.Meeting;
import com.morrs.veloxameetingmicroservice.entity.User;
import com.morrs.veloxameetingmicroservice.exceptions.MeetingNotFoundException;
import com.morrs.veloxameetingmicroservice.repository.MeetingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional()
public class MeetingService {

    private final MeetingRepository meetingRepository;

    @Transactional(readOnly = true)
    public List<Meeting> findAll() {
        return meetingRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Meeting findById(UUID id) {
        return meetingRepository.findById(id).orElseThrow(() -> new MeetingNotFoundException("Meeting not found"));
    }

    public Meeting save(Meeting meeting) {
        meeting.setId(UUID.randomUUID());
        return meetingRepository.save(meeting);
    }

    public Meeting update(UUID meetingId, List<User> users) {
        meetingRepository.addUsersToMeeting(meetingId, users);
        return meetingRepository.findById(meetingId).orElseThrow(() -> new MeetingNotFoundException("Meeting not found"));
    }

    public Meeting delete(UUID meetingId) {
        var meeting = meetingRepository.findById(meetingId).orElseThrow(() -> new MeetingNotFoundException("Meeting not found"));
        meetingRepository.deleteMeeting(meetingId);
        return meeting;
    }

}
