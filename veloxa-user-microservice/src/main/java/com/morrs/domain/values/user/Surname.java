package com.morrs.domain.values.user;

import com.morrs.domain.exceptions.ValidationException;
import com.morrs.domain.values.BaseValueObject;

public class Surname extends BaseValueObject<String> {
    public Surname(String value) {
        super(value);
    }

    @Override
    public void validate() {
        if (this.getValue() == null) {
            throw new ValidationException("Surname must be not null");
        }
    }
}
