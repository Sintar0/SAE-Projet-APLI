package modele;

import java.io.*;
import java.util.*;

public class LectureEcriture implements ConstantesVille {
    public static HashMap<String,Integer> ville = new HashMap<>();
    public static int [][] tabDistances = new int [28][28];
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

    /*
    public static int [][] lectureDistances(File fichier) throws IOException{
        BufferedReader bufferEntree = new BufferedReader(new FileReader(fichier));
        LineNumberReader readerLigne = new LineNumberReader(bufferEntree);
        String ligne;

        StringTokenizer tokenizer;
        do{
            for (int i = 0 ; i < 29 ; i++){
                ligne = readerLigne.readLine();
                int numeroLigne = readerLigne.getLineNumber() -1;
                if (ligne != null){
                    tokenizer = new StringTokenizer(ligne, " ");
                    String tokenDistances = tokenizer.nextToken();
                    tabDistances[numeroLigne][i] = Integer.parseInt(tokenDistances);
                }
            }
        }
        while (ligne != null);
        bufferEntree.close();
        return tabDistances;
    }
    */
    public static int getDistance(String ville1, String ville2){
        return TAB_DISTANCES[ville.get(ville1)][ville.get(ville2)];
    }

    public static void ecritureScenario (String nomFichier, Scenario scenario) throws IOException{
        PrintWriter sortie = new PrintWriter(new BufferedWriter(new FileWriter(nomFichier)));
        int i = 0;
        for (String vendeur : scenario.getVendeurs()){
            sortie.println(vendeur + " -> " + scenario.getAcheteurs().get(i));
            i++;
        }
        sortie.close();
    }
}
