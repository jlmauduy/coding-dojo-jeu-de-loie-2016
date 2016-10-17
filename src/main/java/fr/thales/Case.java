package fr.thales;

import java.util.Set;

public class Case {
	private String nom;
	private final String etatInitial;

	public Case(String nom, String etatInitial) {
		this.nom = nom;
		this.etatInitial = etatInitial;
	}

	public Case() {
		this("Defaut", "");
	}

	public String getNom() {
		return this.nom;
	}

	public String afficher(Set<Joueur> listeJoueurs) {
		StringBuilder builder = new StringBuilder();

		builder.append("[");
		
		if (listeJoueurs == null || listeJoueurs.isEmpty()) {
			builder.append(etatInitial);
		} else {
			builder.append(Joueurs.afficherTrigrammes(listeJoueurs));
		}
		
		builder.append("]");

		return builder.toString();
	}
	
	public int getNextPosition(int targetPosition) {
		return targetPosition;
	}
	
	public boolean isARejouer(){
		return false;
	}
}
