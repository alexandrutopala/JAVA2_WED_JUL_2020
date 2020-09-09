package client.gui;

import client.controller.ComandaController;

import javax.swing.*;

public class ComandaFrame extends JFrame {
    private JList list1;
    private JPanel mainPanel;

    public ComandaFrame(int produsId) {
        var model = new DefaultListModel<>();

        var comenzi = ComandaController.getInstance().findByProdusId(produsId);

        comenzi.forEach(model::addElement);

        list1.setModel(model);

        setContentPane(mainPanel);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
