package vue;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;

public class mainApplication extends Application {
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
        RadioMenuItem Senario1Item = new RadioMenuItem("Scénario 1");
        RadioMenuItem Senario2Item = new RadioMenuItem("Scénario 2");
        RadioMenuItem Senario3Item = new RadioMenuItem("Scénario 3");
        RadioMenuItem MembreItem = new RadioMenuItem("Membre APLI");
        ToggleGroup choixScenario = new ToggleGroup();
        Senario1Item.setToggleGroup(choixScenario);
        Senario2Item.setToggleGroup(choixScenario);
        Senario3Item.setToggleGroup(choixScenario);
        Senario1Item.setSelected(true);

        RadioMenuItem distanceItem = new RadioMenuItem("Distance");
        RadioMenuItem membreItem = new RadioMenuItem("Membre");
        ToggleGroup choixRessource = new ToggleGroup();
        distanceItem.setToggleGroup(choixRessource);
        membreItem.setToggleGroup(choixRessource);


        fileMenu.getItems().addAll(Senario1Item, Senario2Item, Senario3Item, MembreItem);
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


