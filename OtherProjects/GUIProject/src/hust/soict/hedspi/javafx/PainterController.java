package hust.soict.hedspi.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    // Khai báo 2 nút RadioButton đã đặt fx:id trong Scene Builder
    @FXML
    private RadioButton pen;

    @FXML
    private RadioButton eraser;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        // Kiểm tra xem người dùng đang chọn Bút hay Cục tẩy để quyết định màu mực
        Color inkColor = Color.BLACK; // Mặc định là màu đen (Pen)

        if (eraser.isSelected()) {
            inkColor = Color.WHITE; // Nếu chọn Eraser thì dùng màu trắng (trùng màu nền)
        }

        // Vẽ hình tròn với màu đã được quyết định
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, inkColor);
        drawingAreaPane.getChildren().add(newCircle);
    }
}