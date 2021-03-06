package controleur;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.RadioMenuItem;
import modele.LectureEcriture;
import modele.Scenario;
import vue.GridPaneAPLI;
import vue.mainApplication;

import java.io.File;
import java.io.IOException;

public class Controleur extends GridPaneAPLI implements EventHandler {
    File scenarioChoix = new File("src/main/java/ressources/scenario_0.txt");
    Label scenarioChoixLabel;
    RadioMenuItem scenario1Item = mainApplication.Scenario1Item;
    RadioMenuItem scenario2Item = mainApplication.Scenario2Item;
    RadioMenuItem scenario3Item = mainApplication.Scenario3Item;
    RadioMenuItem distanceItem = mainApplication.distanceItem;
    RadioMenuItem membreItem = mainApplication.membreItem;
    RadioMenuItem helpScenarioItem = mainApplication.helpScenarioItem;
    RadioMenuItem helpRessourceItem = mainApplication.helpRessourceItem;
    public Controleur() throws IOException {
        EventHandler<ActionEvent> event = actionEvent -> {
            if (scenario1Item.isSelected()){
                scenarioChoix = new File("src/main/java/ressources/scenario_0.txt");
                try {
                    LectureEcriture.lectureScenario(scenarioChoix);
                    scenarioChoixLabel = new Label(LectureEcriture.lectureFichierScenario(scenarioChoix).toString());
                    scenario.setText(scenarioChoixLabel.getText());

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (scenario2Item.isSelected()){
                scenarioChoix = new File("src/main/java/ressources/scenario_1_1.txt");
                try {
                    LectureEcriture.lectureScenario(scenarioChoix);
                    scenarioChoixLabel = new Label(LectureEcriture.lectureFichierScenario(scenarioChoix).toString());
                    scenario.setText(scenarioChoixLabel.getText());

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (scenario3Item.isSelected()){
                scenarioChoix = new File("src/main/java/ressources/scenario_2_1.txt");
                try {
                    LectureEcriture.lectureScenario(scenarioChoix);
                    scenarioChoixLabel = new Label(LectureEcriture.lectureFichierScenario(scenarioChoix).toString());
                    scenario.setText(scenarioChoixLabel.getText());

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            Label distanceChemin = new Label();
            try {
                distanceChemin = new Label(Scenario.lectureDistance(scenarioChoix) + " km");
            } catch (IOException e) {
                e.printStackTrace();
            }
            Label itineraire = new Label(Scenario.getChemin().toString());
            totalKM.setText(distanceChemin.getText());
            chemin.setText(itineraire.getText());
        };
        EventHandler<ActionEvent> eventMembres = actionEvent -> {
            try {
                Label labelMembres = new Label(LectureEcriture.lectureFichierMembres().toString());
                scenario.setText(labelMembres.getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
        };

        EventHandler<ActionEvent> eventDistances = actionEvent -> {
            try {
                Label labelDistances = new Label(LectureEcriture.lectureFichierDistances().toString());
                scenario.setText(labelDistances.getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
        };

        EventHandler<ActionEvent> eventHelpScenario = actionEvent -> {
            Label labelAideScenario = new Label("""
                    Ce menu contient tous les sc??narios sous la forme de fichiers texte
                
                    Cette zone de texte affiche le sc??nario choisi""");
            Label labelKM = new Label("Affiche le kilom??trage");
            Label labelChemin = new Label("Indique le chemin ?? prendre");

            scenario.setText(labelAideScenario.getText());
            chemin.setText(labelChemin.getText());
            totalKM.setText(labelKM.getText());
        };

        EventHandler<ActionEvent> eventHelpRessource = actionEvent -> {
            Label aideMembresDistances = new Label("""
                    Ce menu contient deux options :\s
                     - une pour les membres\s
                     - une pour les distances\s

                     Les options seront affich??es dans cette zone de texte""");
            scenario.setText(aideMembresDistances.getText());
        };
        calculer.setOnAction(event);
        distanceItem.setOnAction(eventDistances);
        membreItem.setOnAction(eventMembres);
        helpRessourceItem.setOnAction(eventHelpRessource);
        helpScenarioItem.setOnAction(eventHelpScenario);
    }

    @Override
    public void handle(Event event) {

    }

}





