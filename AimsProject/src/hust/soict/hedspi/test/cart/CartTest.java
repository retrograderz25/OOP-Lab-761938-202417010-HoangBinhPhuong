package hust.soict.hedspi.test.cart;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Book;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addMedia(dvd2);

        Book book1 = new Book(1, "Java Programming", "Education", 15.5f);
        book1.addAuthor("James Gosling");
        cart.addMedia(book1);

        cart.print();

        System.out.println("\n--- Search Results ---");

        System.out.println("Searching by ID (ID: 1):");
        cart.search(1);

        System.out.println("\nSearching by title ('Star'):");
        cart.search("Star");

        System.out.println("\nSearching for non-existent title ('Cinderella'):");
        cart.search("Cinderella");
    }
}