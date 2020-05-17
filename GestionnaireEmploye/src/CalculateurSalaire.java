public class CalculateurSalaire {
	
	public static void main(String[] args){
        Personnel p = new Personnel();
        Employe vendeurPierre = new Vendeur("", "", 45, "1995", 30000);
        vendeurPierre = new Representant("Léon", "Vendtout", 25, "2001", 20000);
        try {
    		control(vendeurPierre.getPrenom());
    	}catch(ErrorEntryException e) {
    		System.out.println(e.getMessage());
    	}
        p.ajouterEmploye(vendeurPierre);
        p.ajouterEmploye(new Representant("Léon", "Vendtout", 25, "2001", 20000));
        p.ajouterEmploye(new Technicien("Yves", "Bosseur", 28, "1998", 1000));
        p.ajouterEmploye(new Manutentionnaire("Jeanne", "Stocketout", 32, "1998", 45));
        p.ajouterEmploye(new TechARisque("Jean", "Flippe", 28, "2000", 1000));
        p.ajouterEmploye(new ManutARisque("Al", "Abordage", 30, "2001", 45));
        
        p.afficherSalaires();
        System.out.println(vendeurPierre);
        System.out.println(vendeurPierre.toString());
        System.out.println("Le salaire moyen dans l'entreprise est de "
                + p.salaireMoyen() + " francs.");
 
    }
	
	public static void control(String string) throws ErrorEntryException {
		if (string.equals("") == true)
			throw new ErrorEntryException("Saisie erronee : chaine vide");
	}
 
}
