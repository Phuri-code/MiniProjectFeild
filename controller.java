//timer
import java.util.Timer;
import java.util.TimerTask;
// import java.util.Scanner;
///import java.util.TimerTask;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class controller {

    @FXML
    private Button button_submit;

    @FXML
    private ChoiceBox<String> choicebox_1;

    @FXML
    private ChoiceBox<String> choicebox_2;

    @FXML
    private ChoiceBox<String> choicebox_3;

    @FXML
    private Label label_clock;

    @FXML
    private Label label_result;

    @FXML
    void on_submit(ActionEvent event) {
        String choice1 = choicebox_1.getValue();
        String choice2 = choicebox_2.getValue();
        String choice3 = choicebox_3.getValue();

        int score = 0;
        if (choice1 == "class") {
            score += 1;
        }
        if (choice2 == "string") {
            score += 1;
        }
        if (choice3 == "system") {
            score += 1;
        }

        label_result.setText("You selected: " + choice1 + ", " + choice2 + ", " + choice3);
        label_result.setText("Your score : " + score + "/3");

    }

    @FXML
    void initialize(){
        choicebox_1.setValue("select");
        choicebox_1.getItems().addAll("class", "string", "system");

        choicebox_2.setValue("select");
        choicebox_2.getItems().addAll("class", "string", "system");

        choicebox_3.setValue("select");
        choicebox_3.getItems().addAll("class", "string", "system");

        startTimer();
    }

     public void startTimer() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            int seconds = 120;

            @Override
            public void run() {
                if (seconds > 0) {
                    int current = seconds/60;
                    int current_sec = seconds%60;
                    Platform.runLater(() -> label_clock.setText(current + "m" + current_sec + "s"));
                    seconds--;
                } else {
                    Platform.runLater(() -> label_clock.setText("Time's up!"));
                    timer.cancel();
                }
            }
        }, 0, 1000);
    }       
    
}
