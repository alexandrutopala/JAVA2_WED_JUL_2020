package client;

import lib.Message;

import javax.swing.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class MainFrame extends JFrame {
    private JTextArea textArea1;
    private JPanel mainPanel;
    private JTextArea textArea2;
    private JButton button1;

    private MessageController messageController = MessageController.getInstance();

    private String username;

    public MainFrame(String username) {
        this.username = username;

        startReceivingMessages();

        button1.addActionListener(ev -> sendMessage());

        setContentPane(mainPanel);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void startReceivingMessages() {
        new Thread(() -> {
            while(true) {
                try {
                    Message message = messageController.getNewMessage();

                    SwingUtilities.invokeAndWait(() -> textArea1.append(message + "\n"));
                } catch (IOException | ClassNotFoundException | InterruptedException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void sendMessage() {
        Message message = new Message(
                textArea2.getText(),
                username
        );

        try {
            messageController.sendMessage(message);

            textArea2.setText("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
