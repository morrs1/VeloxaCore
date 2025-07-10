package com.morrs.domain.values.user;

import com.morrs.domain.values.BaseValueObject;

public class Role extends BaseValueObject<String> {
    public Role(String value) {
        super(value);
    }

    @Override
    public void validate() {
        //TODO NotNull
    }
}
