public class Aims {
    public static void main(String[] args) {
        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
                "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        anOrder.print();
        // section 13
        System.out.println("\nRemoving 'Star Wars'...");
        anOrder.removeDigitalVideoDisc(dvd2);

        System.out.println("\nUpdated Cart:");
        anOrder.print();

        System.out.println("\nAttempting to remove 'Star Wars' again...");
        anOrder.removeDigitalVideoDisc(dvd2);

        // section 14
        // Nạp chồng với mảng
        DigitalVideoDisc[] list = {
                new DigitalVideoDisc("gao ranger"),
                new DigitalVideoDisc("hachimichi remix")
        };
        anOrder.addDigitalVideoDisc(list);

        // Nạp chồng với 2 tham số
        DigitalVideoDisc d6 = new DigitalVideoDisc("obito");
        DigitalVideoDisc d7 = new DigitalVideoDisc("mck");
        anOrder.addDigitalVideoDisc(d6, d7);

        anOrder.print();
    }
}
