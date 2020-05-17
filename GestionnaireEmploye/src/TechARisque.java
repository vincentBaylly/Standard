
public class TechARisque extends Technicien implements IRisque {
 
    public TechARisque(String prenom, String nom, int age, String date, int unites) {
        super(prenom, nom, age, date, unites);
    }
 
    public double calculerSalaire() {
        return super.calculerSalaire() + PRIME;
    }
}