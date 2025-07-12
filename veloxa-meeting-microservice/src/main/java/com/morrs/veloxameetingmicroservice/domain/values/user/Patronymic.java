package com.morrs.veloxameetingmicroservice.domain.values.user;

import com.morrs.veloxameetingmicroservice.domain.values.BaseValueObject;

public class Patronymic extends BaseValueObject<String> {
	public Patronymic(String value) {
		super(value);
	}

	@Override
	protected void validate() {
	}
}
