package com.morrs.veloxameetingmicroservice.brokerUtils;

import com.morrs.veloxameetingmicroservice.dto.UsersNotification;

public interface DataSender {

    void send(UsersNotification usersNotification);

}
