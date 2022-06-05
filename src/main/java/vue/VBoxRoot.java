package vue;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


public class VBoxRoot extends VBox {
    private static GridPaneAPLI gridPaneAPLI = new GridPaneAPLI();
    private static BorderPane menuAPLI = new BorderPane();
    public VBoxRoot() {
        getChildren().add(gridPaneAPLI);
        getChildren().add(menuAPLI);
    }
}
