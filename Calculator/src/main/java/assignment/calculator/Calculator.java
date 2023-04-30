// Afra, 415007, BSCS-12-C
// Assignment # 02: Basic Calculator

package assignment.calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.util.Objects;

public class Calculator extends Application {

    // Main Method
    public static void main(String[] args) {
        launch(args);
    }

    // Overridden 'start' Method
    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Calculator.fxml")));
        Scene scene=new Scene(root);

        // Setting Icon and Title
        stage.setTitle("Calculator");
        Image icon= new Image("C:\\Users\\AFRA\\Pictures\\calculator.jpg");
        stage.getIcons().add(icon);

        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}
