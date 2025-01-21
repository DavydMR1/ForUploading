import java.io.*;
import java.util.List;

public class DataRecorder {
    public void recordNewData(List<Object> data, String fileName, String path){
        deleteDB("src/" + path + fileName + ".bin");
        createDB("src/" + path + fileName + ".bin");
        try (FileOutputStream fileOutputStream = new FileOutputStream("src/main/java/Project_1/DBs/" + fileName + ".bin")){
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(data);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Object> getData(String fileName) {
        try (FileInputStream fileInputStream = new FileInputStream("src/main/java/Project_1/DBs/" + fileName + ".bin")) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (List<Object>) objectInputStream.readObject();
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void createBackupFile(String fileName) {
        recordNewData(getData(fileName), fileName, "backup/");
    }

    private void createDB(String DB_PATH) {
        try {
            File db = new File(DB_PATH);
            if (db.createNewFile()) {
                System.out.println(DB_PATH + " file not found, new one has been created");
            }
            else {
                System.out.println(DB_PATH + " has been successfully connected");
            }
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }
    
    private void deleteDB(String DB_PATH) {
        File db = new File(DB_PATH);
        if (db.delete()) {
            System.out.println(DB_PATH + " successfully deleted");
        }
        else {
            System.out.println(DB_PATH + " not found");
        }
    }
}
