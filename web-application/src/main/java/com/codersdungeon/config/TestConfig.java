package com.codersdungeon.config;

import com.codersdungeon.controller.ItemController;
import com.codersdungeon.service.impl.ItemServiceImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ItemServiceImpl.class, ItemController.class})
public class TestConfig {

}
