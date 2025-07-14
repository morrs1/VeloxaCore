package com.morrs.veloxameetingmicroservice.domain.entity;

import com.morrs.veloxameetingmicroservice.domain.values.meeting.Description;
import com.morrs.veloxameetingmicroservice.domain.values.meeting.EndTime;
import com.morrs.veloxameetingmicroservice.domain.values.meeting.StartTime;
import com.morrs.veloxameetingmicroservice.domain.values.meeting.Title;

import java.util.List;
import java.util.UUID;


public class Meeting extends BaseEntity {

	private UUID organizerId;
	private Title title;
	private Description description;
	private StartTime startTime;
	private EndTime endTime;
	private List<User> participants;

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

	public UUID getOrganizerId() {
		return organizerId;
	}

	public void setOrganizerId(UUID organizerId) {
		this.organizerId = organizerId;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public Description getDescription() {
		return description;
	}

	public void setDescription(Description description) {
		this.description = description;
	}

	public StartTime getStartTime() {
		return startTime;
	}

	public void setStartTime(StartTime startTime) {
		this.startTime = startTime;
	}

	public EndTime getEndTime() {
		return endTime;
	}

	public void setEndTime(EndTime endTime) {
		this.endTime = endTime;
	}

	public List<User> getParticipants() {
		return participants;
	}

	public void setParticipants(List<User> participants) {
		this.participants = participants;
	}

	@Override
	public void validate() {

	}
}
