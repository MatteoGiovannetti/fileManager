package com.codersdungeon;

import com.codersdungeon.service.impl.UtenteServiceImpl;
import com.codersdungeon.temp.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class Application {



    @Autowired
    UtenteServiceImpl utenteService;

    public void findFilesInDirectory(String percorso){
        System.out.println("Questi sono i file nella cartella " + percorso);
        System.out.println(utenteService.findAllFiles(percorso));
    }

    public void findFilesSubDir(String percorso) {
        System.out.println("Questi sono i file nella cartella " + percorso + " e relative sottocartelle");
        System.out.println(utenteService.findAllFiles(percorso));
    }

    public void copyItem(String filename, String directory, String destination){
        utenteService.copyItem(filename, directory, destination);

        System.out.println("Il file " + filename + " è stato copiato in " + destination);
    }

    public void deleteItem(String directory, String filename) {
        utenteService.deleteItem(directory, filename);

        System.out.println("Il file " + filename + " è stato cancellato");
    }
    public void backup(String directory, String destination) {
        utenteService.backup(directory, destination);

        System.out.println("Il contenuto di " + directory + " è stato copiato in " + destination);
    }

}