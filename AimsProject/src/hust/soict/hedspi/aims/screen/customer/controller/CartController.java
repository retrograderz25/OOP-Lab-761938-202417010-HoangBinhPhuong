package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class CartController {

    private Cart cart;
    private Store store;

    @FXML private TableView<Media> tblMedia;
    @FXML private TableColumn<Media, String> colMediaTitle;
    @FXML private TableColumn<Media, String> colMediaCategory;
    @FXML private TableColumn<Media, Float> colMediaCost;
    @FXML private TableColumn<Media, Integer> colMediaId;
    @FXML private Button btnPlay;
    @FXML private Button btnRemove;
    @FXML private Label costLabel;

    public CartController(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
    }

    @FXML
    public void initialize() {
        // Ánh xạ dữ liệu các cột
        colMediaId.setCellValueFactory(new PropertyValueFactory<Media, Integer>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));

        if (cart.getItemsOrdered() != null) {
            tblMedia.setItems(cart.getItemsOrdered());
        }

        // Ẩn 2 nút Play và Remove lúc mới mở giỏ hàng (chưa chọn gì)
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        // Lắng nghe sự kiện click chọn 1 hàng trong bảng
        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                updateButtonBar(newValue);
            }
        });

        // Cập nhật tổng tiền
        updateTotalCost();
    }

    void updateButtonBar(Media media) {
        if (media == null) {
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        } else {
            btnRemove.setVisible(true);
            if (media instanceof Playable) {
                btnPlay.setVisible(true);
            } else {
                btnPlay.setVisible(false);
            }
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            cart.removeMedia(media);
            updateTotalCost(); // Nhớ cập nhật lại tiền khi xóa đồ
        }
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        // Lấy sản phẩm đang được chọn trong bảng
        Media media = tblMedia.getSelectionModel().getSelectedItem();

        // Kiểm tra xem có null và có Play được không
        if (media != null && media instanceof Playable) {
            // Ép kiểu sang Playable và gọi hàm play()
            ((Playable) media).play();
        }
    }


    private void updateTotalCost() {
        costLabel.setText(String.format("%.2f $", cart.totalCost()));
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        System.out.println("Order placed! Emptying cart...");
        cart.getItemsOrdered().clear(); // Làm trống giỏ
        updateTotalCost();
    }

    // --- CODE CHUYỂN MÀN HÌNH ---
    @FXML
    void btnViewStorePressed(ActionEvent event) {
        try {
            final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
            // Trả lại dữ liệu cho màn hình Store
            fxmlLoader.setController(new ViewStoreController(store, cart));
            Parent root = fxmlLoader.load();

            Scene currentScene = ((Node) event.getSource()).getScene();
            currentScene.setRoot(root);

            Stage stage = (Stage) currentScene.getWindow();
            stage.setTitle("Store");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}