package fr.thales;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class PlateauImpl implements Plateau {

	private List<Case> cases;
	private Set<Joueur> joueurs = new LinkedHashSet<Joueur>();

	private Joueur joueurCourant = null;

	PlateauImpl() {
		cases = new LinkedList<Case>();

		cases.add(new CaseDepart());

		for (int i = 1; i < 36; i++) {
			cases.add(new Case(String.valueOf(i), ""));
		}

		cases.add(new CaseArrivee());
	}

	PlateauImpl avecCaseBonus(int... casesBonus) {
		for (Integer index : casesBonus) {
			cases.remove(index.intValue());
			cases.add(index, new CaseBonus());
		}
		return this;
	}

	PlateauImpl avecCaseRetour(int... casesRetour) {
		for (Integer index : casesRetour) {
			cases.remove(index.intValue());
			cases.add(index, new CaseRetour());
		}
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.thales.Plateau#getCases()
	 */
	public List<Case> getCases() {
		return cases;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.thales.Plateau#ajouterJoueur(fr.thales.Joueur)
	 */
	public void ajouterJoueur(Joueur joueur) {
		if (joueurCourant == null) {
			joueurCourant = joueur;
		}
		joueur.setPosition(0);
		joueurs.add(joueur);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.thales.Plateau#getListeJoueurs()
	 */
	public Set<Joueur> getListeJoueurs() {
		return joueurs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.thales.Plateau#afficher()
	 */
	public String afficher() {
		StringBuilder builder = new StringBuilder();

		for (int indexCase = 0; indexCase < cases.size(); indexCase++) {
			builder.append(cases.get(indexCase).afficher(getListeJoueursSurLaCase(indexCase)));
		}
		return builder.toString();
	}

	private Set<Joueur> getListeJoueursSurLaCase(int numeroCase) {
		return joueurs.stream().filter(joueur -> (joueur.getPosition() == numeroCase))
				.collect(Collectors.toCollection(LinkedHashSet::new));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.thales.Plateau#jouer(fr.thales.Joueur)
	 */
	public int jouer(Joueur joueur) throws PasAToiDeJouerException, JoueurInconnuException {
		if (!joueur.equals(joueurCourant)) {
			throw new PasAToiDeJouerException();
		}
		int lancerDeDé = (int) (Math.random() * 6) + 1;
		jouer(joueur, lancerDeDé);
		return lancerDeDé;
	}

	void jouer(Joueur joueur, int lancerDeDé) throws PasAToiDeJouerException, JoueurInconnuException {
		if (!joueurs.contains(joueur)) {
			String name = "null";
			if (joueur != null) {
				name = joueur.getTrigram();
			}
			throw new JoueurInconnuException("Le joueur " + name + " est inconnu");
		}

		if (!joueur.equals(joueurCourant)) {
			throw new PasAToiDeJouerException();
		}
		int targetPosition = Math.min(cases.size() - 1, joueur.getPosition() + lancerDeDé);
		Case caze = cases.get(targetPosition);
		int nextPosition = Math.min(cases.size() - 1, caze.getNextPosition(targetPosition));
		caze = cases.get(nextPosition);

		joueur.setPosition(nextPosition);

		if (caze.isARejouer()) {
			jouer(joueur, 0);
		}

		// TODO gérer le cas Optional empty
		joueurCourant = getNextJoueur().get();
	}

	public Optional<Joueur> getGagnant() {
		return joueurs.stream().
				filter(j -> (j.getPosition() >= cases.size() - 1)).
				findFirst();
	}

	
	Optional<Joueur> getNextJoueur() {

		Iterator<Joueur> iterator = joueurs.iterator();
		while (iterator.hasNext()) {
			Joueur joueur = iterator.next();
			if (joueur.equals(joueurCourant)) {
				if (iterator.hasNext()) {
					return Optional.of(iterator.next());
				} else {
					return joueurs.stream().findFirst();
				}
			}
		}
		return Optional.empty();
	}

	@Override
	public String toString() {
		return afficher();
	}

}
