package com.codersdungeon.service.interf;

import com.codersdungeon.dto.FileItemDTO;
import com.codersdungeon.dto.ListFileItemDTO;

public interface ItemService {

    ListFileItemDTO findAllFiles(String percorso);


}
