package com.tpe.service;

import com.tpe.domain.Message;
import org.springframework.stereotype.Component;

@Component // bu classdan springin obje uretmesini istiyoruz.
public class MailService implements  MessageService{

    @Override
    public void sendMessage(Message message) {
        System.out.println("Ben bir mail servisiyim. Mesajınız:"+message.getMessage());
    }

    @Override
    public void saveMessage(Message message) {

    }

}
