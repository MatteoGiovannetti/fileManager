import com.codersdungeon.config.TestConfig;
import com.codersdungeon.controller.ItemController;
import com.codersdungeon.dto.ListFileItemDTO;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class WebTest {

    @Autowired
    private ItemController itemController;


    @Test
    public void findAllfiles() {
        ListFileItemDTO testList = itemController.findFilesInDirectory("directory1");
        assertEquals(2, testList.items.size());
    }

    @Test
    public void findAllFilesInSubDir(){
        assertEquals(4, itemController.findFilesSubDir("directory1").items.size());
    }

    @Test
    public void copy(){
        assertNotNull(itemController.copyItem("file1", "directory1", "newDest"));
    }

    /*@Test
    public void copyFalse(){
        assertNull(itemController.copyItem("file1", "directory1", "newDest"));
    }*/

    @Test
    public void delete(){
        itemController.deleteItem("directory1", "file1");

        assertEquals( 2, itemController.findFilesInDirectory("directory1").items.size());
    }

    @Test
    public void backup(){
        assertEquals(5, itemController.backup("newDir").items.size());
    }






}
