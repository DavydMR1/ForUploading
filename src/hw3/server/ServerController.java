package hw3.server;

import hw3.client.ClientController;
import hw3.util.chatLogger.logWriter.ChatLogWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ServerController {
    private final ChatLogWriter writer = new ChatLogWriter();
    private String[][] userList = new String[0][2];
    List<ClientController> connectedUsersIP = new ArrayList<>();
    List<String> connectedUsersID = new ArrayList<>();
    private boolean serverOnline;


    private ServerWindow serverWindow;

    public ServerController() {
        setUsers(new String[]{"Vasiliy", "8080"});
        setUsers(new String[]{"Pupkin", "9999"});
    }

    private void setUsers(String[] data) {
        String[][] temp = userList;
        userList = new String[temp.length + 1][2];
        System.arraycopy(temp, 0, userList, 0, temp.length);
        userList[userList.length - 1] = data;
    }

    public void startServer() {
        serverOnline = true;
        saveLog("Server started");
    }

    public void stopServer() {
        serverOnline = false;
        saveLog("Server stopped");
        for (int i = 0; i < connectedUsersID.size(); i++) {
            connectedUsersIP.get(0).disconnect();

        }
    }

    public boolean serverStatus() {
        return serverOnline;
    }

    public void setServerWindow(ServerWindow serverWindow) {
        this.serverWindow = serverWindow;
    }

    public boolean verifyUser(String login, String password, ClientController clientController) {
            // функция "==" не работает
        int n = -1;
        for (int i = 0; i < 2; i++) {
            if (Objects.equals(userList[i][0], login)) {
                n = i;
                break;
            }
        }
        if (n != -1) {
            if (Objects.equals(userList[n][1], password))
            {
                saveLog(login + " connected to the server");
                connectedUsersIP.add(clientController);
                connectedUsersID.add(login);
                return true;
            }
        }
        return false;
    }

    public void disconnectUser(ClientController clientController) {
        int id = connectedUsersIP.indexOf(clientController);
        connectedUsersIP.remove(id);
        connectedUsersID.remove(id);
    }

    public List<String> getMessages() {
        return writer.readAll("chat_log.txt");
    }

    public void saveMessage(String message, ClientController clientController) {
        for (int i = 0; i < connectedUsersIP.size(); i++) {
            connectedUsersIP.get(i).printMessage(connectedUsersID.get(connectedUsersIP.indexOf(clientController)) + " " + message + "\n");
        }
        writer.saveLine(connectedUsersID.get(connectedUsersIP.indexOf(clientController)) + " " + message, "chat_log.txt");
    }

    public void saveLog(String log) {
        serverWindow.printLog(log);
        writer.saveLine(log, "server_log.txt");
    }
}
