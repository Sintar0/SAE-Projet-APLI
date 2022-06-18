package vue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import modele.*;

import java.io.File;
import java.io.IOException;

public class GridPaneAPLI extends GridPane {
    protected TextArea chemin = new TextArea();
    protected TextArea scenario = new TextArea();
    protected Button calculer = new Button("Calculer");
    AnchorPane apLeft = new AnchorPane();
    protected TextField totalKM = new TextField("KM total");
    AnchorPane apRight = new AnchorPane();
    protected HBox boxButton = new HBox();

    public GridPaneAPLI(){
        this.add(scenario, 2,1,1,1);
        this.add(chemin, 1, 1, 1 ,1);
        this.add(calculer,1,1);
        this.add(totalKM, 1, 1,1,1);
        this.add(boxButton, 1, 2);
        apLeft.getChildren().add(calculer);
        apRight.getChildren().add(totalKM);
        boxButton.getChildren().addAll(apLeft,apRight);
        boxButton.setSpacing(275);

        calculer.setOnAction(event);
    }
    EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            File scenario0 = new File("src/main/java/ressources/scenario_1_1.txt");
            File listeVendeurs = new File("src/main/java/ressources/membres_APLI.txt");
            File villes = new File("src/main/java/ressources/distances.txt");
            try {
                LectureEcriture.lectureScenario(scenario0);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                LectureEcriture.lectureVendeurs(listeVendeurs);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                LectureEcriture.lectureVille(villes);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(Scenario.lectureDistance());
        }
    };


}

