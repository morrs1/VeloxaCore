package com.morrs.veloxameetingmicroservice.domain.values.user;

import com.morrs.veloxameetingmicroservice.domain.values.BaseValueObject;

public class Surname extends BaseValueObject<String> {
	public Surname(String value) {
		super(value);
	}

	@Override
	protected void validate() {
	}
}
