package fr.thales.main;

import fr.thales.Joueur;
import fr.thales.JoueurInconnuException;
import fr.thales.PasAToiDeJouerException;
import fr.thales.Plateau;
import fr.thales.PlateauImpl;
import fr.thales.PlateauRandom;

public class AffichageJeuDeLoie {

	public static void main(String[] args) {
		Plateau plateau = new PlateauRandom();
		Joueur joueur1 = new Joueur("Jean-Loic", "JLM");
		plateau.ajouterJoueur(joueur1);

		while (!plateau.getGagnant().isPresent()) {
			try {
				plateau.jouer(joueur1);
			} catch (PasAToiDeJouerException e) {
				System.out.println("Ce n'est pas à vous de jouer!");
			} catch (JoueurInconnuException e) {
				System.out.println( e.getMessage() );
			}
			System.out.println(plateau.afficher());
		}
		
		Joueur joueurGagnant = plateau.getGagnant().get();
		System.out.println("Youpi !! "+joueurGagnant.getTrigram()+" a gagné");
	}
}
