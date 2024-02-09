package com.example.aihome;

import VersionTwoBackend.MNode;
import VersionTwoBackend.Tree;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import static VersionTwoBackend.Game.*;

public class Version2GameController implements Initializable {
    public static int Rows;
    String playerName;
    String whoStarts;
    String level;
    @FXML
    private Stage stage;
    private Scene scene;
    @FXML
    private ScrollPane scroll;
    @FXML
    private static Button pcMoveButton;

    @FXML
    ImageView imageView=new ImageView();
    @FXML

    private Parent root;
    @FXML
    private Label numberSticks;
    @FXML
    private Label levelLabel;
    @FXML
    private Label group1Label;
    @FXML
    private Label group2Label;
    @FXML
    private Label stateLabel;
    @FXML
    private Label playerNameLabel;
    @FXML
    private Button currentGame;
    @FXML
    private Button moveButton;
    @FXML
    private AnchorPane anc;
    @FXML
    private HBox mainHbox;

    @FXML
    private Button home;
    @FXML
    private Button playAgain;
    @FXML
    private Button levels;
    @FXML
    private static VBox vbox=new VBox();
    @FXML
    private static VBox buttonsVbox=new VBox();
    public static int globalID=0;


    @FXML
    private ImageView currentGameArrow;
    @FXML
    private ImageView levelsArrow;
    @FXML
    private ImageView homeArrow;
    @FXML
    private StackPane stackP;
    @FXML
    private ImageView playAgainArrow;

    @FXML
    private TextField group1;

    @FXML
    private TextField group2;

    @FXML
    private static AnchorPane groupsAnchor=new AnchorPane();
    static int toggleFlag=0;

    @FXML
    private  AnchorPane mainAnc;
    @FXML
    private  AnchorPane anchorButtons;
    @FXML
    private  AnchorPane mainAnc1;
    @FXML
    private  AnchorPane currentSelectedAnc;
    static List<HBox> hBoxList = new ArrayList<>();
    static List<Boxes> globalHboxList = new ArrayList<>();
    static List<Boxes> boxes = new ArrayList<>();
    static List<Button> buttons = new ArrayList<>();
    int whoStartFlag=0;
    static int buttonIdPressed=-1;
    static int counterToDecrement=0;

    public void number(int numberOfRows){
        this.Rows=numberOfRows;
    }
    public void setLevel(String getLevel){
         level = getLevel;
    }
    public void whoStart(String start){
         whoStarts = start;
    }
    public  void getPlayerName(String name){
         playerName = name;
    }
    @FXML
    protected void CurrentButton(){
      //  setSticks();
        setRows();
        currentGameArrow.setVisible(true);
        homeArrow.setVisible(false);
        levelsArrow.setVisible(false);
        playAgainArrow.setVisible(false);
        currentGame.setStyle("-fx-background-color: white;");
        home.setStyle("/Users/yazanmansour/Downloads/AiHome/src/main/resources/CssFiles/Buttons.css");
        levels.setStyle("/Users/yazanmansour/Downloads/AiHome/src/main/resources/CssFiles/Buttons.css");
        playAgain.setStyle("/Users/yazanmansour/Downloads/AiHome/src/main/resources/CssFiles/Buttons.css");



    }
    @FXML
    protected void HomeButton(ActionEvent e) throws IOException {
        stateLabel.setText("State : ");
        currentGameArrow.setVisible(false);
        homeArrow.setVisible(true);
        levelsArrow.setVisible(false);
        playAgainArrow.setVisible(false);
        currentGame.setStyle("/Users/yazanmansour/Downloads/AiHome/src/main/resources/CssFiles/Buttons.css");
        home.setStyle("-fx-background-color: white;");
        levels.setStyle("/Users/yazanmansour/Downloads/AiHome/src/main/resources/CssFiles/Buttons.css");
        playAgain.setStyle("/Users/yazanmansour/Downloads/AiHome/src/main/resources/CssFiles/Buttons.css");



        root = FXMLLoader.load(getClass().getResource("Start.fxml"));
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();




    }

    @FXML
    protected void levelsButton(ActionEvent e) throws IOException {
        stateLabel.setText("State : ");
        currentGameArrow.setVisible(false);
        homeArrow.setVisible(false);
        levelsArrow.setVisible(true);
        playAgainArrow.setVisible(false);
        currentGame.setStyle("/Users/yazanmansour/Downloads/AiHome/src/main/resources/CssFiles/Buttons.css");
        home.setStyle("/Users/yazanmansour/Downloads/AiHome/src/main/resources/CssFiles/Buttons.css");
        levels.setStyle("-fx-background-color: white;");
        playAgain.setStyle("/Users/yazanmansour/Downloads/AiHome/src/main/resources/CssFiles/Buttons.css");
        GoBack(e);
    }
    @FXML
    protected void versionsButton(ActionEvent e) throws IOException {
        stateLabel.setText("State : ");
        currentGameArrow.setVisible(false);
        homeArrow.setVisible(false);
        levelsArrow.setVisible(false);
        playAgainArrow.setVisible(false);

        currentGame.setStyle("/Users/yazanmansour/Downloads/AiHome/src/main/resources/CssFiles/Buttons.css");
        home.setStyle("/Users/yazanmansour/Downloads/AiHome/src/main/resources/CssFiles/Buttons.css");
        levels.setStyle("-fx-background-color: white;");
        playAgain.setStyle("/Users/yazanmansour/Downloads/AiHome/src/main/resources/CssFiles/Buttons.css");
        root = FXMLLoader.load(getClass().getResource("Versions.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void GoBack(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Version2Levels.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void playAgainButton(){
        stateLabel.setText("State : ");
       // flagEnd=false;
        currentGameArrow.setVisible(false);
        homeArrow.setVisible(false);
        levelsArrow.setVisible(false);
        playAgainArrow.setVisible(true);
        vbox.getChildren().clear();
        buttonsVbox.getChildren().clear();
        boxes=new ArrayList<>();
        buttons=new ArrayList<>();
        globalHboxList=new ArrayList<>();
        treeRoot = new MNode();
        Tree.initiateTree(treeRoot, Rows);
        setRows();
        PauseTransition delay = new PauseTransition(Duration.seconds(0.7));
        delay.setOnFinished(event -> {

            currentGame.setStyle("-fx-background-color: white;");
            home.setStyle("/Users/yazanmansour/Downloads/AiHome/src/main/resources/CssFiles/Buttons.css");
            levels.setStyle("/Users/yazanmansour/Downloads/AiHome/src/main/resources/CssFiles/Buttons.css");
            playAgain.setStyle("/Users/yazanmansour/Downloads/AiHome/src/main/resources/CssFiles/Buttons.css");

            playAgainArrow.setVisible(false);
            currentGameArrow.setVisible(true);

            if(whoStarts.equals("PC")){
                whoStartFlag=1;
                toggleFlag=2;
                PauseTransition delay1 = new PauseTransition(Duration.seconds(0.3));
                delay1.setOnFinished(event1 -> {

                    List<Integer> tempList =new ArrayList<>(treeRoot.Values);

                    treeRoot= playPC(treeRoot, treeRoot.Values,level,whoStartFlag);

                    List<Integer> tempList2 = findChanges(tempList, treeRoot.Values);
                    int numberOfRow = tempList2.get(0) + 1;
                    int decrementedValue = tempList2.get(1);


                    playFromPc(numberOfRow, decrementedValue);


                });
                delay1.play();

            }
            else{
                whoStartFlag=2;
                toggleFlag=2;
            }
            playerNameLabel.setText("Welcome "+playerName);
            currentGameArrow.setVisible(true);
            currentGame.setStyle("-fx-background-color: white;");





        });
        delay.play();

        playAgainArrow.setVisible(true);
        currentGameArrow.setVisible(false);
        currentGame.setStyle("/Users/yazanmansour/Downloads/AiHome/src/main/resources/CssFiles/Buttons.css");
        home.setStyle("/Users/yazanmansour/Downloads/AiHome/src/main/resources/CssFiles/Buttons.css");
        levels.setStyle("/Users/yazanmansour/Downloads/AiHome/src/main/resources/CssFiles/Buttons.css");
        playAgain.setStyle("-fx-background-color: white;");





    }









    MNode treeRoot = new MNode();
    public void initialize(URL url, ResourceBundle resourceBundle) {
        vbox.getChildren().clear();
        buttonsVbox.getChildren().clear();
        boxes=new ArrayList<>();
        buttons=new ArrayList<>();
        globalHboxList=new ArrayList<>();
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(0,0,0,165));
        buttonsVbox.setAlignment(Pos.CENTER_RIGHT);
        buttonsVbox.setSpacing(100);
        buttonsVbox.setPadding(new Insets(35,0,0,10*Rows));
        anchorButtons.getChildren().add(buttonsVbox);
        mainAnc1.getChildren().add(vbox);
        numberSticks.setText("Number of Rows: "+Rows);
        levelLabel.setText(level);
        treeRoot = new MNode();
        Tree.initiateTree(treeRoot, Rows);


        setRows();

        if(whoStarts.equals("PC")){
            whoStartFlag=1;
            toggleFlag=2;
            PauseTransition delay = new PauseTransition(Duration.seconds(0.7));
            delay.setOnFinished(event -> {

                List<Integer> tempList =new ArrayList<>(treeRoot.Values);

                 treeRoot= playPC(treeRoot, treeRoot.Values,level,whoStartFlag);

                List<Integer> tempList2 = findChanges(tempList, treeRoot.Values);
                int numberOfRow = tempList2.get(0) + 1;
                int decrementedValue = tempList2.get(1);


                playFromPc(numberOfRow, decrementedValue);


            });
            delay.play();

        }
        else{
            whoStartFlag=2;
            toggleFlag=2;
        }
        playerNameLabel.setText("Welcome "+playerName);
        currentGameArrow.setVisible(true);
        currentGame.setStyle("-fx-background-color: white;");

    }
    @FXML
    protected void setRows(){

        for (int i = 0; i < Rows; ++i) {

            HBox globalHbox=new HBox();
            globalHbox.setSpacing(10);
            globalHbox.setPadding(new Insets(10));
            globalHbox.setAlignment(Pos.CENTER);
            globalHbox.setId(Integer.toString(globalID));
            Boxes box=new Boxes();
            box.hbox=globalHbox;
            box.hisGlobalhBoxId=globalID;
            box.value=2 * i + 1;
            boxes.add(box);

            globalID++;


            for (int k = 0; k < 2 * i + 1; ++k) {

                Image image = new Image("stick.png");
                ImageView imageView = new ImageView(image);
                imageView.setFitWidth(50);
                imageView.setFitHeight(100);
                globalHbox.getChildren().add(imageView);
            }

            Button button=new Button("Row "+(i+1));
            button.setStyle("-fx-background-radius:10px;-fx-background-color:#e2e2e2;");
            button.setId(Integer.toString(i+1));
            buttons.add(button);

            button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    buttonIdPressed=Integer.parseInt(button.getId());
                    playerMove(buttonIdPressed);
                    counterToDecrement++;

                }
            });
            buttonsVbox.getChildren().add(button);

            vbox.getChildren().add(globalHbox);



        }

    }
    protected static void  playerMove(int numberOfRow){
        toggleFlag=1;

        for(int i=0;i<Rows;i++){
          if(buttons.get(i).getId().equals(Integer.toString(numberOfRow))){

                  buttons.get(numberOfRow-1).setDisable(false);
                  boxes.get(i).hbox.getChildren().clear();
                  for (int j = 0; j < boxes.get(i).value - 1; j++) {
                      Image image = new Image("stick.png");
                      ImageView imageView = new ImageView(image);
                      imageView.setFitWidth(50);
                      imageView.setFitHeight(100);
                      boxes.get(i).hbox.getChildren().add(imageView);
                  }
                  boxes.get(i).value = boxes.get(i).value - 1;
                  if(boxes.get(i).value==0){
                      buttonsVbox.getChildren().remove(buttons.get(i));
                  }


          }
          else{
              buttons.get(i).setDisable(true);
          }

        }



    }

    @FXML
    protected void pcMove(ActionEvent e){
if(toggleFlag==1) {
    List<Integer> tempList = new ArrayList<>();
    int sum = 0;
    for (int i = 0; i < boxes.size(); i++) {
        tempList.add(boxes.get(i).value);
        sum += boxes.get(i).value;
    }
    if (sum == 1)// user won
    {
        stateLabel.setText("You Won");
        stateLabel.setVisible(true);
        stateLabel.setStyle("-fx-font-family:Academy Engraved LET;-fx-text-fill:lightgreen;");
        vbox.getChildren().add(stateLabel);

    } else {
        treeRoot = play(treeRoot, tempList, level, whoStartFlag);
        if (treeRoot.ActualSum == 1)// pc won
        {
            stateLabel.setText("You Lose");
            stateLabel.setVisible(true);
            stateLabel.setStyle("-fx-font-family:Academy Engraved LET;-fx-text-fill:red;");
            vbox.getChildren().add(stateLabel);
        }

        List<Integer> tempList2 = findChanges(tempList, treeRoot.Values);
        int numberOfRow = tempList2.get(0) + 1;
        int decrementedValue = tempList2.get(1);
        playFromPc(numberOfRow, decrementedValue);
        System.out.println("numberOfRow:" + numberOfRow);
        System.out.println("decrementedValue:" + decrementedValue);
        //after the pc play do the following for player :

        for (int i = 0; i < Rows; i++) {
            buttons.get(i).setDisable(false);
        }

    }
    toggleFlag=2;
}

    }

    protected static void playFromPc(int numberOfRow,int decrementValue){

        for(int i=0;i<Rows;i++){
            buttons.get(i).setDisable(true);
            if(buttons.get(i).getId().equals(Integer.toString(numberOfRow)))
            {
                buttons.get(numberOfRow-1).setDisable(false);
                boxes.get(i).hbox.getChildren().clear();
                for(int j=0;j<boxes.get(i).value-decrementValue;j++)
                {
                    Image image = new Image("stick.png");
                    ImageView imageView = new ImageView(image);
                    imageView.setFitWidth(50);
                    imageView.setFitHeight(100);
                    boxes.get(i).hbox.getChildren().add(imageView);
                }
                boxes.get(i).value = boxes.get(i).value - decrementValue;
                if(boxes.get(i).value==0)
                {
                    buttonsVbox.getChildren().remove(buttons.get(i));
                }
            }
        }
        for (int i = 0; i < Rows; i++) {
            buttons.get(i).setDisable(false);
        }
    }
    protected static int returnValueOfRow(int numberOfRow){
        return boxes.get(numberOfRow-1).value;
    }
    protected static int playerMovedRow(){
        return buttonIdPressed;
   }
    protected static int playerDecremented(){
        int value=counterToDecrement;
        counterToDecrement=0;
        return value;
   }


}
