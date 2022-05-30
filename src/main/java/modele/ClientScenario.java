package modele;

import java.io.File;
import java.io.IOException;

import static modele.LectureEcriture.*;

public class ClientScenario extends Scenario {
    public static void main(String [] args) throws IOException {
        File scenario0 = new File("src/main/java/ressources/scenario_0.txt");
        System.out.println(lectureScenario(scenario0));
        System.out.println(lectureDistance());
    }
}