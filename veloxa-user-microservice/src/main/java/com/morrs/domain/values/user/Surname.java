package com.morrs.domain.values.user;

import com.morrs.domain.values.BaseValueObject;

public class Surname extends BaseValueObject<String> {
    public Surname(String value) {
        super(value);
    }

    @Override
    public void validate() {
        //TODO
    }
}
