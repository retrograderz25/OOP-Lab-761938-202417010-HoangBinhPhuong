package hust.soict.hedspi.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void play() {
        if (this.getLength() > 0) {
            System.out.println("Playing track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength());
        } else {
            System.out.println("ERROR: Track '" + this.getTitle() + "' cannot be played because its length is non-positive!");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        Track other = (Track) obj;

        if (this.length != other.length) return false;
        if (this.title == null) {
            return other.title == null;
        }
        return this.title.equalsIgnoreCase(other.title);
    }
}