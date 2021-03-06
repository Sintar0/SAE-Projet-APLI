package vue;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

    public GridPaneAPLI() throws IOException {
        this.add(scenario, 2, 1, 1, 1);
        this.add(chemin, 1, 1, 1, 1);
        this.add(calculer, 1, 1);
        this.add(totalKM, 1, 1, 1, 1);
        this.add(boxButton, 1, 2);
        apLeft.getChildren().add(calculer);
        apRight.getChildren().add(totalKM);
        boxButton.getChildren().addAll(apLeft, apRight);
        boxButton.setSpacing(275);

        File scenario0 = new File("src/main/java/ressources/scenario_0.txt");
        Label scenario0Label = new Label(LectureEcriture.lectureFichierScenario(scenario0).toString());

        scenario.setText(scenario0Label.getText());
        Label rappelBouton = new Label("Cliquez sur calculer pour afficher le chemin ainsi que la distance totale");
        chemin.setText(rappelBouton.getText());
    }
}


