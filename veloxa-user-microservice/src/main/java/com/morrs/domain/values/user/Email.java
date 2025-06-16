package com.morrs.domain.values.user;

import com.morrs.domain.values.BaseValueObject;

public class Email extends BaseValueObject<String> {
    public Email(String value) {
        super(value);
    }

    @Override
    public void validate() {

    }
}
