package com.codersdungeon.service.impl;

import com.codersdungeon.dto.FileItemDTO;
import com.codersdungeon.dto.ListFileItemDTO;
import com.codersdungeon.service.interf.ItemService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    @Override
    public ListFileItemDTO findAllFiles(String percorso) {

        //CERCARE VALORI NON VALIDI PER IL PERCOSO E SCRIVERE TEST DI CONSEGUENZA, OGNI CASO NON VALIDO
        // E' UN TEST A PARTE

        //JUNIT CHECK EXCEPTION



        if(percorso==null){
            throw new PercorsoNullException;
        }

        ListFileItemDTO listFileItemDTO = new ListFileItemDTO();

        String workDir = System.getProperty("user.dir");
        Path path = Paths.get(workDir,percorso);



        try {
            listFileItemDTO.items = Files.list(path).map(this::pathToDTO).
                    filter(Optional::isPresent).
                    map(Optional::get).
                    collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return listFileItemDTO;
    }

    private Optional<FileItemDTO> pathToDTO (Path path) {
        FileItemDTO itemDTO = new FileItemDTO();
        itemDTO.nome = path.getFileName().toString();
        itemDTO.type = Files.isDirectory(path)?"folder":"file";
        if(!itemDTO.type.equals("folder")) {
            try {
                itemDTO.dimensione = Files.size(path);
            } catch (IOException e) {
                e.printStackTrace();
               // throw new RuntimeException(e);
                return Optional.empty();
            }
        }
        return Optional.of(itemDTO);
    }


}
