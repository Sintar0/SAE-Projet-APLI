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

    private static Controleur controleur;

    static {
        try {
            controleur = new Controleur();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public VBoxRoot(){
        getChildren().addAll(gridPaneAPLI);
    }
    public static Controleur getControleur(){
        return controleur;
    }


}

