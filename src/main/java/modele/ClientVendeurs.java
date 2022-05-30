package modele;

import java.io.File;
import java.io.IOException;
import modele.LectureEcriture.*;

import static modele.LectureEcriture.*;
import static modele.Scenario.acheteurs;
import static modele.Scenario.vendeurs;

public class ClientVendeurs {
    public static void main (String [] args) throws IOException {
        File listeVendeurs = new File("src/main/java/ressources/membres_APLI.txt");
        File villes = new File("src/main/java/ressources/distances.txt");
        System.out.println(lectureVendeurs(listeVendeurs));
        System.out.println(getVilleVendeur("Arbok"));
        System.out.println(lectureVille(villes));
        System.out.println(getDistance(getVilleVendeur("Kokiyas"), getVilleVendeur("Chenipan")));
        System.out.println(getDistance("Lyon", "Paris"));

        File scenario0 = new File("src/main/java/ressources/scenario_0.txt");
        System.out.println(lectureScenario(scenario0));
    }


}

