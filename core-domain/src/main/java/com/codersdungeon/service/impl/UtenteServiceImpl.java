package com.codersdungeon.service.impl;

import com.codersdungeon.dto.FileItemDTO;
import com.codersdungeon.dto.ListFileItemDTO;
import com.codersdungeon.service.interf.UtenteService;
import com.codersdungeon.temp.FileItem;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class UtenteServiceImpl implements UtenteService {

    FileItem item1 = new FileItem("file1", 432, "directory1", "02/02/2020");
    FileItem item2 = new FileItem("file2", 2, "directory1", "30/12/2021");
    FileItem item3 = new FileItem("file3", 98, "directory2", "03/01/2019");
    FileItem item4 = new FileItem("file4", 12, "directory3", "23/06/2023");
    FileItem item5 = new FileItem("file5", 987, "directory1", "18/09/1992");

    List<FileItem> itemList = new ArrayList<>(Arrays.asList(item1, item2, item3, item4, item5));

    @Override
    public ListFileItemDTO findAllFiles(String percorso) {
        ListFileItemDTO result = new ListFileItemDTO();

        for (FileItem item : itemList) {
            if(item.getDirectory().equals(percorso)){
                FileItemDTO itemDTO = itemToDTO(item);
                result.items.add(itemDTO);
            }
        }
        return result;
    }

    @Override
    public ListFileItemDTO findAllSubDir(String percorso) {
        ListFileItemDTO result = new ListFileItemDTO();

        for (FileItem item : itemList) {
                FileItemDTO itemDTO = itemToDTO(item);
                result.items.add(itemDTO);
        }

        return result;
    }

    @Override
    public FileItemDTO copyItem(String filename, String directory, String destination) {
        FileItemDTO copy = new FileItemDTO();
        for (FileItem item : itemList) {
            if(item.getNome().equals(filename)&&item.getDirectory().equals(directory)){
                FileItem itemCopy = new FileItem(item.getNome(), item.getDimensione(), destination, "copia ora");
                itemList.add(itemCopy);
                copy = itemToDTO(item);
            }
        }
         return copy;
    }

    @Override
    public void deleteItem(String directory, String filename) {

        for (FileItem item : itemList) {
            if(item.getNome().equals(filename)&&item.getDirectory().equals(directory)){
                itemList.remove(item);
                break;
            }
        }
    }

    @Override
    public ListFileItemDTO backup(String destination) {

        ListFileItemDTO listFileItemDTO = new ListFileItemDTO();
        for (FileItem item : itemList) {
            FileItemDTO dto = itemToDTO(item);
            dto.directory=destination;
            listFileItemDTO.items.add(dto);
        }
        //aggiungere copia della lista item al db

        return listFileItemDTO;
    }

    public FileItemDTO itemToDTO (FileItem fileItem){
        return new FileItemDTO(fileItem.getNome(), fileItem.getDimensione(), fileItem.getDirectory(), fileItem.getCreationDate());
    }

    public FileItem dtoToItem (FileItemDTO fileItemDTO){
        return new FileItem(fileItemDTO.nome, fileItemDTO.dimensione, fileItemDTO.directory, fileItemDTO.creationDate);
    }

}
