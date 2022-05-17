package modele;

import java.io.File;
import java.io.IOException;


import static modele.LectureEcriture.lectureVille;


public class ClientVille {
    public static void main(String [] args) throws IOException {
        File villes = new File("src/main/java/ressources/distances.txt");
        System.out.println(lectureVille(villes));
    }
}
