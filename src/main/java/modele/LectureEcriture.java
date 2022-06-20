package modele;

import java.io.*;
import java.util.*;

/**
 * Classe contenant toutes les méthodes concernant la lecture et l'écriture des fichiers
 */
public class LectureEcriture implements ConstantesVille {
    public static HashMap<String,Integer> ville = new HashMap<>();
    public static HashMap<String,String> mapVendeurs = new HashMap<>();

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


    /**
     * Cette méthode retourne la distance entre deux villes
     * @param ville1 --> première ville pour le calcul de la distance
     * @param ville2 --> deuxième ville
     * @return distance entre ville1 et ville2 récupérée dans tabDistances
     */
    public static int getDistance(String ville1, String ville2) {
        return TAB_DISTANCES[ville.get(ville1)][ville.get(ville2)];
    }

    /**
     * Cette méthode récupère les vendeurs de l'APLI liés avec leur ville
     * @param fichier : Fichier membres_APLI.txt
     * @return mapVendeurs : dictionnaire avec le vendeur en clé et la ville en valeur
     * @throws IOException
     */
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
                    mapVendeurs.put(tokenMembres, tokenizer.nextToken());
                }
            }
        }
        while (ligne != null);
        bufferEntree.close();
        return mapVendeurs;
    }

    /**
     * Cette méthode récupère la ville d'un vendeur spécifique --> nécessite une exécution de lectureVendeurs au préalable
     * @param vendeur : nom du vendeur
     * @return ville du vendeur
     */
    public static String getVilleVendeur(String vendeur){
        return mapVendeurs.get(vendeur);
    }

    /**
     * Lit le fichier scénario tel qu'il est écrit pour pouvoir le montrer sur l'interface graphique
     * @param fichier
     * @return scénario_xxx.txt tel quel
     * @throws IOException
     */
    public static StringBuilder lectureFichierScenario(File fichier) throws IOException {
        BufferedReader bufferEntree = new BufferedReader(new FileReader(fichier));

        String ligne;

        StringTokenizer tokenizer;
        String token = null;

        StringBuilder resultat = new StringBuilder();
        do {
            ligne = bufferEntree.readLine();
            if (ligne != null) {
                tokenizer = new StringTokenizer(ligne);

                while (tokenizer.hasMoreTokens()) {
                    token = tokenizer.nextToken();
                    if (tokenizer.countTokens() == 2){
                        resultat.append("\n");
                    }
                    resultat.append(token);

                }
            }
        }
        while (ligne != null);
        bufferEntree.close();
        return resultat;
    }

    /**
     *
     * @return
     * @throws IOException
     */
    public static StringBuilder lectureFichierMembres() throws IOException {
        BufferedReader bufferEntree = new BufferedReader(new FileReader("src/main/java/ressources/membres_APLI.txt"));

        String ligne;

        StringTokenizer tokenizer;
        String token = null;

        StringBuilder resultat = new StringBuilder();
        do {
            ligne = bufferEntree.readLine();
            if (ligne != null) {
                tokenizer = new StringTokenizer(ligne);

                while (tokenizer.hasMoreTokens()) {
                    token = tokenizer.nextToken();
                    resultat.append(" ");
                    if (tokenizer.countTokens() == 1){
                        resultat.append("\n");
                    }
                    resultat.append(token);

                }
            }
        }
        while (ligne != null);
        bufferEntree.close();
        return resultat;
    }

    /**
     * @return
     * @throws IOException
     */
    public static StringBuilder lectureFichierDistances() throws IOException {
        BufferedReader bufferEntree = new BufferedReader(new FileReader("src/main/java/ressources/distances.txt"));

        String ligne;

        StringTokenizer tokenizer;
        String token = null;

        StringBuilder resultat = new StringBuilder();
        do {
            ligne = bufferEntree.readLine();
            if (ligne != null) {
                tokenizer = new StringTokenizer(ligne);

                while (tokenizer.hasMoreTokens()) {
                    token = tokenizer.nextToken();
                    resultat.append(" ");
                    if (tokenizer.countTokens() == 30){
                        resultat.append("\n");
                    }
                    resultat.append(token);

                }
            }
        }
        while (ligne != null);
        bufferEntree.close();
        return resultat;
    }

}
