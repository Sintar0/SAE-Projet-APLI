package vue;

import controleur.Controleur;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class mainApplication extends Application {
    public RadioMenuItem scenario_0Item = new RadioMenuItem("Scénario 0");
    public RadioMenuItem scenario_1_1Item = new RadioMenuItem("Scénario 1_1");
    public RadioMenuItem scenario_1_2Item = new RadioMenuItem("Scénario 1_2");
    public RadioMenuItem scenario_2_1Item = new RadioMenuItem("Scénario 2_1");
    public RadioMenuItem scenario_2_2Item = new RadioMenuItem("Scénario 2_2");
    public RadioMenuItem MembreItem = new RadioMenuItem("Membre APLI");
    @Override
    public void start(Stage stage) {
        //  MenuBar
        MenuBar menuBar = new MenuBar();
        VBoxRoot mainVBox = new VBoxRoot();

        //  menus
        Menu fileMenu = new Menu("Scénario");
        Menu editMenu = new Menu("Ressource");
        Menu helpMenu = new Menu("Help");

        // Create MenuItems

        ToggleGroup choixScenario = new ToggleGroup();
        scenario_0Item.setToggleGroup(choixScenario);
        scenario_1_1Item.setToggleGroup(choixScenario);
        scenario_1_2Item.setToggleGroup(choixScenario);
        scenario_2_1Item.setToggleGroup(choixScenario);
        scenario_2_2Item.setToggleGroup(choixScenario);
        scenario_0Item.setSelected(true);

        RadioMenuItem distanceItem = new RadioMenuItem("Distance");
        RadioMenuItem membreItem = new RadioMenuItem("Membre");
        ToggleGroup choixRessource = new ToggleGroup();
        distanceItem.setToggleGroup(choixRessource);
        membreItem.setToggleGroup(choixRessource);


        fileMenu.getItems().addAll(scenario_0Item, scenario_1_1Item, scenario_1_2Item, scenario_2_1Item, scenario_2_2Item);
        editMenu.getItems().addAll(distanceItem, membreItem);

        menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu);

        VBox root = new VBox(menuBar,mainVBox);

        Scene scene = new Scene(root, 500, 500);

        stage.setScene(scene);
        stage.setTitle("Navigation APLI");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }



}


