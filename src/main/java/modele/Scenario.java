package modele;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

import modele.LectureEcriture;

import static modele.LectureEcriture.getDistance;
import static modele.LectureEcriture.getVilleVendeur;

public class Scenario{
    static List<String> vendeurs;
    static List<String> acheteurs;

    public Scenario(){
        vendeurs = new ArrayList<>();
        acheteurs = new ArrayList<>();
    }

    public void ajoutVendeurAcheteur(String vendeur, String acheteur){
        vendeurs.add(vendeur);
        acheteurs.add(acheteur);
    }

    public List<String> getVendeurs(){
        return vendeurs;
    }

    public List<String> getAcheteurs(){
        return acheteurs;
    }


    public static int lectureDistance() {
        TreeMap<String, ArrayList<String>> voisinsSortants = new TreeMap<>();
        TreeMap<String, Integer> degresEntrants = new TreeMap<>();
        int sum = 0;

        for (int i = 0 ; i < vendeurs.size() ; i++) {
            voisinsSortants.computeIfAbsent(vendeurs.get(i), k -> new ArrayList<>()).add(acheteurs.get(i));
        }
        for (int i = 0 ; i < voisinsSortants.size() ; i++){
            for (ArrayList<String> value : voisinsSortants.values()){
//                int occurrences = Collections.frequency(value, i);
//                System.out.println(occurences);
            }
        }
        System.out.println(voisinsSortants);
        return sum;
    }
    public String toString(){
        return vendeurs + "\n" + acheteurs;
    }

}