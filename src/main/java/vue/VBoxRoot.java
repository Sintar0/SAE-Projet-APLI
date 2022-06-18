package vue;

import controleur.Controleur;
import javafx.scene.layout.VBox;

import java.io.IOException;


public class VBoxRoot extends VBox {
    private static GridPaneAPLI gridPaneAPLI;
    static {
        try {
            gridPaneAPLI = new GridPaneAPLI();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Controleur controleur = new Controleur();
    public VBoxRoot(){
        getChildren().addAll(gridPaneAPLI);
    }
    public static Controleur getControleur(){
        return controleur;
    }
    public static GridPaneAPLI getScenarioPane(){
        return gridPaneAPLI;
    }

}

