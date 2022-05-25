package modele;

import java.io.File;
import java.io.IOException;
import modele.LectureEcriture.*;

import static modele.LectureEcriture.*;

public class ClientVendeurs {
    public static void main (String [] args) throws IOException {
        File listeVendeurs = new File("src/main/java/ressources/membres_APLI.txt");
        File villes = new File("src/main/java/ressources/distances.txt");
        System.out.println(lectureVendeurs(listeVendeurs));
        System.out.println(getVilleVendeur("Arbok"));
        System.out.println(lectureVille(villes));
        System.out.println(getDistance(getVilleVendeur("Aquali"), getVilleVendeur("Sulfura")));
        System.out.println(getDistance("Grenoble", "Lille"));
    }
}
