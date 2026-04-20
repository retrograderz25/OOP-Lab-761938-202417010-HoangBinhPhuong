package hust.soict.hedspi.test.store;

import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        store.addMedia(dvd);

        Book book = new Book(1, "Java Programming", "Technology", 25.5f);
        store.addMedia(book);

        CompactDisc cd = new CompactDisc(2, "Greatest Hits", "Music", 15.0f, 60, "Various", "Queen");
        store.addMedia(cd);

        System.out.println("\nTesting removal:");
        store.removeMedia(book);

        store.printStore();
    }
}