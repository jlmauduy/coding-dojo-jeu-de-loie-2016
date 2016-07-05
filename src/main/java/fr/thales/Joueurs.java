package fr.thales;

import java.util.Iterator;
import java.util.Set;

public class Joueurs {

	public static String afficherTrigrammes(Set<Joueur> joueurs) {
		StringBuilder builder = new StringBuilder();

		Iterator<Joueur> iterator = joueurs.iterator();
		while (iterator.hasNext()) {
			Joueur joueur = (Joueur) iterator.next();
			builder.append(joueur.getTrigram());
			if (iterator.hasNext()) {
				builder.append("|");
			}
		}
		return builder.toString();
	}

}
