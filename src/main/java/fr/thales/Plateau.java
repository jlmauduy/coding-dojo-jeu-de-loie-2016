package fr.thales;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Plateau {

	private List<Case> cases;
	private Set<Joueur> joueurs = new LinkedHashSet<Joueur>();

	public Plateau() {
		cases = new LinkedList<Case>();

		cases.add(new Case("Depart"));
		for (int i = 1; i < 37; i++) {
			cases.add(new Case(String.valueOf(i)));
		}
	}

	public List<Case> getCases() {

		return cases;
	}

	public void ajouterJoueur(Joueur joueur) {
		joueur.setPosition(0);
		joueurs.add(joueur);
	}

	public Set<Joueur> getListeJoueurs() {
		return joueurs;
	}

	public String afficher() {
		StringBuilder builder = new StringBuilder();

		for (int indexCase = 0; indexCase < cases.size(); indexCase++) {
			builder.append(cases.get(indexCase).afficher(getListeJoueursSurLaCase(indexCase)));
		}
		return builder.toString();
	}

	private Set<Joueur> getListeJoueursSurLaCase(int numeroCase) {

		Set<Joueur> mList = new LinkedHashSet<Joueur>();
		Iterator<Joueur> mJoueurIterator = joueurs.iterator();
		while (mJoueurIterator.hasNext()) {
			Joueur joueur = mJoueurIterator.next();
			if (numeroCase == joueur.getPosition()) {
				mList.add(joueur);
			}
		}
		return mList;
	}

}
