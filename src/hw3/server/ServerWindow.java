package hw3.server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerWindow extends JFrame {
    private static final int POS_X = 500;
    private static final int POS_Y = 550;
    private static final int WIDTH = 413;
    private static final int HEIGHT = 337;

    private final JButton btnStart = new JButton("Start");
    private final JButton btnStop = new JButton("Stop");
    private final JTextArea log = new JTextArea();
    private final JPanel panelBottom = new JPanel(new BorderLayout());

    private final ServerController serverController;

    public ServerWindow(ServerController serverController) {
        this.serverController = serverController;
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!serverController.serverStatus()) {
                    log.append("Server is already stopped\n");
                }
                else {
                    serverController.stopServer();
                }
            }
        });
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (serverController.serverStatus()) {
                    log.append("Server is already working\n");
                }
                else {
                    serverController.startServer();
                }
            }
        });

        setTitle("Chat server");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WIDTH, HEIGHT);

        btnStart.setPreferredSize(new Dimension((getWidth() - 13) / 2, 30));
        btnStop.setPreferredSize(new Dimension(getWidth() - (getWidth() - 13) / 2, 30));

        panelBottom.add(btnStart, BorderLayout.WEST);
        panelBottom.add(btnStop, BorderLayout.EAST);
        add(panelBottom, BorderLayout.SOUTH);

        JScrollPane scrollLog = new JScrollPane(log);
        add(scrollLog);

        setResizable(false);
        setAlwaysOnTop(true);
        setVisible(true);
    }

    public void printLog(String log) {
        this.log.append(log + "\n");
    }
}
