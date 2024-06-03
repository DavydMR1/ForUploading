package homework.util;

import java.io.File;

public class LogConnector {
    public static final String Log_PATH = "log.txt";
    public static void createlogfile() {
        try {
            File log = new File(Log_PATH);
            if (log.createNewFile()) {
                System.out.println("log file created");
            }
            else {
                System.out.println("log file already exists");
            }
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }
}