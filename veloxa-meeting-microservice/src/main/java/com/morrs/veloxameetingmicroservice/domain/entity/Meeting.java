package com.morrs.veloxameetingmicroservice.domain.entity;

import com.morrs.veloxameetingmicroservice.domain.values.meeting.Description;
import com.morrs.veloxameetingmicroservice.domain.values.meeting.EndTime;
import com.morrs.veloxameetingmicroservice.domain.values.meeting.StartTime;
import com.morrs.veloxameetingmicroservice.domain.values.meeting.Title;

import java.util.List;
import java.util.UUID;


public class Meeting extends BaseEntity {

	UUID organizerId;
	Title title;
	Description description;
	StartTime startTime;
	EndTime endTime;
	List<User> participants;

	public Meeting(
			UUID id,
			UUID organizerId,
			Title title,
			Description description,
			StartTime startTime,
			EndTime endTime,
			List<User> participants
	) {
		super(id);
		this.organizerId = organizerId;
		this.title = title;
		this.description = description;
		this.startTime = startTime;
		this.endTime = endTime;
		this.participants = participants;
	}


}
