package hw3.client;

import hw3.server.ServerController;

import java.util.Objects;

public class ClientController {
    private ClientGui clientGui;
    private ServerController serverController;
    private boolean connected;

    public void setClientGui(ClientGui clientGui) {
        this.clientGui = clientGui;
    }

    public void setServerController(ServerController serverController) {
        this.serverController = serverController;
    }

    public boolean getServerStatus() {
        return serverController.serverStatus();
    }

    public boolean connect(String IP, String port, String login, String password) {
        if(Objects.equals(IP, "127.0.0.1")) {
            if (Objects.equals(port, "1111")) {
                if (serverController.verifyUser(login, password, this)) {
                    connectedToServer();
                    return true;
                }
                else {
                    printMessage("Incorrect login or password");
                }
            }
            else {
                printMessage("Incorrect port");
            }
        }
        else {
            printMessage("Incorrect ip");
        }
        return false;
    }

    public void disconnect() {
        clientGui.disconnect();
        serverController.disconnectUser(this);
    }

    private void connectedToServer() {
        for (String message : serverController.getMessages()) {
            printMessage(message);
        }
        printMessage("Connection successful!");
    }

    public void sendMessage(String message) {
        serverController.saveMessage(message, this);
    }

    public void printMessage(String message) {
        clientGui.printMessage(message + "\n");
    }
}
