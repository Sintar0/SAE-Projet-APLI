package modele;

import java.util.ArrayList;
import java.util.List;
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
        int sum = 0;
        for (int indexVend = 0; indexVend < vendeurs.size() ; indexVend++){
            System.out.println("ETAPE" + " " + indexVend);
            sum += getDistance(getVilleVendeur(acheteurs.get(indexVend)), getVilleVendeur(vendeurs.get(indexVend)));
            System.out.println(sum);
        }
        return sum;
    }
    public String toString(){
        return vendeurs + "\n" + acheteurs;
    }

}