package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;
import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initStoreData();

        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: viewStore(); break;
                case 2: updateStore(); break;
                case 3: viewCart(); break;
                case 0:
                    System.out.println("Cảm ơn bạn đã sử dụng dịch vụ AIMS!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 0);
    }

    // --- CÁC PHƯƠNG THỨC HIỂN THỊ MENU ---

    // Hiển thị Menu chính của hệ thống
    public static void showMenu() {
        System.out.println("\n--- AIMS MAIN MENU ---");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Vui lòng chọn số (0-3): ");
    }

    // Hiển thị Menu các lựa chọn khi đang xem kho hàng
    public static void storeMenu() {
        System.out.println("\n--- STORE MENU ---");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Vui lòng chọn số (0-4): ");
    }

    // Hiển thị Menu các thao tác quản lý giỏ hàng
    public static void cartMenu() {
        System.out.println("\n--- CART MENU ---");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Vui lòng chọn số (0-5): ");
    }

    // Hiển thị Menu chi tiết sau khi xem thông tin một sản phẩm
    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.print("Vui lòng chọn số (0-2): ");
    }

    // --- XỬ LÝ STORE ---

    // Quản lý luồng hiển thị danh sách sản phẩm trong kho và điều hướng Store Menu
    public static void viewStore() {
        int choice;
        do {
            store.printStore();
            storeMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: mediaDetailsInStore(); break;
                case 2: addMediaToCart(); break;
                case 3: playMediaInStore(); break;
                case 4: viewCart(); break;
                case 0: break;
                default: System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);
    }

    // Tìm kiếm và hiển thị thông tin chi tiết của một sản phẩm trong kho
    private static void mediaDetailsInStore() {
        System.out.print("Nhập tiêu đề sản phẩm: ");
        String title = scanner.nextLine();
        Media media = store.search(title);
        if (media != null) {
            System.out.println(media.toString());
            mediaDetailsMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                cart.addMedia(media);
                System.out.println("Số lượng trong giỏ hiện tại: " + cart.getItemsCount());
            } else if (choice == 2) {
                playMedia(media);
            }
        } else {
            System.out.println("Không tìm thấy sản phẩm này trong kho.");
        }
    }

    // Tìm sản phẩm trong kho theo tiêu đề và thêm vào giỏ hàng
    private static void addMediaToCart() {
        System.out.print("Nhập tiêu đề sản phẩm muốn thêm: ");
        String title = scanner.nextLine();
        Media media = store.search(title);
        if (media != null) {
            cart.addMedia(media);
            System.out.println("Số lượng trong giỏ hiện tại: " + cart.getItemsCount());
        } else {
            System.out.println("Sản phẩm không tồn tại trong kho.");
        }
    }

    // Tìm sản phẩm trong kho theo tiêu đề và thực hiện phát (Play) nếu hợp lệ
    private static void playMediaInStore() {
        System.out.print("Nhập tiêu đề sản phẩm muốn phát: ");
        String title = scanner.nextLine();
        Media media = store.search(title);
        if (media != null) {
            playMedia(media);
        } else {
            System.out.println("Sản phẩm không tồn tại.");
        }
    }

    // --- XỬ LÝ CART ---

    // Quản lý luồng hiển thị giỏ hàng và các thao tác liên quan trong Cart Menu
    public static void viewCart() {
        int choice;
        do {
            cart.print();
            cartMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: filterMediaInCart(); break;
                case 2: sortMediaInCart(); break;
                case 3: removeMediaFromCart(); break;
                case 4: playMediaInCart(); break;
                case 5:
                    System.out.println("Đơn hàng đã được khởi tạo! Giỏ hàng đã làm trống.");
                    cart = new Cart();
                    choice = 0;
                    break;
                case 0: break;
                default: System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);
    }

    // Lọc các sản phẩm trong giỏ hàng theo tiêu chí ID hoặc Tiêu đề
    private static void filterMediaInCart() {
        System.out.print("Lọc theo (1: ID, 2: Title): ");
        int type = scanner.nextInt(); scanner.nextLine();
        if (type == 1) {
            System.out.print("Nhập ID: ");
            cart.search(scanner.nextInt()); scanner.nextLine();
        } else {
            System.out.print("Nhập Title: ");
            cart.search(scanner.nextLine());
        }
    }

    // Sắp xếp các sản phẩm trong giỏ hàng theo Tiêu đề hoặc Giá tiền
    private static void sortMediaInCart() {
        System.out.print("Sắp xếp theo (1: Title, 2: Cost): ");
        int type = scanner.nextInt(); scanner.nextLine();
        if (type == 1) cart.sortByTitle();
        else cart.sortByCost();
    }

    // Xóa một sản phẩm khỏi giỏ hàng dựa trên tiêu đề người dùng nhập
    private static void removeMediaFromCart() {
        System.out.print("Nhập tiêu đề sản phẩm muốn xóa: ");
        String title = scanner.nextLine();
        Media media = cart.search(title);
        if (media != null) {
            cart.removeMedia(media);
            System.out.println("Số lượng trong giỏ hiện tại: " + cart.getItemsCount());
        } else {
            System.out.println("Không có sản phẩm này trong giỏ.");
        }
    }

    // Tìm sản phẩm trong giỏ hàng theo tiêu đề và thực hiện phát (Play)
    private static void playMediaInCart() {
        System.out.print("Nhập tiêu đề muốn phát: ");
        String title = scanner.nextLine();
        Media media = cart.search(title);
        if (media != null) {
            playMedia(media);
        } else {
            System.out.println("Không có sản phẩm này trong giỏ.");
        }
    }

    // --- CẬP NHẬT STORE ---

    // Thêm hoặc xóa sản phẩm khỏi kho hàng của hệ thống
    public static void updateStore() {
        System.out.println("1. Add Media | 2. Remove Media");
        int sub = scanner.nextInt(); scanner.nextLine();
        if (sub == 1) {
            System.out.println("Chọn loại (1. DVD, 2. Book, 3. CD): ");
            int type = scanner.nextInt(); scanner.nextLine();
            System.out.print("Tiêu đề: "); String t = scanner.nextLine();
            System.out.print("Danh mục: "); String c = scanner.nextLine();
            System.out.print("Giá: "); float p = scanner.nextFloat(); scanner.nextLine();

            if (type == 1) store.addMedia(new DigitalVideoDisc(t, c, p));
            else if (type == 2) store.addMedia(new Book(0, t, c, p));
            else if (type == 3) store.addMedia(new CompactDisc(0, t, c, p, 0, "", ""));
        } else if (sub == 2) {
            System.out.print("Nhập tiêu đề Media muốn xóa: ");
            String title = scanner.nextLine();
            Media m = store.search(title);
            if (m != null) store.removeMedia(m);
            else System.out.println("Không tìm thấy trong kho.");
        }
    }

    // --- CÁC PHƯƠNG THỨC BỔ TRỢ ---

    // Khởi tạo các đối tượng Media mẫu để chạy thử chương trình
    private static void initStoreData() {
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Sci-Fi", "George Lucas", 124, 24.95f));
        store.addMedia(new Book(1, "Java Programming", "Technology", 15.0f));

        CompactDisc cd = new CompactDisc(2, "Đánh đổi", "Music", 20.0f, 100, "N/A", "Obito");
        cd.addTrack(new Track("Champion", 10));
        store.addMedia(cd);
    }

    private static void playMedia(Media media) {
        if (media instanceof Playable) {
            try {
                // Đưa hàm play() vào trong khối try
                ((Playable) media).play();

            } catch (PlayerException e) {
                // Bắt lỗi và in ra màn hình console
                System.out.println("Lỗi khi phát Media: " + e.getMessage());
                // e.printStackTrace(); // Tùy chọn: In chi tiết lỗi
            }
        } else {
            System.out.println("Lỗi: Sản phẩm '" + media.getTitle() + "' không hỗ trợ tính năng Play!");
        }
    }
}