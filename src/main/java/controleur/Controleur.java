package controleur;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.RadioMenuItem;
import vue.GridPaneAPLI;

public class Controleur extends GridPaneAPLI implements EventHandler  {
    @Override
    public void handle(Event event) {
        if (event.getSource() instanceof Button){
            System.out.println("test");
        }
        if (event.getSource() instanceof RadioMenuItem){
            //if ()
        }
    }
}
