package hust.soict.hedspi.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.store.Store;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {

    public AddCompactDiscToStoreScreen(Store store) {
        super(store);
        setTitle("Add CD To Store");
    }

    @Override
    protected JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(7, 2, 5, 5));

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

        inputPanel.add(new JLabel("Artist: "));
        JTextField tfArtist = new JTextField();
        inputPanel.add(tfArtist);

        JButton btnAdd = new JButton("Add CD");
        btnAdd.addActionListener(e -> {
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            String director = tfDirector.getText();
            String artist = tfArtist.getText();
            float cost = 0;
            int length = 0;
            try {
                cost = Float.parseFloat(tfCost.getText());
                length = Integer.parseInt(tfLength.getText());
            } catch (NumberFormatException ex) {
                // Ignore validation
            }

            CompactDisc cd = new CompactDisc(0, title, category, cost, length, director, artist);
            store.addMedia(cd);
            JOptionPane.showMessageDialog(null, "CD added successfully!");

            tfTitle.setText("");
            tfCategory.setText("");
            tfCost.setText("");
            tfLength.setText("");
            tfDirector.setText("");
            tfArtist.setText("");
        });

        center.add(inputPanel, BorderLayout.NORTH);
        center.add(btnAdd, BorderLayout.SOUTH);

        return center;
    }
}
