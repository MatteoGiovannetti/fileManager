package com.codersdungeon.config;

import com.codersdungeon.controller.ItemController;
import com.codersdungeon.service.impl.ItemServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    /*
    Aggiungendo manualmente si rimette a posto ma da sempre nullpointer
    */

    @Bean
    public ItemServiceImpl utenteService(){
        return new ItemServiceImpl();
    }

    @Bean
    public ItemController itemController(){
        return new ItemController();
    }
}
