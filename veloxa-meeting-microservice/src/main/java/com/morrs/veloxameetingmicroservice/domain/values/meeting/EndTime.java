package com.morrs.veloxameetingmicroservice.domain.values.meeting;

import com.morrs.veloxameetingmicroservice.domain.values.BaseValueObject;

import java.time.LocalDateTime;

public class EndTime extends BaseValueObject<LocalDateTime> {
	public EndTime(LocalDateTime value) {
		super(value);
	}

	@Override
	protected void validate() {

	}
}
