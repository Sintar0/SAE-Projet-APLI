package modele;

import java.io.File;
import java.io.IOException;

public class ClientScenario extends Scenario {
    public static void main(String [] args) throws IOException {
        File scenario0 = new File("src/main/java/ressources/scenario_0.txt");
        long startTime = System.currentTimeMillis();
        System.out.println(lectureDistance(scenario0));
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) + " ms");
    }
}