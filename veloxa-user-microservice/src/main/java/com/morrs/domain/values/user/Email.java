package com.morrs.domain.values.user;

import com.morrs.domain.exceptions.ValidationException;
import com.morrs.domain.values.BaseValueObject;

public class Email extends BaseValueObject<String> {
    public Email(String value) {
        super(value);
    }

    @Override
    public void validate() {
        if (!this.getValue()
                .matches("^(?=.{1,64}@)[a-zA-Z0-9_-]+(?:\\.[a-zA-Z0-9_-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$")
        ) {
            throw new ValidationException("Invalid email address %s".formatted(this.getValue()));
        }
    }
}
