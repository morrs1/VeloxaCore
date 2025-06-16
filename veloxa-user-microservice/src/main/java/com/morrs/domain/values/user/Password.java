package com.morrs.domain.values.user;

import com.morrs.domain.values.BaseValueObject;

public class Password extends BaseValueObject<String> {
    public Password(String value) {
        super(value);
    }

    @Override
    public void validate() {
    }
}
