package com.tpe.app;

import com.tpe.AppConfiguration;
import com.tpe.domain.Message;
import com.tpe.service.MailService;
import com.tpe.service.MessageService;
import com.tpe.service.SmsService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApplication {

    public static void main(String[] args) {

        Message message = new Message();
        message.setMessage("Spring ile uygulama gelistirmek HARIKA!");

        //config classini oku
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        //config classindaki component scan ile tum componentlari tarayacak.
        //her component dan bir tane bean olusturup, contexte hazirda bekletecek.

//        MailService service = context.getBean(MailService.class);
//        MessageService service = context.getBean(MessageService.class); // rte vermedi spring handle etti
//        service.sendMessage(message); // newleme yapmadik
//                                      // spring container dan rica ettik, bize hazir getirdi.

//        MessageService service = context.getBean(SmsService.class);
        MessageService service = context.getBean("smsservice",MessageService.class);
        service.sendMessage(message);

        // interface i implemente eden birden fazla component ile isaretlenmis class varsa
        // hangisini almasi gerektigini belirtmemiz gerekir.

        context.close(); // contextden obje isteyemeyiz.


    }

}
