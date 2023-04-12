package com.tpe.app;

import com.tpe.AppConfiguration;
import com.tpe.domain.Message;
import com.tpe.repository.FileRepository;
import com.tpe.service.MailService;
import com.tpe.service.MessageService;
import com.tpe.service.SmsService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;

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
//        MessageService service = context.getBean("smsservice",MessageService.class);
//        service.sendMessage(message);

        // interface i implemente eden birden fazla component ile isaretlenmis class varsa
        // hangisini almasi gerektigini belirtmemiz gerekir.

//        MessageService service = context.getBean(MailService.class);
//        service.sendMessage(message);
//        service.saveMessage(message); // dbrepoyu da newlemedik.
        // enjekte edilecek obje secenegi birden fazla ise qualifier ile belirtilmeli

//        Random random = new Random(); --> Spring bizim icin olustursun.
//        Random random = context.getBean(Random.class);
//        System.out.println(random.nextInt(100));

        MessageService service = context.getBean(MailService.class);
        MessageService service2 = context.getBean(MailService.class);

        // Spring de beanlerin scope u defaultta Singleton dir.
        // Singleton: tum uygulama icin sadece tek bir bean olusturulur, beanin tum life cycle indan Spring sorumludur.
        // Prototype: her obje istendiginde yeni bir bean olusturulur, beanin destroy edilmesinden Spring sorumlu DEGILDIR.

        if (service==service2){
            System.out.println("Ayni reference li objectler");
            System.out.println(service);
            System.out.println(service2);
        }else{
            System.out.println("Farkli reference li objectler");
            System.out.println(service);
            System.out.println(service2);
        }

        SmsService service3 = context.getBean(SmsService.class);
        service3.sendMessage(message);
        service3.printContact(); // value ile uyg disindan degerleri aldik
        service3.printProperties();

//        String[] beanNames=context.getBeanDefinitionNames();
//        for (String name:beanNames){
//            System.out.println(name);
//        }


        context.close(); // contextden obje isteyemeyiz, beanler sonlandirilir, getBean ile bean talep edemeyiz.

        System.out.println("context in close methodundan sonra");


    }

}
