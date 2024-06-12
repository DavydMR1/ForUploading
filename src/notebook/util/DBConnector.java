package notebook.util;

import java.io.File;

public class DBConnector {
    public String FILE_PATH;
    public void createDB(String filename) {
        FILE_PATH = filename;
        try {
            File db = new File(FILE_PATH);
            if (db.createNewFile()) {
                System.out.println("DB created");
            }
            else {
                System.out.println("DB already exists");
            }
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }
}