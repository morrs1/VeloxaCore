package com.morrs.veloxameetingmicroservice.domain.values.user;

import com.morrs.veloxameetingmicroservice.domain.values.BaseValueObject;

public class Name extends BaseValueObject<String> {
	public Name(String value) {
		super(value);
	}

	@Override
	protected void validate() {
	}
}
