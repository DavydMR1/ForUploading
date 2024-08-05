package hw3.util.chatLogger;

import java.util.List;

public interface ChatLogger {
    public List<String> readAll(String fileName);
    public void saveAll(String data, String fileName);
    public void saveLine(String data, String fileName);
    public String readLastLine(String fileName);
}
