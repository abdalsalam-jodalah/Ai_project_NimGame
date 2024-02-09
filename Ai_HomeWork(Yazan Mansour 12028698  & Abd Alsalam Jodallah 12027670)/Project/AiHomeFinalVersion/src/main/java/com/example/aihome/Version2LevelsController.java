package com.example.aihome;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Version2LevelsController implements Initializable {


    @FXML
    private VBox Levels;
    @FXML
    private Button Easy;

    @FXML
    private Button Hard;


    @FXML
    private Button Medium;
    @FXML
    private TextField sticks;
    @FXML
    private TextField playerName;
    @FXML
    private Stage stage;
    private Scene scene;


    private Parent root;
    int value=0;
    String level;
    @FXML
    private ChoiceBox<String> choicebox;


    private String[] e={"PC","Player"};

    @FXML
    protected void onButtonsClickOpenGame(ActionEvent e) throws IOException {
        if(!choicebox.getSelectionModel().isEmpty()) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Version2Game.fxml"));


            Version2GameController  gameController = new Version2GameController();
            gameController.number(value);
            gameController.setLevel(level);
            gameController.getPlayerName(playerName.getText());
            gameController.whoStart(choicebox.getSelectionModel().getSelectedItem().toString());
            loader.setController(gameController);


            root = loader.load();

            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else{
            choicebox.setStyle("-fx-border-color: red;-fx-background-radius:10px");
        }

        // Set the controller for the loader

    }

    public void initialize(URL url, ResourceBundle resourceBundle) {

        choicebox.getItems().addAll(e);

    }


    @FXML
    protected void GoBack(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Versions.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    protected boolean checkValue(){
        sticks.setStyle("-fx-border-color: black ;-fx-border-width: 0px 0px 2px 0px; -fx-background-color: transparent;");

        try{
            value= Integer.parseInt(sticks.getText());
            if(value>15 || value<2){
                value=-1;
            }

        }
        catch (Exception ex){
            value=-1;
        }
        if(value!=-1){
            return true;
        }
        else {
            sticks.setStyle("-fx-border-color:red ;-fx-border-width: 0px 0px 2px 0px; -fx-background-color: transparent;");
            return false;
        }

    }

    @FXML
    protected void easyMode(ActionEvent e) throws IOException {

        if(checkValue()){
            level="Easy";
            onButtonsClickOpenGame(e);

        }
        else {
            sticks.setStyle("-fx-border-color:red ;-fx-border-width: 0px 0px 2px 0px; -fx-background-color: transparent;");

        }


    }
    @FXML
    protected void mediumMode(ActionEvent e) throws IOException{
        if(checkValue()){
            level="Medium";
            onButtonsClickOpenGame(e);

        }
        else {
            sticks.setStyle("-fx-border-color:red ;-fx-border-width: 0px 0px 2px 0px; -fx-background-color: transparent;");

        }
    }
    @FXML
    protected void hardMode(ActionEvent e) throws IOException{
        if(checkValue()){
            level="Hard";
            onButtonsClickOpenGame(e);

        }
        else {
            sticks.setStyle("-fx-border-color:red ;-fx-border-width: 0px 0px 2px 0px; -fx-background-color: transparent;");

        }
    }

}
