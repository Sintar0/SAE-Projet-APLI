package modele;

import java.util.*;


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
        ArrayList<String> chemin = new ArrayList<>();
        int sum = 0;

        for (int i = 0 ; i < vendeurs.size() ; i++) { //remplissage de voisinsSortants
            voisinsSortants.computeIfAbsent(vendeurs.get(i), k -> new ArrayList<>()).add(acheteurs.get(i));
        }
        for (String key : voisinsSortants.keySet()){ // remplissage de degresEntrants
            int occurences = 0; //permet de réinitialiser la valeur de occurences à 0 en changeant de pokémon
            for (ArrayList<String> value : voisinsSortants.values()){
                if (value.contains(key)){ //ajoute 1 à occurences quand on trouve le pokémon dans une liste
                    occurences++;
                }
            }
            degresEntrants.put(key, occurences);
        }

        System.out.println(voisinsSortants);
        System.out.println(degresEntrants);
        return sum;
    }
    public String toString(){
        return vendeurs + "\n" + acheteurs;
    }

}