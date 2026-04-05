public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

    private int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added");
        } else {
            System.out.println("The cart is almost full");
        }
    }

    // 14.1: Nạp chồng bằng cách truyền một mảng các DVD
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc disc : dvdList) {
            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
                itemsOrdered[qtyOrdered] = disc;
                qtyOrdered++;
                System.out.println("The disc '" + disc.getTitle() + "' has been added.");
            } else {
                System.out.println("The cart is full. Cannot add '" + disc.getTitle() + "'.");
                break;
            }
        }
    }

    // 14.1 cách sử dụng tham số biến đổi (Varargs)
//    public void addDigitalVideoDisc(DigitalVideoDisc... dvds) {
//        for (DigitalVideoDisc disc : dvds) {
//            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
//                itemsOrdered[qtyOrdered] = disc;
//                qtyOrdered++;
//                System.out.println("The disc '" + disc.getTitle() + "' has been added.");
//            } else {
//                System.out.println("The cart is full. Cannot add '" + disc.getTitle() + "'.");
//                break;
//            }
//        }
//    }

    // 14.2: Nạp chồng bằng cách truyền chính xác 2 tham số
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered + 1 < MAX_NUMBERS_ORDERED) {
            addDigitalVideoDisc(dvd1);
            addDigitalVideoDisc(dvd2);
        } else {
            System.out.println("Not enough space in cart for 2 discs.");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                // Xóa và xếp các đĩa ở dưới lên
                System.out.println("The disc has been removed");
                return;
            }
        }
        System.out.println("The disc is not in the cart");
    }

    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }

    public void print() {
        System.out.println("\nOrdered Items:");

        for (int i = 0; i < qtyOrdered; i++) {
            System.out.printf("%-3d %-30s $%5.2f\n",(i + 1), itemsOrdered[i].getTitle(), itemsOrdered[i].getCost());
        }

        System.out.printf("Total Cost: %22s $%.2f\n", " ", totalCost());
    }
}