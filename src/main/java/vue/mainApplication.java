package vue;

import controleur.Controleur;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.controlsfx.control.action.Action;

public class mainApplication extends Application {
    public RadioMenuItem Scenario1Item = new RadioMenuItem("Scénario 1");
    public RadioMenuItem Scenario2Item = new RadioMenuItem("Scénario 2");
    public RadioMenuItem Scenario3Item = new RadioMenuItem("Scénario 3");
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
        Scenario1Item.setToggleGroup(choixScenario);
        Scenario2Item.setToggleGroup(choixScenario);
        Scenario3Item.setToggleGroup(choixScenario);
        Scenario1Item.setSelected(true);

        RadioMenuItem distanceItem = new RadioMenuItem("Distance");
        RadioMenuItem membreItem = new RadioMenuItem("Membre");
        ToggleGroup choixRessource = new ToggleGroup();
        distanceItem.setToggleGroup(choixRessource);
        membreItem.setToggleGroup(choixRessource);


        fileMenu.getItems().addAll(Scenario1Item, Scenario2Item, Scenario3Item, MembreItem);
        editMenu.getItems().addAll(distanceItem, membreItem);

        menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu);

        Controleur controlerVBox = VBoxRoot.getControleur();

        VBox root = new VBox(menuBar,mainVBox);

        Scene scene = new Scene(root, 500, 500);




        stage.setScene(scene);
        stage.setTitle("Navigation APLI");
        stage.show();
    }
    EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {

        }
    };
    public static void main(String[] args) {
        Application.launch(args);
    }



}


