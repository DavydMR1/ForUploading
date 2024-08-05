package hw3.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class ClientGui extends JFrame {
    private static final int WIDTH = 413;
    private static final int HEIGHT = 337;
    private boolean connected = false;

    private final JTextArea log = new JTextArea();

    private final JPanel panelTop = new JPanel(new GridLayout(2, 5));
    private final JTextField IP = new JTextField("127.0.0.1");
    private final JTextField port = new JTextField("1111");
    private final JTextField login = new JTextField("Vasiliy");
    private final JPasswordField password = new JPasswordField("8080");
    private final JButton btnLogin = new JButton("Log in");
    private final JButton btnLogoff = new JButton("Log off");
    private final JPanel panelTop2 = new JPanel(new GridLayout(1, 1));

    private final JPanel panelBottom = new JPanel(new BorderLayout());
    private final JTextField message = new JTextField();
    private final JButton btnSend = new JButton("Send");

    private final JLayeredPane pane = new JLayeredPane();

    private ClientController clientController;

    public ClientGui(ClientController clientController) {
        this.clientController = clientController;

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (connected) {
                    if (!Objects.equals(message.getText(), "")) {
                        clientController.sendMessage(message.getText());
                        message.setText("");
                    }
                }
            }
        });

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clientController.getServerStatus()) {
                    if (clientController.connect(IP.getText(), port.getText(), login.getText(), String.valueOf(password.getPassword()))) {
                        connected = true;
                        panelTop.setVisible(false);
                        panelTop2.setVisible(true);
                    }
                }
                else {
                    log.append("Server is not running\n");
                }
            }
        });

        btnLogoff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disconnect();
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WIDTH, HEIGHT);
        setTitle("Chat client");

        panelTop.add(new JTextField("Server IP"));
        panelTop.add(new JTextField("Server port"));
        panelTop.add(new JTextField("Login"));
        panelTop.add(new JTextField("Password"));
        panelTop.add(new JTextField(""));
        panelTop.add(IP);
        panelTop.add(port);
        panelTop.add(login);
        panelTop.add(password);
        panelTop.add(btnLogin);
        panelTop.setBounds(0, 0, 400, 40);

        panelTop2.add(btnLogoff);
        panelTop2.setBounds(0, 0, 400, 40);

        pane.setPreferredSize(new Dimension(400, 40));
        pane.add(panelTop, 5);
        pane.add(panelTop2, 2);
        add(pane, BorderLayout.NORTH);

        panelBottom.add(message, BorderLayout.CENTER);
        panelBottom.add(btnSend, BorderLayout.EAST);
        add(panelBottom, BorderLayout.SOUTH);

        JScrollPane scrollLog = new JScrollPane(log);
        add(scrollLog);

        setVisible(true);
    }

    public void disconnect() {
        connected = false;
        panelTop2.setVisible(false);
        panelTop.setVisible(true);
        log.append("You disconnected from the server\n");
    }

    public void printMessage(String message) {
        log.append(message);
    }
}
