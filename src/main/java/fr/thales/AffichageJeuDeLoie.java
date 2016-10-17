package fr.thales;

public class AffichageJeuDeLoie {

	public static void main(String[] args) {
		Plateau plateau = new PlateauImpl();
		Joueur joueur1 = new Joueur("Jean-Loic", "JLM");
		plateau.ajouterJoueur(joueur1);

		while (plateau.getGagnant() == null) {
			try {
				plateau.jouer(joueur1);
			} catch (PasAToiDeJouerException e) {
				System.out.println("Ce n'est pas à vous de jouer!");
			}
			System.out.println(plateau.afficher());
		}
		
		Joueur joueurGagnant = plateau.getGagnant();
		System.out.println("Youpi !! "+joueurGagnant.getTrigram()+" a gagné");
	}
}
