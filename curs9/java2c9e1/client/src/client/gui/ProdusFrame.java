package client.gui;

import client.controller.ComandaController;
import client.controller.ProdusController;
import lib.dto.AdresaDto;
import lib.dto.Categorie;
import lib.dto.ComandaDto;
import lib.dto.ProdusDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.Instant;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ProdusFrame extends JFrame {
    private JList list1;
    private JPanel mainPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JButton adaugaButton;
    private JButton adaugaComandaButton;

    private DefaultListModel<ProdusDto> model = new DefaultListModel<>();

    public ProdusFrame() {

        list1.setModel(model);
        list1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        refresh();

        adaugaButton.addActionListener(e -> {
            var produs = new ProdusDto(
                    textField1.getText(),
                    Double.parseDouble(textField2.getText()),
                    Categorie.ALIMENTE
            );

            ProdusController.getInstance().persist(produs);

            refresh();

            textField1.setText("");
            textField2.setText("");
        });

        adaugaComandaButton.addActionListener(e -> {
            var produse = (List<ProdusDto>) list1.getSelectedValuesList();

            if (!produse.isEmpty()) {
                var total = produse.stream().mapToDouble(ProdusDto::getPret).sum();
                var ids = produse.stream().map(ProdusDto::getId).collect(Collectors.toSet());

                // TODO: create dialog for inserting address and phone numbers

                var comanda = new ComandaDto(
                        total,
                        Instant.now(),
                        new AdresaDto("timisoara", "4"),
                        Set.of("124", "432"),
                        ids
                );

                ComandaController.getInstance().persist(comanda);

                list1.setSelectedIndex(-1);
            }
        });

        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                var selected = (ProdusDto) list1.getSelectedValue();

                if (selected != null && e.getClickCount() == 2) {
                    new ComandaFrame(selected.getId());
                }
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        setSize(400, 700);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void refresh() {
        var produse = ProdusController.getInstance().findAll();

        model.clear();

        produse.forEach(model::addElement);
    }
}
