package Main;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.Objects;

public class ProductController {

    @FXML
    private ImageView Image;

    @FXML
    private Label nameLabel;

    @FXML
    private Label priceLabel;
    private ProductApple productApple;
    private MyListener myListener;

    @FXML
    private void click(MouseEvent mouseEvent) {
        myListener.onClickListener(this.productApple, 1);
    }
    public void setData(ProductApple productApple, MyListener myListener) {
        this.productApple = productApple;
        this.myListener = myListener;
        nameLabel.setText(productApple.getName());
        priceLabel.setText("฿" + productApple.getPrice());
        Image image = new Image(Objects.requireNonNull(getClass().getResource(this.productApple.getImgSrc())).toExternalForm(), false);
        this.Image.setImage(image);
    }

}
