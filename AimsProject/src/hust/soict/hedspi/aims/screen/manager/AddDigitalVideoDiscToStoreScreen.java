package hust.soict.hedspi.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store);
        setTitle("Add DVD To Store");
    }

    @Override
    protected JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2, 5, 5));

        inputPanel.add(new JLabel("Title: "));
        JTextField tfTitle = new JTextField();
        inputPanel.add(tfTitle);

        inputPanel.add(new JLabel("Category: "));
        JTextField tfCategory = new JTextField();
        inputPanel.add(tfCategory);

        inputPanel.add(new JLabel("Cost: "));
        JTextField tfCost = new JTextField();
        inputPanel.add(tfCost);

        inputPanel.add(new JLabel("Length: "));
        JTextField tfLength = new JTextField();
        inputPanel.add(tfLength);

        inputPanel.add(new JLabel("Director: "));
        JTextField tfDirector = new JTextField();
        inputPanel.add(tfDirector);

        JButton btnAdd = new JButton("Add DVD");
        btnAdd.addActionListener(e -> {
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            String director = tfDirector.getText();
            float cost = 0;
            int length = 0;
            try {
                cost = Float.parseFloat(tfCost.getText());
                length = Integer.parseInt(tfLength.getText());
            } catch (NumberFormatException ex) {
                // Ignore validation
            }

            DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
            store.addMedia(dvd);
            JOptionPane.showMessageDialog(null, "DVD added successfully!");

            tfTitle.setText("");
            tfCategory.setText("");
            tfCost.setText("");
            tfLength.setText("");
            tfDirector.setText("");
        });

        center.add(inputPanel, BorderLayout.NORTH);
        center.add(btnAdd, BorderLayout.SOUTH);

        return center;
    }
}
