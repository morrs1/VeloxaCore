package com.morrs.veloxameetingmicroservice.brokerUtils;

import com.morrs.veloxameetingmicroservice.api.presentation.UsersNotification;

public interface DataSender {

    void send(UsersNotification usersNotification);

}
