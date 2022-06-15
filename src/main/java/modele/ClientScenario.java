package modele;

import java.io.File;
import java.io.IOException;

import static modele.LectureEcriture.*;

public class ClientScenario extends Scenario {
    public static void main(String [] args) throws IOException {
        File scenario0 = new File("src/main/java/ressources/scenario_1_1.txt");
        File listeVendeurs = new File("src/main/java/ressources/membres_APLI.txt");
        File villes = new File("src/main/java/ressources/distances.txt");
        lectureScenario(scenario0);
        lectureVendeurs(listeVendeurs);
        System.out.println(lectureVille(villes));
        long startTime = System.currentTimeMillis();
        System.out.println(lectureDistance());
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) + " ms");
    }
}