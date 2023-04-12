package com.tpe.service;

import com.tpe.domain.Message;
import com.tpe.repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component // bu classdan springin obje uretmesini istiyoruz.
@Scope("prototype")
public class MailService implements  MessageService{

    @PostConstruct // classin constructori cagirildiktan hemen sonra bu methodu(init) cagir.
    public void init(){
        System.out.println("MailService objesi oluşturuluyor.");
    }

    @PreDestroy // classin objecti destroy edilmeden hemen once bu methodu(destroy) cagir.
    public void destroy(){
        System.out.println("MailService objesi sonlandırıldı.");
    }

    // field injection
//    @Autowired // reponun objesini classa enjekte eder.
//    @Qualifier("fileRepository")
//    private Repo repo;

    //setter injection
//    private Repo repo;
//    @Autowired
//    @Qualifier("fileRepository")
//    public void setRepo(Repo repo) {
//        this.repo = repo;
//    }

    //constructor injection: daha guvenli, daha anlasilir, test etmek daha kolay.
    private Repo repo;

    @Autowired
    public MailService(@Qualifier("fileRepository")Repo repo) {
        this.repo = repo;
    }

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
