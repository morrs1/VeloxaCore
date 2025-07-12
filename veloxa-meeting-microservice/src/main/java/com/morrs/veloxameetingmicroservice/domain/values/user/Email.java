package com.morrs.veloxameetingmicroservice.domain.values.user;

import com.morrs.veloxameetingmicroservice.domain.exceptions.ValidationException;
import com.morrs.veloxameetingmicroservice.domain.values.BaseValueObject;

public class Email extends BaseValueObject<String> {
	public Email(String value) {
		super(value);
	}

	@Override
	protected void validate() {
		if (this.getValue() == null ||
				!this.getValue()
						.matches("^(?=.{1,64}@)[a-zA-Z0-9_-]+(?:\\.[a-zA-Z0-9_-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$")
		) {
			throw new ValidationException("Invalid email address %s".formatted(this.getValue()));
		}
	}
}
