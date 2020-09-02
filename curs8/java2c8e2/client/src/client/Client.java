package client;

import client.controller.MessageController;
import client.gui.MainFrame;
import lib.dto.StatusEvent;

import javax.swing.*;

public class Client {

    public static void main(String[] args) {
        var user = JOptionPane.showInputDialog("Username:");

        MessageController.getInstance()
                .changeStatus(new StatusEvent(user, StatusEvent.Status.CONNECTED));

        new MainFrame(user);
    }
}
