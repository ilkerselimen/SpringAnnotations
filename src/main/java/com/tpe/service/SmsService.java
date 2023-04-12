package com.tpe.service;

import com.tpe.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Random;

@Component("smsservice")
public class SmsService implements MessageService{

    @PostConstruct // classin constructori cagirildiktan hemen sonra bu methodu(init) cagir.
    public void init(){
        System.out.println("SmsService objesi oluşturuluyor.");
    }

    @PreDestroy // classin objecti destroy edilmeden hemen once bu methodu(destroy) cagir.
    public void destroy(){
        System.out.println("SmsService objesi sonlandırıldı.");
    }

    @Autowired
    private Random random;

    @Override
    public void sendMessage(Message message) {
        System.out.println("Ben bir SMS servisiyim. Mesajınız:"+message.getMessage());
        System.out.println("random sayı : "+random.nextInt(100));
    }

    @Override
    public void saveMessage(Message message) {

    }
}
