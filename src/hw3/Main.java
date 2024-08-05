package hw3;

import hw3.client.ClientController;
import hw3.client.ClientGui;
import hw3.server.ServerController;
import hw3.server.ServerWindow;
import hw3.util.ChatLogConnector;

public class Main {
    public static void main(String[] args) {
        ChatLogConnector.createDB("chat_log.txt");
        ChatLogConnector.createDB("server_log.txt");

        ServerController serverController = new ServerController();
        ServerWindow serverWindow = new ServerWindow(serverController);
        serverController.setServerWindow(serverWindow);
        serverController.stopServer();

        ClientController clientController1 = new ClientController();
        ClientGui clientGui1 = new ClientGui(clientController1);
        clientController1.setClientGui(clientGui1);
        clientController1.setServerController(serverController);

        ClientController clientController2 = new ClientController();
        ClientGui clientGui2 = new ClientGui(clientController2);
        clientController2.setClientGui(clientGui2);
        clientController2.setServerController(serverController);
    }
}
