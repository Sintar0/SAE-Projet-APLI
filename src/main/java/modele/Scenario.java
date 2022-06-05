package modele;

import java.lang.reflect.Array;
import java.util.*;

import modele.LectureEcriture;

import static modele.LectureEcriture.getDistance;
import static modele.LectureEcriture.getVilleVendeur;

public class Scenario {
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


    public static int lectureDistance() {
        TreeMap<String, ArrayList<String>> voisinsSortants = new TreeMap<>();
        TreeMap<String, Integer> degresEntrants = new TreeMap<>();
        ArrayList ordreGraph = new ArrayList<String>();
        LinkedList<String> ordreParfait = new LinkedList<>();
        int sum = 0;
        for (int i = 0; i < vendeurs.size(); i++) {
            voisinsSortants.computeIfAbsent(vendeurs.get(i), k -> new ArrayList<>()).add(acheteurs.get(i));
        }


        Set entrySet = voisinsSortants.keySet();
        String source = new String("null");
        String source2 = new String("null");
        Iterator it = entrySet.iterator();
        if (it.next() != voisinsSortants.entrySet()) {
            source = (String) it.next();
            ordreGraph.add(source);
            while (it.hasNext()) {
                source = (String) it.next();
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
                    // ordreGraph = ArrayUtils.removeElement(ordreGraph, ordreGraph[s]); --m;??
                    ordreGraph.set(m, null); // Mark for deletion later on
                }
            }
        }
        for (int p = 0;p<ordreGraph.size();p++){
            if(ordreGraph.get(p)!="null");
            ordreParfait.add((String) ordreGraph.get(p));
        }
        ordreParfait.addFirst("Camion");
        ordreParfait.addLast("Camion");

        for(int c = 0; c<ordreParfait.size();c++)
            getVilleVendeur(ordreParfait.get(c));


        System.out.println(ordreGraph);
        System.out.println(ordreParfait);
        System.out.println(voisinsSortants);

        return sum;


    }

        public String toString () {
            return vendeurs + "\n" + acheteurs;
        }

    }

