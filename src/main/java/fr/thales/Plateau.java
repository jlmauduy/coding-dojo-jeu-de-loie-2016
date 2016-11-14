package fr.thales;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface Plateau {

	List<Case> getCases();

	void ajouterJoueur(Joueur joueur);

	Set<Joueur> getListeJoueurs();

	String afficher();

	int jouer(Joueur joueur) throws PasAToiDeJouerException, JoueurInconnuException;

	Optional<Joueur> getGagnant();

}