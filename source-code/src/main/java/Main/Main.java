package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader
                .load(Objects
                .requireNonNull(getClass()
                .getResource("/Main/AppleStore.fxml")));

        Image logo = new Image(Objects
                .requireNonNull(getClass()
                .getResourceAsStream("/Image/applelogo.png")));

        stage.getIcons().add(logo);
        stage.setTitle("Apple Store");
        stage.setScene(new Scene(root));
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}