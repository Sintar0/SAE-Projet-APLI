package modele;

import java.io.*;
import java.util.*;

/**
 * Classe contenant toutes les méthodes concernant la lecture et l'écriture des fichiers
 */
public class LectureEcriture implements ConstantesVille {
    public static HashMap<String,Integer> ville = new HashMap<>();
    public static HashMap<String,String> vendeurs = new HashMap<>();

    public static Scenario lectureScenario (File fichier) throws IOException{
        Scenario scenario = new Scenario();

        BufferedReader bufferEntree = new BufferedReader(new FileReader(fichier));
        String ligne;

        StringTokenizer tokenizer;
        do{
            ligne = bufferEntree.readLine();
            if (ligne != null){
                tokenizer = new StringTokenizer(ligne, " ->");
                String tokenV = tokenizer.nextToken();
                String tokenA = tokenizer.nextToken();
                scenario.ajoutVendeurAcheteur(tokenV, tokenA);
            }
        }
        while (ligne != null);
        bufferEntree.close();
        return scenario;
    }

    /**
     * Cette méthode lit un fichier et lie une ville avec son index
     * @param fichier
     * @return Une HashMap contenant les villes (clé : ville , valeur : index)
     * @throws IOException
     */
    public static Map lectureVille(File fichier) throws IOException {
        BufferedReader bufferEntree = new BufferedReader(new FileReader(fichier));
        LineNumberReader readerLigne = new LineNumberReader(bufferEntree);
        String ligne;

        StringTokenizer tokenizer;
        do{
            ligne = readerLigne.readLine();
            int numeroLigne = readerLigne.getLineNumber() -1;
            if (ligne != null){
                tokenizer = new StringTokenizer(ligne, " :");
                String tokenVille = tokenizer.nextToken();
                ville.put(tokenVille,numeroLigne);
            }
        }
        while (ligne != null);
        bufferEntree.close();
        return ville;
    }

    /**
     * Cette méthode récupère les informations d'un fichier distance et le transforme sous forme d'un tableau 2D
     * @param fichier --> fichier à lire pour la récupération des distances
     * @return un tableau en deux dimensions contenant les distances
     * @throws IOException
     */

    /*
    public static int [][] lectureDistances(File fichier) throws IOException{
        BufferedReader bufferEntree = new BufferedReader(new FileReader(fichier));
        LineNumberReader readerLigne = new LineNumberReader(bufferEntree); //récupération du numéro de ligne
        String ligne = "";

        StringTokenizer tokenizer;
        do{
            for (int i = 0 ; i < 29 ; i++){
                ligne = readerLigne.readLine();
                int numeroLigne = readerLigne.getLineNumber() -1; // commence à 1 par défaut. Or, on veut commencer à 0
                if (ligne != null){
                    tokenizer = new StringTokenizer(ligne, " ");
                    String tokenDistances = tokenizer.nextToken();
                        tabDistances[numeroLigne][i] = Integer.parseInt(tokenDistances); //Récupération des tokens sous forme de int
                }
            }
        }
        while (ligne != null);
        bufferEntree.close();
        return tabDistances;
    }
*/
    /**
     * Cette méthode retourne la distance entre deux villes
     * @param ville1 --> première ville pour le calcul de la distance
     * @param ville2 --> deuxième ville
     * @return distance entre ville1 et ville2 récupérée dans tabDistances
     */
    public static int getDistance(String ville1, String ville2) {
        return TAB_DISTANCES[ville.get(ville1)][ville.get(ville2)];
    }

    public static HashMap<String, String> lectureVendeurs(File fichier) throws IOException{
        BufferedReader bufferEntree = new BufferedReader(new FileReader(fichier));

        String ligne;

        StringTokenizer tokenizer;
        do{
            ligne = bufferEntree.readLine();
            if (ligne != null){
                tokenizer = new StringTokenizer(ligne, " ");
                while(tokenizer.hasMoreTokens()){
                    String tokenMembres = tokenizer.nextToken();
                    vendeurs.put(tokenMembres, tokenizer.nextToken());
                }
            }
        }
        while (ligne != null);
        bufferEntree.close();
        return vendeurs;
    }

    public static String getVilleVendeur(String vendeur){
        return vendeurs.get(vendeur);
    }

    /*
    public static void ecritureScenario (String nomFichier, Scenario scenario) throws IOException{
        PrintWriter sortie = new PrintWriter(new BufferedWriter(new FileWriter(nomFichier)));
        int i = 0;
        for (String vendeur : scenario.getVendeurs()){
            sortie.println(vendeur + " -> " + scenario.getAcheteurs().get(i));
            i++;
        }
        sortie.close();
    }
     */
}
