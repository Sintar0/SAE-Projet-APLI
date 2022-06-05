package vue;

import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class GridPaneAPLI extends GridPane {
    protected TextArea chemin = new TextArea();
    protected Button calculer = new Button("Calculer");
    AnchorPane apLeft = new AnchorPane();
    protected TextField totalKM = new TextField("KM total");
    AnchorPane apRight = new AnchorPane();
    protected HBox boxButton = new HBox();

    public GridPaneAPLI(){
        setGridLinesVisible(true);

        this.add(chemin, 1, 1, 1 ,1);
        this.add(calculer,1,1);
        this.add(totalKM, 1, 1,1,1);
        this.add(boxButton, 1, 2);
        apLeft.getChildren().add(calculer);
        apRight.getChildren().add(totalKM);
        boxButton.getChildren().addAll(apLeft,apRight);
        boxButton.setSpacing(265);
    }

}

