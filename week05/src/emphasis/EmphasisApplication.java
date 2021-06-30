package emphasis;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Example JavaFX application.
 */
public class EmphasisApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Emphasis");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("EmphasisView.fxml"));

        Parent root = loader.load();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
