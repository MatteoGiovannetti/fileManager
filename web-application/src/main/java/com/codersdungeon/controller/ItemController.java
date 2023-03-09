package com.codersdungeon.controller;

import com.codersdungeon.abstraction.AppInterface;
import com.codersdungeon.dto.FileItemDTO;
import com.codersdungeon.dto.ListFileItemDTO;
import com.codersdungeon.service.impl.UtenteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/file-manager")
public class ItemController implements AppInterface {

    // per domani: sul core domani scrivere un service (interfaccia e implementazione).
    // nel service, uno o più metodi a scelta (elenco file, che prende in ingresso una cartella intesa come C:blabla percorso
    // restituisce una lista di oggetti. L'oggetto è FileItem, attributi a piacere.
    // il servizio deve essere richiamato dal controller. Stessa cosa va fatta nel cli-application, nel main, sempre richiamando il service
    // al controller aggiungere metodo con mapping ad un url che chiama il servizio.

    @Autowired
    UtenteServiceImpl utenteService;

   /* @GetMapping ("/items/{percorso}")
    public ListFileItemDTO findAll(@PathVariable("percorso") String percorso) {
        return utenteService.findAllFiles(percorso);
    }*/

    @Override
    @GetMapping(("/items/{percorso}"))
    public ListFileItemDTO findFilesInDirectory(@PathVariable("percorso") String percorso ) {
         return utenteService.findAllFiles(percorso);
    }

    @Override
    @GetMapping("items/sub/{percorso}")
    public ListFileItemDTO findFilesSubDir(@PathVariable("percorso") String percorso ) {
        return utenteService.findAllSubDir(percorso);
    }

    @Override
    @PostMapping("item/copy/{directory}/{filename}/{destination}")
    public FileItemDTO copyItem(@PathVariable("filename") String filename,
                                @PathVariable("directory") String directory,
                                @PathVariable("destination") String destination) {
        return utenteService.copyItem(filename, directory, destination);
    }

    @Override
    @DeleteMapping("item/delete/{directory}/{filename}")
    public void deleteItem(@PathVariable("directory") String directory,
                           @PathVariable("filename") String filename) {
        utenteService.deleteItem(directory, filename);
    }

    @Override
    @PostMapping("backup/{destination}")
    public ListFileItemDTO backup(@PathVariable("destination") String destination) {
        return utenteService.backup(destination);
    }
}
