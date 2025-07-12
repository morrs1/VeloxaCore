package com.morrs.veloxameetingmicroservice.domain.values.meeting;

import com.morrs.veloxameetingmicroservice.domain.values.BaseValueObject;

public class Description extends BaseValueObject<String> {
	public Description(String value) {
		super(value);
	}

	@Override
	protected void validate() {

	}
}
