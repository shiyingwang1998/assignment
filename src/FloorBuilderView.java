import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.awt.*;
import java.awt.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import java.lang.String;
public class FloorBuilderView extends GridPane {
    private RadioButton[] radiobutton1;
    private  Button[][] buttons;
    private GridPane aPane;
    private Label label1;
    private Label label2;
    private Label label3;
    private TextField summaryField;
    private Button buildingButton;
    private Button colorButton;
    //get method
    public Button getColorButton(){
        return this.colorButton;
    }
    public void start(Stage primaryStage){
        aPane = new GridPane();
        buttons = new Button[20][20];
        for(int row=0; row<20; row++) {
            for (int col = 0; col < 20; col++) {
                buttons[row][col] = new Button();
                buttons[row][col].relocate(10 + col * 70, 10 + row * 70);
                buttons[row][col].setPrefSize(65, 65);
            }
        }
        FloorPlan fp = new FloorPlan(20, "Main Floor");
        int[][] tiles = {
                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                        {1,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,1},
                        {1,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,1},
                        {1,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,1},
                        {1,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,1},
                        {1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1},
                        {1,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,1},
                        {1,0,0,0,0,0,1,0,0,0,1,1,1,1,0,1,1,1,1,1},
                        {1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1},
                        {1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1},
                        {1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1},
                        {1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1},
                        {1,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,1},
                        {1,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,1},
                        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1},
                        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1},
                        {1,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,1},
                        {1,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,1},
                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};

        for (int r=0; r<20; r++){
            for (int c=0; c<20; c++) {
                fp.setWallAt(r, c, tiles[r][c] == 1);
                if(tiles[r][c] == 1){
                    buttons[r][c].setStyle( "-fx-base: BLACK;");
                }else{
                    buttons[r][c].setStyle( "-fx-base: WHITE;");
                }
            }
        }
        buttons[0][8].setStyle("-fx-font: 22 arial; -fx-base: RED; -fx-text-fill: WHITE;");
        buttons[0][8].setText("EXIT");
        buttons[9][19].setStyle("-fx-font: 22 arial; -fx-base: RED; -fx-text-fill: WHITE;");
        buttons[9][19].setText("EXIT");
        buttons[19][5].setStyle("-fx-font: 22 arial; -fx-base: RED; -fx-text-fill: WHITE;");
        buttons[19][5].setText("EXIT");

        aPane.setPadding(new Insets(10,10,10,10));
//the labels at the top of each pane
        Label label1 = new Label("FLOOR LAYOUT");
        aPane.add(label1,0,0);
        Label label2 = new Label("SELECT/EDIT");
        aPane.add(label2, 3, 0);
        Label label3 = new Label("FLOOR SUMMARY");
        aPane.add(label3,0,3);
//radio buttons
        ToggleGroup operations = new ToggleGroup();
        radiobutton1 = new RadioButton[4];
        String[] buttonLabels = {"Walls", "Exits", "Room Tiles", "Select Room"};
        for (int i=0; i<4; i++) {
            radiobutton1[i] = new RadioButton(buttonLabels[i]);
            radiobutton1[i].relocate(160, 60 + i*20);
            radiobutton1[i].setPrefSize(150, 20);
            aPane.getChildren().add(radiobutton1[i]);
            radiobutton1[i].setToggleGroup(operations);


                                       // This is the single event handler for all of the radio buttons

        }

        Button buildingButton = new Button("Building Overview");
        buildingButton.relocate(10,50);
        buildingButton.setPrefSize(90, 30);
        aPane.getChildren().add(buildingButton);
        Button colorButton = new Button();
        colorButton.relocate(400,250);
        colorButton.setPrefSize(50,50);
        colorButton.setStyle("-fx-base:LIGHT ORANGE");
        colorButton.setDisable(true);
//textfield
        TextField summaryField = new TextField();
        summaryField.relocate(10,350);
        summaryField.setPrefSize(400,50);
        summaryField.setEditable(true);
        summaryField.setPromptText("Main Floor with 0 rooms");
        aPane.getChildren().add(summaryField);

        primaryStage.setTitle("Floor Plan Builder");
        primaryStage.setResizable(true);
        primaryStage.setScene(new Scene(aPane,600,500));
        primaryStage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
