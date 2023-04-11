package com.tpe;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration // bu classda config olacak
@ComponentScan("com.tpe")// bu packagedaki componentlari tara
public class AppConfiguration {

    @Bean // random classindan bir tane bean olusturuluyor.
    public Random random(){
        return new Random();
    }


}
