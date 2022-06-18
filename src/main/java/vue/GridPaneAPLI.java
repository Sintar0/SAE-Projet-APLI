package vue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import modele.*;
import vue.mainApplication.*;
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
            File scenario0 = new File("src/main/java/ressources/scenario_0.txt");
            File scenario_1_1 = new File("src/main/java/ressources/scenario_1_1.txt");
            File scenario_1_2 = new File("src/main/java/ressources/scenario_1_2.txt");
            File scenario_2_1 = new File("src/main/java/ressources/scenario_2_1.txt");
            File scenario_2_2 = new File("src/main/java/ressources/scenario_2_2.txt");
            File listeVendeurs = new File("src/main/java/ressources/membres_APLI.txt");
            File villes = new File("src/main/java/ressources/distances.txt");

            if (scenario_0Item.isSelected()){
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
            }
            if (scenario_1_1Item.isSelected()){
                try {
                    LectureEcriture.lectureScenario(scenario1_1);
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
            }
            if (scenario_1_2Item.isSelected()){
                try {
                    LectureEcriture.lectureScenario(scenario1_2);
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
            }
            if (scenario_2_1Item.isSelected()){
                try {
                    LectureEcriture.lectureScenario(scenario_2_1);
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
            }
            if (scenario_2_2Item.isSelected()){
                try {
                    LectureEcriture.lectureScenario(scenario_2_2);
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
            }

            Label distanceChemin = new Label(Scenario.lectureDistance());
            Label itineraire = new Label(Scenario.getChemin());
            totalKM.setText(distanceChemin.getText());
            chemin.setText(itineraire.getText());
        }
        File scenario0 = new File("src/main/java/ressources/scenario_1_1.txt");
        Label scenario1 = new Label(Scenario.lectureScenario(scenario0).toString());



    };



}


