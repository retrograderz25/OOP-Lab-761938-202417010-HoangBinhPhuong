package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();

    public Book() {
        super();
    }

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost); // Gọi constructor của lớp cha Media
    }

    public List<String> getAuthors() { return authors; }

    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
        }
    }

    public void removeAuthor(String authorName) {
        authors.remove(authorName);
    }

    @Override
    public String toString() {
        return super.toString() + " - Authors: " + authors.toString();
    }
}