package assignment.calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {

    @FXML
    private TextField inputDisplay;
    @FXML
    private TextField outputDisplay;

    // Method to handle action of operators and numeric buttons
    // Use to take expression to be evaluated from the user
    @FXML
    void handleButtonAction(MouseEvent event) {
        Button b=(Button) event.getSource();
        inputDisplay.setText(inputDisplay.getText()+ b.getText());
        EvaluateExpression();
    }

    // Method to handle action of '=' button
    // Use to take and reuse output of expression
    @FXML
    void ExpressionOutput(MouseEvent event) {
        EvaluateExpression();
        if(outputDisplay.getText().equals(" ")) {
            outputDisplay.setText("Syntax Error!");
        }
        else {
            inputDisplay.setText(outputDisplay.getText());
            outputDisplay.clear();
        }
    }

    // Method to handle action of 'AC' button
    // Use to clear display screen
    @FXML
    void ClearAll(MouseEvent event) {
        inputDisplay.clear();
        outputDisplay.clear();
    }

    // Method to handle action of 'DEL' button
    // Use to delete last character of expression
    @FXML
    void Delete(MouseEvent event) {
        try{
            if(inputDisplay.getText().equals("Infinity"))
                inputDisplay.clear();
            else
                inputDisplay.setText(inputDisplay.getText(0,inputDisplay.getLength()-1));
        }
        catch(Exception ignored){
        }
    }

    // Method to evaluate Arithmetic expression
    void EvaluateExpression(){

        String [] array = inputDisplay.getText().split("(?<=[-+*/%])|(?=[-+*/%])");
        List<String> list = new ArrayList<>(Arrays.asList(array));
        try {
            int index;
            double num1, result, num2;
            while (list.contains("%")) {
                index = list.indexOf("%");
                num1 = Double.parseDouble(list.get(index - 1));
                result = num1 / 100;
                list.set(index, String.valueOf(result));
                list.remove(index - 1);
            }
            while (list.contains("/")) {
                index = list.indexOf("/");
                num1 = Double.parseDouble(list.get(index - 1));
                num2 = Double.parseDouble(list.get(index + 1));
                result = num1 / num2;
                list.set(index, String.valueOf(result));
                list.remove(index - 1);
                list.remove(index);
            }
            while (list.contains("*")) {
                index = list.indexOf("*");
                num1 = Double.parseDouble(list.get(index - 1));
                num2 = Double.parseDouble(list.get(index + 1));
                result = num1 * num2;
                list.set(index, String.valueOf(result));
                list.remove(index - 1);
                list.remove(index);
            }
            while (list.contains("-")) {
                index = list.indexOf("-");
                if (index==0)
                    num1 =0;
                else
                    num1 = Double.parseDouble(list.get(index - 1));
                num2 = Double.parseDouble(list.get(index + 1));
                result = num1 - num2;
                list.set(index, String.valueOf(result));
                if(index!=0) {
                    list.remove(index - 1);
                    list.remove(index);
                }
                else
                    list.remove(index + 1);
            }
            while (list.contains("+")) {
                index = list.indexOf("+");
                if (index==0)
                    num1 =0;
                else
                    num1 = Double.parseDouble(list.get(index - 1));
                num2 = Double.parseDouble(list.get(index + 1));
                result = num1 + num2;
                list.set(index, String.valueOf(result));
                if(index!=0) {
                    list.remove(index - 1);
                    list.remove(index);
                }
                else
                    list.remove(index + 1);
            }

            if (list.size() == 1)
                outputDisplay.setText(list.get(0));
            else
                outputDisplay.setText(" ");
        }
        catch (Exception e){
            outputDisplay.setText(" ");
        }
    }
}
