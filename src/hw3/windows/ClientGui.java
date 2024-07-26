package hw3.windows;

import hw3.util.chatLogger.logWriter.ChatLogWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Objects;

public class ClientGui extends JFrame {
    private static final int WIDTH = 413;
    private static final int HEIGHT = 337;
    private boolean connected = false;
    private final Object banana = new Object();

    private final ChatLogWriter logger = new ChatLogWriter();

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

//    private final DefaultListModel<String> listModel = new DefaultListModel<>();
//    private final JList<String> text = new JList<>(listModel);
    private String[][] userList = new String[0][2];

    public ClientGui() {
        SetUsers(new String[]{"Vasiliy", "8080"});
        SetUsers(new String[]{"Pupkin", "9999"});

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (connected) {
                    if (!Objects.equals(message.getText(), "")) {
                        log.append(message.getText() + "\n");
                        logger.saveLine(message.getText(), "chat_log.txt");
                        message.setText("");
                    }
                }
            }
        });

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!Objects.equals(logger.readLastLine("server_log.txt"), "Server stopped")) {
                    if (VerifyUser()) {
                        connected = true;
                        try {
                            checkMessages();
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
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
                connected = false;
                notifyAll();
                panelTop2.setVisible(false);
                panelTop.setVisible(true);
                log.append("You disconnected from the server\n");
                logger.saveLine(login.getText() + " disconnected from the server", "chat_log.txt");
                logger.saveLine(login.getText() + " disconnected from the server", "server_log.txt");
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

    private void checkMessages() throws InterruptedException {
        synchronized (banana) {
            while (connected) {
                banana.wait(1000);
                List<String> check = logger.readAll("chat_log.txt");
                String[] existing = log.getText().split("\n");
                if (check.size() > existing.length) {
                    for (int i = existing.length; i < check.size(); i++) {
                        log.append(check.get(i) + "\n");
                    }
                }
            }
        }
    }

    private void SetUsers(String[] data) {
        String[][] temp = userList;
        userList = new String[temp.length + 1][2];
        System.arraycopy(temp, 0, userList, 0, temp.length);
        userList[userList.length - 1] = data;
        //Заполнение можно получше сделать, с бд в виде файла и т.д. но времени нет
    }

    private boolean VerifyUser() {
        if (Objects.equals(IP.getText(), "127.0.0.1") && Objects.equals(port.getText(), "1111")) {
            // функция "==" не работает
            int n = -1;
            for (int i = 0; i < 2; i++) {
                if (Objects.equals(userList[i][0], login.getText())) {
                    n = i;
                    break;
                }
            }
            if (n != -1) {
                if (Objects.equals(userList[n][1], String.valueOf(password.getPassword())))
                {
                    List<String> data = logger.readAll("chat_log.txt");
                    for (String datum : data) {
                        log.append(datum + "\n");
                    }
                    log.append("Connection successful!\n");
                    logger.saveLine(login.getText() + " connected to the server", "chat_log.txt");
                    logger.saveLine(login.getText() + " connected to the server", "server_log.txt");
                    return true;
                }
                else {
                    log.append("Incorrect password");
                    return false;
                }
            }
            else {
                log.append("Such user does not exist\n");
                return false;
            }
        }
        else {
            log.append("Connection failed\n");
            System.out.println(IP.getText() + " " + port.getText());
            return false;
        }
    }
}
