package com.morrs.domain.values.user;

import com.morrs.domain.values.BaseValueObject;

public class Name extends BaseValueObject<String> {
    public Name(String value) {
        super(value);
    }

    @Override
    public void validate() {
        //TODO
    }
}
