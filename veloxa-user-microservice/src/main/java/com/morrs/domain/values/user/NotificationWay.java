package com.morrs.domain.values.user;

import com.morrs.domain.values.BaseValueObject;

public class NotificationWay extends BaseValueObject<NotificationWayEnum> {

    public NotificationWay(NotificationWayEnum value) {
        super(value);
    }

    @Override
    public void validate() {
        //TODO
    }
}
