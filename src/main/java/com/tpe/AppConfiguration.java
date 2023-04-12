package com.tpe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.Properties;
import java.util.Random;

@Configuration // bu classda config olacak
@ComponentScan("com.tpe")// bu packagedaki componentlari tara
@PropertySource("classpath:application.properties")
public class AppConfiguration {

    @Autowired
    private Environment environment; //application.properties dosyasinin icindeki degiskenler ve
                                     //  uygulamanin calistigi tum ortam degiskenlerine ulasmak icin
                                     // Springin Environment interface i kullanilir.

    @Bean // random classindan bir tane bean olusturuluyor.
    public Random random(){
        return new Random();
    }

    //value ann ile yaptigimizi properties classi ile de yapabiliriz.
    //degiskenlerin degerlerini bir dosyadan okuyabiliriz.

    @Bean
    public Properties properties(){
        Properties properties = new Properties();
        properties.put("mymail",environment.getProperty("app.email"));
        properties.put("myjavahome",environment.getProperty("JAVA_HOME"));
        //[{email,email@email.com}]
        return properties;
    }


}
