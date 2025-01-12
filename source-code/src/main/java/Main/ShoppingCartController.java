package Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;


public class ShoppingCartController implements Initializable {

    private Stage stage;
    private Scene scene;
    @FXML
    private Label TotalPrice;
    private MyListener myListener;
    @FXML
    private GridPane gridPane;
    private static final List<ProductApple> product = new ArrayList<>();

    public void SwitchToStore(ActionEvent Event) throws IOException {
        product.clear();
        Parent appleStoreRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Main/AppleStore.fxml")));
        this.stage = (Stage)((Node)Event.getSource()).getScene().getWindow();
        this.scene = new Scene(appleStoreRoot);
        stage.setScene(this.scene);
        stage.show();
    }

    public void addToCart(ProductApple productApple, int quantity){
        for (int i = 0; i < quantity; i++) {
            product.add(productApple);
        }
    }

    public double getTotalPrice(){
        double totalPrice = 0;
        for (ProductApple productApple : product){
            totalPrice += productApple.getPrice();
        }
        return totalPrice;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.TotalPrice.setText("Your bag total is ฿ " + getTotalPrice());
        if (!product.isEmpty()) {
            myListener = new MyListener() {
                @Override
                public void onClickListener(ProductApple productApple, int quantity) {
                    addToCart(productApple, quantity);
                }
            };
        }
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < product.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/Main/Product.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                ProductController productController = fxmlLoader.getController();
                productController.setData(product.get(i), myListener);

                if (column == 4) {
                    column = 0;
                    row++;
                }

                gridPane.add(anchorPane, column++, row);
                gridPane.setMinWidth(Region.USE_COMPUTED_SIZE);
                gridPane.setPrefWidth(Region.USE_COMPUTED_SIZE);
                gridPane.setMaxWidth(Region.USE_PREF_SIZE);
                gridPane.setMinHeight(Region.USE_COMPUTED_SIZE);
                gridPane.setPrefHeight(Region.USE_COMPUTED_SIZE);
                gridPane.setMaxHeight(Region.USE_PREF_SIZE);
                GridPane.setMargin(anchorPane, new Insets(32));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
