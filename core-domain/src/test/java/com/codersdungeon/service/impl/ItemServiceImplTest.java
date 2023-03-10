package com.codersdungeon.service.impl;

import com.codersdungeon.dto.FileItemDTO;
import com.codersdungeon.dto.ListFileItemDTO;
import com.codersdungeon.service.interf.ItemService;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.*;

public class ItemServiceImplTest {

    static ItemServiceImpl itemService;

    @BeforeClass
    public static void init(){
        itemService = new ItemServiceImpl();
    }

    @Test
    public void findAllFiles() {
        ListFileItemDTO result = itemService.findAllFiles("src/test/resources/findAllFiles");
        assertNotNull(result);
        assertNotNull(result.items);
        assertEquals(3, result.items.size());
        assertThat(result.items, hasItems(
                new FileItemDTO("testDir", null, "folder"),
                new FileItemDTO("testFile1", 0L, "file"),
                new FileItemDTO("testFile2", 0L, "file")
        ));
    }

    @Test (expected = NullPointerException.class)
    public void nullPath(){
        itemService.findAllFiles(null);
    }


}