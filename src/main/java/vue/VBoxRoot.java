package vue;

import javafx.scene.layout.VBox;


public class VBoxRoot extends VBox {
    private static GridPaneAPLI gridPaneAPLI = new GridPaneAPLI();
    public VBoxRoot() {
        getChildren().addAll(gridPaneAPLI);
    }
}
