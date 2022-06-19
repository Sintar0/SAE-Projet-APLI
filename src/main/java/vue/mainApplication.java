package vue;

import controleur.Controleur;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modele.LectureEcriture;
import org.controlsfx.control.action.Action;
import modele.*;

import java.io.File;
import java.io.IOException;

import static modele.LectureEcriture.lectureScenario;

public class mainApplication extends Application {
    public static RadioMenuItem Scenario1Item = new RadioMenuItem("Scénario 1");
    public static RadioMenuItem Scenario2Item = new RadioMenuItem("Scénario 2");
    public static RadioMenuItem Scenario3Item = new RadioMenuItem("Scénario 3");
    public static RadioMenuItem distanceItem = new RadioMenuItem("Distance");
    public static RadioMenuItem membreItem = new RadioMenuItem("Membre");
    public static RadioMenuItem helpScenarioItem = new RadioMenuItem("Aide menu scénario");
    public static RadioMenuItem helpRessourceItem = new RadioMenuItem("Aide ressources");

    @Override
    public void start(Stage stage) throws IOException {

        //  MenuBar
        MenuBar menuBar = new MenuBar();
        VBoxRoot mainVBox = new VBoxRoot();

        //  menus
        Menu fileMenu = new Menu("Scénario");
        Menu editMenu = new Menu("Ressource");
        Menu helpMenu = new Menu("Help");

        // Create MenuItems
        ToggleGroup choixScenario = new ToggleGroup();
        Scenario1Item.setToggleGroup(choixScenario);
        Scenario2Item.setToggleGroup(choixScenario);
        Scenario3Item.setToggleGroup(choixScenario);
        Scenario1Item.setSelected(true);



        ToggleGroup choixRessource = new ToggleGroup();
        distanceItem.setToggleGroup(choixRessource);
        membreItem.setToggleGroup(choixRessource);

        ToggleGroup choixAide = new ToggleGroup();
        helpScenarioItem.setToggleGroup(choixAide);
        helpRessourceItem.setToggleGroup(choixAide);

        fileMenu.getItems().addAll(Scenario1Item, Scenario2Item, Scenario3Item);
        editMenu.getItems().addAll(distanceItem, membreItem);
        helpMenu.getItems().addAll(helpScenarioItem,helpRessourceItem);
        menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu);

        Controleur controlerVBox = VBoxRoot.getControleur();

        VBox root = new VBox(menuBar, controlerVBox);

        Scene scene = new Scene(root, 965, 245);
        stage.setMinHeight(245);
        stage.setMinWidth(965);

        stage.setScene(scene);
        stage.setTitle("Navigation APLI");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}


