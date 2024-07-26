package hw3.windows;

import hw3.util.chatLogger.logWriter.ChatLogWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerWindow extends JFrame {
    ChatLogWriter logger = new ChatLogWriter();
    private static final int POS_X = 500;
    private static final int POS_Y = 550;
    private static final int WIDTH = 413;
    private static final int HEIGHT = 337;

    private final JButton btnStart = new JButton("Start");
    private final JButton btnStop = new JButton("Stop");
    private final JTextArea log = new JTextArea();
    private final JPanel panelBottom = new JPanel(new BorderLayout());
    private boolean isServerWorking;

    public ServerWindow() {
        log.append("Server stopped\n");
        logger.saveLine("Server stopped", "server_log.txt");
        isServerWorking = false;
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isServerWorking) {
                    log.append("Server is already stopped\n");
                }
                else {
                    isServerWorking = false;
                    log.append("Server stopped\n");
                    logger.saveLine("Server stopped", "server_log.txt");
                }
            }
        });
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isServerWorking) {
                    log.append("Server is already working\n");
                }
                else {
                    isServerWorking = true;
                    log.append("Server started\n");
                    logger.saveLine("Server started", "server_log.txt");
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
}
