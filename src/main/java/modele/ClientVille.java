package modele;

import java.io.File;
import java.io.IOException;


public class ClientVille extends Ville {
    public static void main(String [] args) throws IOException {
        File villes = new File("src/main/java/ressources/distances.txt");
        System.out.println(lectureVille(villes));
    }
}
