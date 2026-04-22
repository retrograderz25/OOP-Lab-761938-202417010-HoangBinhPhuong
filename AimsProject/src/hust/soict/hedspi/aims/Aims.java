package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;

public class Aims {
    public static void main(String[] args) {
        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addMedia(dvd2);

        Book book1 = new Book(1, "Java Programming", "Technology", 15.99f);
        book1.addAuthor("James Gosling");
        anOrder.addMedia(book1);

        CompactDisc cd1 = new CompactDisc(2, "Greatest Hits", "Music", 20.0f, 0, "Various", "Queen");
        cd1.addTrack(new Track("Bohemian Rhapsody", 6));
        cd1.addTrack(new Track("Don't Stop Me Now", 4));
        anOrder.addMedia(cd1);

        anOrder.print();

        System.out.println("\nRemoving 'Star Wars'...");
        anOrder.removeMedia(dvd2);

        System.out.println("\nUpdated Cart:");
        anOrder.print();

        System.out.println("\n--- Manually iterating through media list ---");
    }
}