package com.example.demo1;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
public class Controller1  {
    public Label mylable;
    public Button button1;
    public TextField textField;

    private HelloController helloController;

    public void setHelloController(HelloController helloController) {
        this.helloController = helloController;
    }




    @FXML
    protected void EnterCenter()throws IOException{
        if (textField.getText().isEmpty()){
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setContentText("insert your number");
            alert.showAndWait();
       }
       else{
            Stage stage = (Stage) textField.getScene().getWindow();
             String TheCenters=textField.getText();
             helloController.setCenters(TheCenters);
             stage.close();
           }

        }

}
