package hw3;

import hw3.util.ChatLogConnector;
import hw3.util.chatLogger.logWriter.ChatLogWriter;
import hw3.windows.ClientGui;
import hw3.windows.ServerWindow;

public class Main {
    public static void main(String[] args) {
        ChatLogConnector.createDB("chat_log.txt");
        ChatLogConnector.createDB("server_log.txt");
        ChatLogWriter writer = new ChatLogWriter();
        new ServerWindow();
        new ClientGui();
        new ClientGui();
    }
}
