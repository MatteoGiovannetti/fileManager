package com.codersdungeon.service.impl;

import com.codersdungeon.dto.FileItemDTO;
import com.codersdungeon.dto.ListFileItemDTO;
import com.codersdungeon.service.interf.UtenteService;
import org.springframework.stereotype.Service;

@Service
public class UtenteServiceImpl implements UtenteService {

    @Override
    public ListFileItemDTO findAllFiles(String percorso) {
        ListFileItemDTO result = new ListFileItemDTO();
        FileItemDTO itemDTO = new FileItemDTO(percorso);
        result.items.add(itemDTO);

        return result;
    }

    @Override
    public ListFileItemDTO findAllSubDir(String percorso) {
        ListFileItemDTO result = new ListFileItemDTO();
        FileItemDTO itemDTO = new FileItemDTO(percorso);
        result.items.add(itemDTO);

        return result;
    }

    @Override
    public FileItemDTO copyItem(String filename, String directory, String destination) {
        FileItemDTO copy = new FileItemDTO(filename, directory);
        copy.directory = destination;
        return copy;
    }

    @Override
    public void deleteItem(String directory, String filename) {
        FileItemDTO copy = new FileItemDTO(filename, directory);
        copy.directory=null;
        copy.nome=null;
    }

    @Override
    public ListFileItemDTO backup(String directory, String destination) {
        ListFileItemDTO list= findAllFiles(directory);
        for(FileItemDTO file:list.items){
            file.directory=destination;
        }
        return list;
    }


}
