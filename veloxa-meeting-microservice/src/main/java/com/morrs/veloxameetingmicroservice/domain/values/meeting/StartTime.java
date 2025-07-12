package com.morrs.veloxameetingmicroservice.domain.values.meeting;

import com.morrs.veloxameetingmicroservice.domain.values.BaseValueObject;

import java.time.LocalDateTime;

public class StartTime extends BaseValueObject<LocalDateTime> {
	public StartTime(LocalDateTime value) {
		super(value);
	}

	@Override
	protected void validate() {

	}
}
