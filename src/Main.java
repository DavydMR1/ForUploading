import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(9);
        List<Object> o = new ArrayList<>(list);
        DataRecorder recorder = new DataRecorder();
        recorder.recordNewData(o, "o", "");
        recorder.createBackupFile("o");
    }
}
