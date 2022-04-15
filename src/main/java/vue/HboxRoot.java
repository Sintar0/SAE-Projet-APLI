package vue;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class HboxRoot extends HBox {
    public HboxRoot(){
        GridPaneFormulaireReservation GridPaneFormulaire = new GridPaneFormulaireReservation();
        VBoxRootTilePane Calendrier = new VBoxRootTilePane();
        getChildren().add(GridPaneFormulaire);


    }
}
