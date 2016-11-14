package fr.thales;

import java.util.Set;
import java.util.stream.Collectors;

public class Joueurs {

	public static String afficherTrigrammes(Set<Joueur> joueurs) {
		
		return joueurs.stream().map(j -> j.getTrigram()).collect(Collectors.joining("|"));

	}

}
