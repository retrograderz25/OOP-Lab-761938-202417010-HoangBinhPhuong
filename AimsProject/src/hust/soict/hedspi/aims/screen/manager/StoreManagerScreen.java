package hust.soict.hedspi.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;

public class StoreManagerScreen extends JFrame {
    private Store store;

    public StoreManagerScreen(Store store) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenuItem viewStoreMenu = new JMenuItem("View store");
        menu.add(viewStoreMenu);
        viewStoreMenu.addActionListener(e -> {
            new StoreManagerScreen(store);
            dispose();
        });

        JMenu smUpdateStore = new JMenu("Update Store");
        
        JMenuItem addBookMenu = new JMenuItem("Add Book");
        addBookMenu.addActionListener(e -> {
            new AddBookToStoreScreen(store);
            dispose();
        });
        smUpdateStore.add(addBookMenu);

        JMenuItem addCDMenu = new JMenuItem("Add CD");
        addCDMenu.addActionListener(e -> {
            new AddCompactDiscToStoreScreen(store);
            dispose();
        });
        smUpdateStore.add(addCDMenu);

        JMenuItem addDVDMenu = new JMenuItem("Add DVD");
        addDVDMenu.addActionListener(e -> {
            new AddDigitalVideoDiscToStoreScreen(store);
            dispose();
        });
        smUpdateStore.add(addDVDMenu);

        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        int maxItems = Math.min(9, mediaInStore.size());
        for (int i = 0; i < maxItems; i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }

        return center;
    }

    public static void main(String[] args) {
        Store store = new Store();
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f));
        store.addMedia(new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99f));
        store.addMedia(new DigitalVideoDisc("The Matrix", "Science Fiction", "Lana Wachowski", 136, 22.50f));
        store.addMedia(new DigitalVideoDisc("Inception", "Science Fiction", "Christopher Nolan", 148, 20.00f));
        store.addMedia(new DigitalVideoDisc("Avatar", "Science Fiction", "James Cameron", 162, 25.50f));

        store.addMedia(new CompactDisc(0, "Thriller", "Pop", 15.00f, 42, "Quincy Jones", "Michael Jackson"));
        store.addMedia(new CompactDisc(0, "Back in Black", "Rock", 14.50f, 42, "Mutt Lange", "AC/DC"));
        store.addMedia(new CompactDisc(0, "The Dark Side of the Moon", "Rock", 16.90f, 43, "Alan Parsons", "Pink Floyd"));
        store.addMedia(new CompactDisc(0, "Rumours", "Rock", 12.00f, 40, "Ken Caillat", "Fleetwood Mac"));
        store.addMedia(new CompactDisc(0, "Abbey Road", "Rock", 18.50f, 47, "George Martin", "The Beatles"));

        store.addMedia(new Book(0, "The Hobbit", "Fantasy", 11.99f));
        store.addMedia(new Book(0, "Harry Potter and the Sorcerer's Stone", "Fantasy", 14.50f));
        store.addMedia(new Book(0, "1984", "Dystopian", 10.00f));
        store.addMedia(new Book(0, "To Kill a Mockingbird", "Classic", 9.50f));
        store.addMedia(new Book(0, "The Great Gatsby", "Classic", 12.50f));
        new StoreManagerScreen(store);
    }
}
