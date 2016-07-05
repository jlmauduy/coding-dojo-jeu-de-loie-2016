package fr.thales;

import java.util.Set;

// TODO ajouter un test et l'utiliser dans la classe Plateau
public class CaseDepart extends Case {

	@Override
	public String getNom() {
		return "Depart";
	}

	@Override
	public String afficher(Set<Joueur> listeJoueurs) {
		if (listeJoueurs.isEmpty()) {
			return "[D]";
		} else {
			return super.afficher(listeJoueurs);
		}
	}

}
