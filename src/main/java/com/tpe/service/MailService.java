package com.tpe.service;

import com.tpe.domain.Message;
import com.tpe.repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component // bu classdan springin obje uretmesini istiyoruz.
public class MailService implements  MessageService{

    @Autowired // reponun objesini classa enjekte eder.
    @Qualifier("fileRepository")
    private Repo repo;

    @Override
    public void sendMessage(Message message) {
        System.out.println("Ben bir mail servisiyim. Mesajınız:"+message.getMessage());
    }

    @Override
    public void saveMessage(Message message) {
        //reponun methodu icin objesine ihtiyacimiz var
        repo.save(message);
    }

}
