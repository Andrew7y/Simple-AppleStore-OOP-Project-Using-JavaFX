package Main;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class AppleStore implements Initializable {

    @FXML
    private ComboBox<Integer> comboBox;
    @FXML
    private ImageView ProductImageLabel;
    @FXML
    private Label ProductNameLabel;
    @FXML
    private Label ProductPriceLabel;
    @FXML
    private VBox chosenProductCard;
    @FXML
    private GridPane gridPane;
    @FXML
    private TextField searchText;
    private List<ProductApple> productApples = new ArrayList<>();
    private Image image;
    private MyListener myListener;
    private double priceOfProduct;
    private Stage stage;
    private Scene scene;

    public void SwitchToBag(MouseEvent Event) throws IOException {
        Parent shoppingCartRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Main/ShoppingCart.fxml")));
        this.stage = (Stage)((Node)Event.getSource()).getScene().getWindow();
        this.scene = new Scene(shoppingCartRoot);
        stage.setScene(this.scene);
        stage.show();
    }

    private void setChosenProduct(ProductApple productApple) {
        ProductNameLabel.setText(productApple.getName());
        ProductPriceLabel.setText("฿" + productApple.getPrice());
        image = new Image(Objects
                .requireNonNull(getClass()
                .getResource(productApple
                .getImgSrc()))
                .toExternalForm(), false);
        ProductImageLabel.setImage(image);
        chosenProductCard.setStyle("-fx-background-color: #eeeeee" + ";\n" +
                "    -fx-background-radius: 15;");
        this.priceOfProduct = productApple.getPrice();
    }

    public void setCart(ActionEvent event){
        ShoppingCartController sp = new ShoppingCartController();
        for(ProductApple PA : productApples){
            if(this.ProductNameLabel.getText().equals(PA.getName())){
                sp.addToCart(PA, comboBox.getValue());

            }
        }
    }

    public void searchProduct(ActionEvent event) {
        for (ProductApple PA : productApples) {
            if (this.searchText.getText().equalsIgnoreCase(PA.getName())) {
                setChosenProduct(PA);
                comboBox.setValue(1);
            }
        }
    }

    protected List<ProductApple> getData() {
        List<ProductApple> productApples = new ArrayList<>();
        ProductApple productApple;

        productApple = new ProductApple();
        productApple.setName("iPhone 14");
        productApple.setPrice(32900.00);
        productApple.setImgSrc("/Image/Iphone14.png");
        productApples.add(productApple);

        productApple = new ProductApple();
        productApple.setName("iPhone 12");
        productApple.setPrice(24900.00);
        productApple.setImgSrc("/Image/Iphone12.png");
        productApples.add(productApple);

        productApple = new ProductApple();
        productApple.setName("iPhone SE");
        productApple.setPrice(17900.00);
        productApple.setImgSrc("/Image/IphoneSE_3.png");
        productApples.add(productApple);

        productApple = new ProductApple();
        productApple.setName("iPhone 14 Pro");
        productApple.setPrice(41900.00);
        productApple.setImgSrc("/Image/Iphone14Pro.png");
        productApples.add(productApple);

        productApple = new ProductApple();
        productApple.setName("Macbook Pro M2");
        productApple.setPrice(89900.00);
        productApple.setImgSrc("/Image/MacbookProM2.png");
        productApples.add(productApple);

        productApple = new ProductApple();
        productApple.setName("Macbook Air M2");
        productApple.setPrice(43900.00);
        productApple.setImgSrc("/Image/Macbook_Air_M2.png");
        productApples.add(productApple);

        productApple = new ProductApple();
        productApple.setName("Macbook Pro M1");
        productApple.setPrice(34900.00);
        productApple.setImgSrc("/Image/MacbookProM1.png");
        productApples.add(productApple);

        productApple = new ProductApple();
        productApple.setName("iPad Pro");
        productApple.setPrice(32900.00);
        productApple.setImgSrc("/Image/Ipad_Pro_M2.png");
        productApples.add(productApple);

        productApple = new ProductApple();
        productApple.setName("iPad Gen10");
        productApple.setPrice(17900.00);
        productApple.setImgSrc("/Image/Ipad_Gen10.png");
        productApples.add(productApple);

        productApple = new ProductApple();
        productApple.setName("iPad Gen9");
        productApple.setPrice(12900.00);
        productApple.setImgSrc("/Image/Ipad_Gen9.png");
        productApples.add(productApple);

        productApple = new ProductApple();
        productApple.setName("Apple Watch Ultra");
        productApple.setPrice(31900.00);
        productApple.setImgSrc("/Image/Apple_Watch_Ultra.png");
        productApples.add(productApple);

        productApple = new ProductApple();
        productApple.setName("Apple Watch Series8");
        productApple.setPrice(15900.00);
        productApple.setImgSrc("/Image/Apple_Watch_SE3.png");
        productApples.add(productApple);

        productApple = new ProductApple();
        productApple.setName("AirPods Max");
        productApple.setPrice(19900.00);
        productApple.setImgSrc("/Image/airpods_max.png");
        productApples.add(productApple);

        productApple = new ProductApple();
        productApple.setName("AirPods Pro");
        productApple.setPrice(5290.00);
        productApple.setImgSrc("/Image/AirpodPro.png");
        productApples.add(productApple);

        return productApples;

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        productApples.addAll(getData());
        if (!productApples.isEmpty()) {
            setChosenProduct(this.productApples.get(0));
            myListener = new MyListener() {
                @Override
                public void onClickListener(ProductApple productApple, int quantity) {
                    setChosenProduct(productApple);
                    comboBox.setValue(1);
                }
            };
        }

        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < productApples.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/Main/Product.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ProductController productController = fxmlLoader.getController();
                productController.setData(productApples.get(i),myListener);

                if (column == 3) {
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
                GridPane.setMargin(anchorPane, new Insets(10));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        comboBox.setItems(FXCollections.observableArrayList(1,2,3,4,5,6,7,8));
        comboBox.setValue(1);
        comboBox.valueProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                int selectedNumber = newVal;
                double priceValue = selectedNumber * this.priceOfProduct;
                ProductPriceLabel.setText("฿" + priceValue);
            }
        });
    }

}