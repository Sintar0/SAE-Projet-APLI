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


            // Sort the array 'arr' elements in ascending order
            // using nested for loops


            System.out.println(voisinsSortants);
            return sum;


        }

        public String toString () {
            return vendeurs + "\n" + acheteurs;
        }

    }

