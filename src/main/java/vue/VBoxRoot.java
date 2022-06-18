package vue;

import controleur.Controleur;
import javafx.scene.layout.VBox;


public class VBoxRoot extends VBox {
    private static GridPaneAPLI gridPaneAPLI = new GridPaneAPLI();
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

