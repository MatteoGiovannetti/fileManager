package com.codersdungeon.controller;

import com.codersdungeon.dto.ListFileItemDTO;
import com.codersdungeon.service.interf.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/file-manager")
public class itemController {

    // per domani: sul core domani scrivere un service (interfaccia e implementazione).
    // nel service, uno o più metodi a scelta (elenco file, che prende in ingresso una cartella intesa come C:blabla percorso
    // restituisce una lista di oggetti. L'oggetto è FileItem, attributi a piacere.
    // il servizio deve essere richiamato dal controller. Stessa cosa va fatta nel cli-application, nel main, sempre richiamando il service
    // al controller aggiungere metodo con mapping ad un url che chiama il servizio.

    @Autowired
    UtenteService utenteService;

    @GetMapping ("/items/{percorso}")
    public ListFileItemDTO findAll(@PathVariable("percorso") String percorso) {
        return utenteService.findAllFiles(percorso);
    }

}
