package com.morrs.veloxameetingmicroservice.domain.values.meeting;

import com.morrs.veloxameetingmicroservice.domain.values.BaseValueObject;

public class Title extends BaseValueObject<String> {
	public Title(String value) {
		super(value);
	}

	@Override
	protected void validate() {
	}
}
