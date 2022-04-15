package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;

public class mainApplication extends Application {
    public void start(Stage stage) {
        HboxRoot root = new HboxRoot();
        Scene scene = new Scene(root, 500, 500);
        File css = new File("css" + File.separator + "premiersStyles.css");
        scene.getStylesheets().add(css.toURI().toString());

        stage.setScene(scene);
        stage.setTitle("Calendrier du mois");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch();
    }
}
