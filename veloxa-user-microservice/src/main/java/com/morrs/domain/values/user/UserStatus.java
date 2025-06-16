package com.morrs.domain.values.user;

import com.morrs.domain.values.BaseValueObject;

public class UserStatus extends BaseValueObject<String> {
    public UserStatus(String value) {
        super(value);
    }

    @Override
    public void validate() {

    }
}
