package com.codersdungeon.config;

import com.codersdungeon.controller.ItemController;
import com.codersdungeon.service.impl.UtenteServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    /*
    Aggiungendo manualmente si rimette a posto ma da sempre nullpointer
    */

    @Bean
    public UtenteServiceImpl utenteService(){
        return new UtenteServiceImpl();
    }

    @Bean
    public ItemController itemController(){
        return new ItemController();
    }
}
