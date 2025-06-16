package com.morrs.domain.values.user;

import com.morrs.domain.values.BaseValueObject;

public class Patronymic extends BaseValueObject<String> {
    public Patronymic(String value) {
        super(value);
    }

    @Override
    public void validate() {
        //TODO
    }
}
