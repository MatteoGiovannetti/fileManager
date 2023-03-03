package com.codersdungeon.service.interf;

import com.codersdungeon.dto.FileItemDTO;
import com.codersdungeon.dto.ListFileItemDTO;

public interface UtenteService {

    ListFileItemDTO findAllFiles(String percorso);

    ListFileItemDTO findAllSubDir(String percorso);

    FileItemDTO copyItem(String filename, String directory, String destination);

    void deleteItem(String directory, String filename);

    ListFileItemDTO backup(String directory, String destination);

}
