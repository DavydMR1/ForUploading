package hw3.util.chatLogger.logWriter;

import hw3.util.chatLogger.ChatLogger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ChatLogWriter implements ChatLogger{
    public String update;

    public ChatLogWriter() {
        try (FileWriter writer = new FileWriter("chat_log.txt", true)) {
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try (FileWriter writer = new FileWriter("server_log.txt", true)) {
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<String> readAll(String fileName) {
        List<String> lines = new ArrayList<>();
        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            if (line != null) {
                lines.add(line);
            }
            while (line != null) {
                line = reader.readLine();
                if (line != null) {
                    lines.add(line);
                }
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public void saveAll(String data, String fileName) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(data);
            writer.append('\n');
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveLine(String data, String fileName) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(data);
            writer.append('\n');
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String readLastLine(String fileName) {
        List<String> lines = readAll(fileName);
        return lines.get(lines.size() - 1);
    }
}
