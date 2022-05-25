package modele;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static modele.LectureEcriture.*;


public class ClientVille {
    public static void main(String [] args) throws IOException {
        File villes = new File("src/main/java/ressources/distances.txt");
        //File distancesVille = new File("src/main/java/ressources/distancesville.txt");
        System.out.println(lectureVille(villes));

        //System.out.println(Arrays.deepToString(lectureDistances(distancesVille)));
        System.out.println(getDistance("Velizy", "Velizy"));


    }
}
