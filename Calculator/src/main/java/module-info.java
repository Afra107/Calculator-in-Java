module assignment.calculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.scripting;


    opens assignment.calculator to javafx.fxml;
    exports assignment.calculator;
}