package hust.soict.hedspi.test;

import java.util.ArrayList;
import java.util.List;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.CompactDisc;

public class PolymorphismTest {
    public static void main(String[] args) {
        List<Media> mediae = new ArrayList<Media>();

        Media cd = new CompactDisc(1, "Greatest Hits", "Music", 15.5f, 60, "Various", "Queen");
        Media dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        Media book = new Book(3, "Java Programming", "Technology", 20.0f);

        mediae.add(cd);
        mediae.add(dvd);
        mediae.add(book);

        for (Media m : mediae) {
            System.out.println(m.toString());
        }
    }
}

/*
* output:
* ID: 1 - Title: Greatest Hits - Category: Music - Cost: 15.5 $
ID: 0 - Title: The Lion King - Category: Animation - Cost: 19.95 $
ID: 3 - Title: Java Programming - Category: Technology - Cost: 20.0 $ - Authors: []
*/

/*
* Giải thích hiện tượng:
* Khi ta gọi m.toString(), mặc dù biến m có kiểu dữ liệu là Media nhưng tại thời điểm thực thi (runtime)
* Java sẽ kiểm tra và xác định đối tượng thực sự mà m đang trỏ tới là gì (Books, DVD hay CD).
* Cơ chế này được gọi là Liên kết muộn (dynamic binding).
* */