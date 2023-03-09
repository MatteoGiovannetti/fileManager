package com.codersdungeon.config;

import com.codersdungeon.controller.ItemController;
import com.codersdungeon.service.impl.UtenteServiceImpl;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({UtenteServiceImpl.class, ItemController.class})
public class TestConfig {

}
