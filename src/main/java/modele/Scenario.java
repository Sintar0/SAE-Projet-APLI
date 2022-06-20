package modele;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Scenario extends LectureEcriture {
    static List<String> vendeurs;
    static List<String> acheteurs;

    public Scenario() {
        vendeurs = new ArrayList<>();
        acheteurs = new ArrayList<>();
    }

    public void ajoutVendeurAcheteur(String vendeur, String acheteur) {
        vendeurs.add(vendeur);
        acheteurs.add(acheteur);
    }

    public List<String> getVendeurs() {
        return vendeurs;
    }

    public List<String> getAcheteurs() {
        return acheteurs;
    }


    /**
     * Cette méthode retourne la distance calculé pour un scénario choisi
     * @param fichierScenario
     * @return somme des distances entre les villes du chemin
     * @throws IOException
     */
    public static int lectureDistance(File fichierScenario) throws IOException {
        lectureScenario(fichierScenario);
        lectureVendeurs(new File("src/main/java/ressources/membres_APLI.txt"));
        lectureVille(new File("src/main/java/ressources/distances.txt"));
        TreeMap<String, ArrayList<String>> voisinsSortants = new TreeMap<>();
        TreeMap<String, Integer> degresEntrants = new TreeMap<>();
        ArrayList<String> ordreGraph = new ArrayList<>();
        LinkedList<String> ordreParfait = new LinkedList<>();
        int sum = 0;

        for (int i = 0; i < vendeurs.size(); i++) {
            voisinsSortants.computeIfAbsent(vendeurs.get(i), k -> new ArrayList<>()).add(acheteurs.get(i));
        }


        Set<String> entrySet = voisinsSortants.keySet();
        String source;
        Iterator<String> it = entrySet.iterator();

        if (!entrySet.equals(it.next())) {
            source = it.next();
            ordreGraph.add(source);

            while (it.hasNext()) {
                source = it.next();
                ordreGraph.add(source);
            }
            for (int j = 0; j < voisinsSortants.size();j++){
                if(acheteurs.get(j)!=vendeurs.get(j))
                    ordreGraph.add(acheteurs.get(j));
            }
        }
        System.out.println(ordreGraph);

        for(int s=0;s<ordreGraph.size()-1;s++)
        {
            for(int m=s + 1;m<ordreGraph.size();m++)
            {

                if(ordreGraph.get(s) != null && ordreGraph.get(s).equals(ordreGraph.get(m)))
                {
                    ordreGraph.set(m, null);
                }
            }
        }
        for (int p = 0;p<ordreGraph.size();p++){
            if(ordreGraph.get(p)!="null");
            ordreParfait.add(ordreGraph.get(p));
            ordreParfait.remove(null);
        }
        ordreParfait.addFirst("Camion");
        ordreParfait.addLast("Camion");
        for(int c = 0; c<ordreParfait.size();c++){
            ordreParfait.set(c, LectureEcriture.getVilleVendeur(ordreParfait.get(c)));
        }

        System.out.println(ordreParfait);
        System.out.println(voisinsSortants);
        int i = 0;
        int j = 1;
        while (i < ordreParfait.size() - 1){
            sum += getDistance(ordreParfait.get(i), ordreParfait.get(j));
            i++;
            j++;
        }
        return sum ;
    }

    /**
     * Utilise le résultat de la méthode lectureDistance pour établir un chemin entre les villes écrit sous la même forme que les scénarios
     * @return cheminPropre --> StringBuilder
     */
    public static StringBuilder getChemin (){
        TreeMap<String, ArrayList<String>> voisinsSortants = new TreeMap<>();
        ArrayList<String> ordreGraph = new ArrayList<>();
        LinkedList<String> ordreParfait = new LinkedList<>();
        StringBuilder cheminPropre = new StringBuilder();

        for (int i = 0; i < vendeurs.size(); i++) {
            voisinsSortants.computeIfAbsent(vendeurs.get(i), k -> new ArrayList<>()).add(acheteurs.get(i));
        }


        Set<String> entrySet = voisinsSortants.keySet();
        String source;
        Iterator<String> it = entrySet.iterator();

        if (!entrySet.equals(it.next())) {
            source = it.next();
            ordreGraph.add(source);

            while (it.hasNext()) {
                source = it.next();
                ordreGraph.add(source);
            }
            for (int j = 0; j < voisinsSortants.size();j++){
                if(acheteurs.get(j)!=vendeurs.get(j))
                    ordreGraph.add(acheteurs.get(j));
            }
        }
        System.out.println(ordreGraph);

        for(int s=0;s<ordreGraph.size()-1;s++)
        {
            for(int m=s + 1;m<ordreGraph.size();m++)
            {

                if(ordreGraph.get(s) != null && ordreGraph.get(s).equals(ordreGraph.get(m)))
                {
                    ordreGraph.set(m, null);
                }
            }
        }
        for (int p = 0;p<ordreGraph.size();p++){
            if(ordreGraph.get(p)!="null");
            ordreParfait.add(ordreGraph.get(p));
            ordreParfait.remove(null);
        }
        ordreParfait.addFirst("Camion");
        ordreParfait.addLast("Camion");
        for(int c = 0; c<ordreParfait.size();c++){
            ordreParfait.set(c, LectureEcriture.getVilleVendeur(ordreParfait.get(c)));
        }

        for(int s = 0 ; s< ordreParfait.size()-1; s++){
            cheminPropre.append(ordreParfait.get(s)).append(" ->").append(ordreParfait.get(s+1)).append("\n");
        }

        return new StringBuilder("Vous pouvez emprunter ce chemin :" + "\n" + cheminPropre);
    }
        public String toString () {
            return vendeurs + "\n" + acheteurs;
        }

    }

