import com.codersdungeon.temp.FileItem;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileItemTest {

    private static final Logger LOG = LoggerFactory.getLogger(FileItemTest.class);

    @Test
    public void printWorkingDirectory() throws IOException {

        String dir = System.getProperty("user.dir"); //"safepoint" per la cartella di lavoro attuale

        Path path= Paths.get(dir, "src", "test", "resources", "logback1.xml");
        Path path2= Paths.get(dir,"src/test/resources/", "logback2.xml");

        Files.copy(path, path2);
    }

}
