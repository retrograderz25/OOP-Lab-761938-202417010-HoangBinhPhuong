package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ItemController {

    private Cart cart;
    public ItemController(Cart cart) {
        this.cart = cart;
    }

    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblCost;

    @FXML
    private Label lblTitle;

    private Media media;

    // Hàm nhận dữ liệu Media và đẩy lên Giao diện
    public void setData(Media media) {
        this.media = media;
        lblTitle.setText(media.getTitle());
        lblCost.setText(media.getCost() + " $");

        // Nếu sản phẩm có thể Play (DVD, CD) thì hiện nút Play, ngược lại thì giấu đi
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
            HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60)); // Đẩy nút Add to Cart ra giữa
        }
    }

    @FXML
    void btnAddToCartClicked(ActionEvent event) {
        if (media != null) {
            cart.addMedia(media);
            System.out.println("Đã thêm " + media.getTitle() + " vào giỏ.");
        }
    }

    @FXML
    void btnPlayClicked(ActionEvent event) {
        if (media != null && media instanceof Playable) {
            try {
                ((Playable) media).play();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Playing Media");
                alert.setHeaderText("Now playing: " + media.getTitle());
                alert.showAndWait();
            } catch (PlayerException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Illegal Media Length");
                alert.setHeaderText("Error: Media length is non-positive");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        }
    }
}