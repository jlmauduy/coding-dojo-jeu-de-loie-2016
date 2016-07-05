package fr.thales;

import java.util.Set;

public class Case {
	private String nom;

	public Case(String nom) {
		this.nom = nom;
	}

	public Case() {
		this("Defaut");
	}

	public String getNom() {
		return this.nom;
	}

	public String afficher(Set<Joueur> listeJoueurs) {
		StringBuilder builder = new StringBuilder();

		builder.append("[");
		if (getNom().equals("Depart") && listeJoueurs.isEmpty()) {
			builder.append("D");
		} else {
			builder.append(Joueurs.afficherTrigrammes(listeJoueurs));
		}
		builder.append("]");

		return builder.toString();
	}



}
