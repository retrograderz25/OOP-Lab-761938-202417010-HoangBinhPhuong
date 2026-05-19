package hust.soict.hedspi.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen {

    public AddBookToStoreScreen(Store store) {
        super(store);
        setTitle("Add Book To Store");
    }

    @Override
    protected JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2, 5, 5));

        inputPanel.add(new JLabel("Title: "));
        JTextField tfTitle = new JTextField();
        inputPanel.add(tfTitle);

        inputPanel.add(new JLabel("Category: "));
        JTextField tfCategory = new JTextField();
        inputPanel.add(tfCategory);

        inputPanel.add(new JLabel("Cost: "));
        JTextField tfCost = new JTextField();
        inputPanel.add(tfCost);

        JButton btnAdd = new JButton("Add Book");
        btnAdd.addActionListener(e -> {
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            float cost = 0;
            try {
                cost = Float.parseFloat(tfCost.getText());
            } catch (NumberFormatException ex) {
                // Ignore validation as per instructions
            }

            Book newBook = new Book(0, title, category, cost);
            store.addMedia(newBook);
            JOptionPane.showMessageDialog(null, "Book added successfully!");
            
            tfTitle.setText("");
            tfCategory.setText("");
            tfCost.setText("");
        });

        center.add(inputPanel, BorderLayout.NORTH);
        center.add(btnAdd, BorderLayout.SOUTH);

        return center;
    }
}
