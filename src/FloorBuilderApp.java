import javafx.application.Application;
import java.awt.event.ActionEvent;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FloorBuilderApp extends Application {
    public static final String[]    ROOM_COLORS =
            {"ORANGE", "YELLOW", "LIGHTGREEN", "DARKGREEN",         "LIGHTBLUE", "BLUE", "CYAN", "DARKCYAN",         "PINK", "DARKRED", "PURPLE", "GRAY"};

    public void start(Stage primaryStage) {
        colorButton.setOnAction(new EventHandler<ActionEvent>(){
                                    public void handle (ActionEvent actionEvent){
                                        colorButton.setStyle( "-fx-base:" + );
                                    }

                                }
                radiobutton1[i].setOnAction(new EventHandler<ActionEvent>(){

        }

    }
    // Find the number of the button that was clicked

    public void handle(ActionEvent event) {
        int buttonNumber = 0;
        for (buttonNumber = 0; buttonNumber < 4; buttonNumber++) {
            if (buttons[buttonNumber] == event.getSource())
                break;
        }
        int n = 0;
        switch (buttonNumber) {
            case 0: n++; if(n /2 == 0), n / 2 == 1break;
            case 1:break;
            case 2:break;
            case 3:break;

        }
    }

}
