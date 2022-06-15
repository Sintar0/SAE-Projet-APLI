package modele;

import java.lang.reflect.Array;
import java.util.*;

import modele.LectureEcriture;

import static modele.LectureEcriture.*;

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
                    // ordreGraph = ArrayUtils.removeElement(ordreGraph, ordreGraph[s]); --m;??
                    ordreGraph.set(m, null); // Mark for deletion later on
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
        return sum;
    }

        public String toString () {
            return vendeurs + "\n" + acheteurs;
        }

    }

