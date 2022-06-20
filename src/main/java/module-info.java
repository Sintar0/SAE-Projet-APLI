module vue {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.security.jgss;
    requires org.testng;
    requires org.junit.jupiter.api;

    opens vue to javafx.fxml;
    exports vue;
    exports modele;
    opens modele to javafx.fxml;
}