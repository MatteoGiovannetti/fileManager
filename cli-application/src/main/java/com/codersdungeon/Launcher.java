package com.codersdungeon;

import org.apache.commons.cli.Options;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Launcher {

    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.codersdungeon"); //spring cerca da quel package a tutto quello che c'è dentro.
        context.refresh();
        //alternativa è
       // context.registerBean("service" etc etc);

        Application application = context.getBean(Application.class);

        //apache common cli
       Options options = new Options();
       options.addOption("-s", false, "find in subfolder");

        if(args[0].equals("list")) {
            if(args[1].equals("-s")){
                application.findFilesSubDir(args[2]);
            }
            else application.findFilesInDirectory(args[1]);
        }

        else if(args[0].equals("copy")){
            application.copyItem(args[1], args[2], args[3]);
        }

        else if(args[0].equals("del")) {
            application.deleteItem(args[1], args[2]);
        }

        else if (args[0].equals("backup")){
            application.backup(args[1], args[2]);
        }

        else context.close();

        context.close();

        //operazioni da fare in cli:
        //tutti i comandi devono avere la cartella di lavoro, quindi si stabilisce dove si sta lavorando.
        // il primo comando potrebbe essere inserire la cartella di lavoro? no, file di config si
        // solo comandi e formato, no implementazione fuorché la stampa tipo log

        // 1) elenco files a partire da una cartella data
        // 2) con sottodirectory o meno, ovvero se solo file della cartella o anche le cartelle contenute
        // 3) comando che copia un file da una sorgente a una destinazione sempre dentro una cartella data
        // 4) elimina il file a partire da una cartella data
        // 5) backup dei files in una cartella data in un'altra qualsiasi, da indicare

        //apache commons cli è la libreria, legge i parametri da riga di comando senza gli if, dare uno sguardo. dipendenza maven
        // application->service, service->stampa, così il controller può agire sul service

    }
}
