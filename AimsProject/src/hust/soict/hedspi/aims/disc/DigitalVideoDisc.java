package hust.soict.hedspi.aims.disc;

import hust.soict.hedspi.aims.media.Disc;

public class DigitalVideoDisc extends Disc {

    public DigitalVideoDisc(String title) {
        super(0, title, null, 0.0f, 0, null);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(0, title, category, cost, 0, null);
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(0, title, category, cost, 0, director);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(0, title, category, cost, length, director);
    }

    @Override
    public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + ": " + getCost() + " $";
    }
}