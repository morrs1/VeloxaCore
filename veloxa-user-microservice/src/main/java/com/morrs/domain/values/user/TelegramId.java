package com.morrs.domain.values.user;

import com.morrs.domain.values.BaseValueObject;

public class TelegramId extends BaseValueObject<Integer> {
    public TelegramId(Integer value) {
        super(value);
    }

    @Override
    public void validate() {

    }
}
