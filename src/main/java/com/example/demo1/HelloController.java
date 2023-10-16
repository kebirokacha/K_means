package com.example.demo1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private BubbleChart<Integer,Integer>bubblechart;
    @FXML
    private NumberAxis Xaxis,Yaxis;
    @FXML
    private TableView <tableUserr>tableUser;
    @FXML
    private TableColumn <tableUserr,Integer> Points;
    @FXML
    private TableColumn <tableUserr,Integer> ColonX,ColonY;
    @FXML
    private TextField textField1,textField,textField2,textFieldSelect;
    public String centers;
     @FXML
     private Button btnCentre,K_means,showData,selectFile,add;

     @FXML
     protected void K_means(){

         ArrayList<Point>arrayListOfPoints=new ArrayList<>();
         for (int indice=0;indice<tableUser.getItems().size();indice++){
             arrayListOfPoints.add(new Point(tableUser.getItems().get(indice).getColonX(),tableUser.getItems().get(indice).getColonY()));
         }
         K_means kMeans = new K_means( arrayListOfPoints,Integer.parseInt(getCenters()));
         kMeans.run();
         for (Point dataPoint : arrayListOfPoints) {
             System.out.println(dataPoint.getX() + ", " + dataPoint.getY() + " : Cluster " + dataPoint.getCluster());}



     }
    public void  setCenters(String TheCenters) {

         centers=TheCenters;
           }
           public String getCenters(){
                return centers;}
    @FXML
     protected void chooseCenter()  {
         try {


             FXMLLoader loader = new FXMLLoader(getClass().getResource("ChooseCentre.fxml"));
             Parent parent = loader.load();

             Scene scene = new Scene(parent);
             Stage stage=new Stage();
             stage.setScene(scene);
             Controller1 controller1 = loader.getController();
             controller1.setHelloController(this);
             stage.show();



         }catch (Exception e){
             Alert alert=new Alert(Alert.AlertType.ERROR);
             alert.setTitle("***");
             alert.showAndWait();

         }

     }
     @FXML
    protected void onHelloButtonClick()  {
         FileChooser fileChooser=new FileChooser();
         fileChooser.getExtensionFilters().addAll(
                 new FileChooser.ExtensionFilter("All Files", "*.*")
         );
         Stage stage=new Stage();
         String line="";
         String cvsSplitBy = ",";
         File selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile!=null){
         try {
             String filePath = selectedFile.getPath();
             textFieldSelect.setText(filePath);
             BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
             while ((line = bufferedReader.readLine()) != null) {
                 String[] data = line.split(cvsSplitBy);
                 tableUserr tableUserr = new tableUserr(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
                 tableUser.getItems().add(tableUserr);


             }
         }catch (Exception e){
             Alert alert=new Alert(Alert.AlertType.WARNING);
             alert.setTitle("there is a problem in yout data ");
             alert.showAndWait();
         }}
     }
    ObservableList<tableUserr> point = FXCollections.observableArrayList(

           );

    @FXML
    protected void onclik() {
         XYChart.Series<Integer,Integer>series=new XYChart.Series<>();
         series.setName("IIII");
         for (int indice=0;indice<tableUser.getItems().size();indice++){
         series.getData().add(new XYChart.Data<>(tableUser.getItems().get(indice).getColonX(),tableUser.getItems().get(indice).getColonY(),1));
         }bubblechart.getData().add(series);
    }
    @FXML
    private void add(){

       try {

           tableUserr tableUserr = new tableUserr(Integer.parseInt(textField.getText()), Integer.parseInt(textField1.getText()), Integer.parseInt(textField2.getText()));
           tableUser.getItems().add(tableUserr);
       }catch (Exception e) {
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("ERROR");
           alert.setHeaderText(null);
           alert.setContentText("Insert your data");
           alert.show();
       }
       textField.setText("");
       textField2.setText("");
       textField1.setText("");
}
@Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    Points.setCellValueFactory(new PropertyValueFactory<>("points"));
    ColonX.setCellValueFactory(new PropertyValueFactory<>("ColonX"));
    ColonY.setCellValueFactory(new PropertyValueFactory<>("ColonY"));
    tableUser.setItems(point);








    }
}