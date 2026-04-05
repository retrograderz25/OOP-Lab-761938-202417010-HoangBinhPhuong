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
    }
}
