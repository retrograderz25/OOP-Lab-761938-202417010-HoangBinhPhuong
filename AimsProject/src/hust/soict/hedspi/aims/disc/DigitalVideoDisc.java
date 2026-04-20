package hust.soict.hedspi.aims.disc;

import hust.soict.hedspi.aims.media.Disc;
import hust.soict.hedspi.aims.media.Playable;

public class DigitalVideoDisc extends Disc implements Playable {
    public DigitalVideoDisc() {
        super();
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(0, title, category, cost, length, director);
    }

    public DigitalVideoDisc(String title) {
        super(0, title, null, 0.0f, 0, null);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(0, title, category, cost, 0, null);
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(0, title, category, cost, 0, director);
    }

    @Override
    public void play() {
        if (this.getLength() > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        } else {
            System.out.println("ERROR: DVD '" + this.getTitle() + "' cannot be played because its length is non-positive!");
        }
    }
}