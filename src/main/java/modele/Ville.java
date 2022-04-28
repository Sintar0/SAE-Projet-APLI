package modele;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Ville {
    public static Map lectureVille(File fichier) throws IOException {
        Map<String,Integer> ville = new HashMap<>();
        BufferedReader bufferEntree = new BufferedReader(new FileReader(fichier));
        LineNumberReader readerLigne = new LineNumberReader(bufferEntree);
        String ligne;

        StringTokenizer tokenizer;
        do{
            ligne = readerLigne.readLine();
            int numeroLigne = readerLigne.getLineNumber();
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

}

