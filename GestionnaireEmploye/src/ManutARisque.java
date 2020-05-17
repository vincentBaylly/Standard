
public class ManutARisque extends Manutentionnaire implements IRisque {
 
    public ManutARisque(String prenom, String nom, int age, String date, int heures) {
        super(prenom, nom, age, date, heures);
    }
 
    public double calculerSalaire() {
        return super.calculerSalaire() + PRIME;
    }
}
