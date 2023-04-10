package com.tpe.service;

import com.tpe.domain.Message;
import org.springframework.stereotype.Component;

@Component("smsservice")
public class SmsService implements MessageService{
    @Override
    public void sendMessage(Message message) {
        System.out.println("Ben bir SMS servisiyim. Mesajınız:"+message.getMessage());
    }

    @Override
    public void saveMessage(Message message) {

    }
}
