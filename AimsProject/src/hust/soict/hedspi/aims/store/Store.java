package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Store {
    // Mảng chứa các DVD có sẵn trong kho
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[1000];
    private int qtyInStore = 0;

    // Phương thức thêm DVD vào kho
    public void addDVD(DigitalVideoDisc dvd) {
        if (qtyInStore < itemsInStore.length) {
            itemsInStore[qtyInStore] = dvd;
            qtyInStore++;
            System.out.println("The DVD '" + dvd.getTitle() + "' has been added to the store.");
        } else {
            System.out.println("The store is full, cannot add more DVDs.");
        }
    }

    // Phương thức xóa DVD khỏi kho
    public void removeDVD(DigitalVideoDisc dvd) {
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i] == dvd) {
                // Dịch chuyển các phần tử phía sau lên
                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[qtyInStore - 1] = null;
                qtyInStore--;
                System.out.println("The DVD '" + dvd.getTitle() + "' has been removed from the store.");
                return;
            }
        }
        System.out.println("The DVD was not found in the store.");
    }
}