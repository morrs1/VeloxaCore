package com.morrs.domain.values.user;

import com.morrs.domain.exceptions.ValidationException;
import com.morrs.domain.values.BaseValueObject;

public class Name extends BaseValueObject<String> {
    public Name(String value) {
        super(value);
    }

    @Override
    public void validate() {
        if (this.getValue() == null) {
            throw new ValidationException("Name must be not null");
        }
    }
}
