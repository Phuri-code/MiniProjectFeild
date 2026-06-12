import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        // Get FXML file
        URL url = getClass().getResource("view.fxml");

        // Load FXML
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        // Create Scene
        Scene scene = new Scene(root, 300, 275);

        // Set Stage
        stage.setTitle("Hello World");
        stage.setScene(scene);
        stage.show();
    }
}