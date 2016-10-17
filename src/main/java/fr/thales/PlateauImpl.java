package fr.thales;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PlateauImpl implements Plateau {

	private List<Case> cases;
	private Set<Joueur> joueurs = new LinkedHashSet<Joueur>();

	private Joueur joueurCourant =null;
	
	public PlateauImpl() {
		this(new CasesSpeciales(3, 3));
	}

	@Override
	public String toString() {
		return afficher();
	}

	PlateauImpl(CasesSpeciales casesSpeciales) {
		cases = new LinkedList<Case>();

		cases.add(new CaseDepart());

		for (int i = 1; i < 36; i++) {
			cases.add(new Case(String.valueOf(i), ""));
		}

		Set<Integer> casesRetour = casesSpeciales.getCasesRetour();
		Set<Integer> casesBonus = casesSpeciales.getCasesBonus();

		for (Integer index : casesRetour) {
			cases.remove(index.intValue());
			cases.add(index, new CaseRetour());
		}

		for (Integer index : casesBonus) {
			cases.remove(index.intValue());
			cases.add(index, new CaseBonus());
		}

		cases.add(new CaseArrivee());
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
		if(joueurCourant==null){
			joueurCourant=joueur;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.thales.Plateau#jouer(fr.thales.Joueur)
	 */
	public int jouer(Joueur joueur) throws PasAToiDeJouerException {
		if (!joueur.equals(joueurCourant)) {
			throw new PasAToiDeJouerException();
		}
		int lancerDeDé = (int) (Math.random() * 6) + 1;
		jouer(joueur, lancerDeDé);
		return lancerDeDé;
	}

	void jouer(Joueur joueur, int lancerDeDé) throws PasAToiDeJouerException {
		if (!joueur.equals(joueurCourant)) {
			throw new PasAToiDeJouerException();
		}
		int targetPosition = Math.min(cases.size() - 1, joueur.getPosition() + lancerDeDé);
		Case caze = cases.get(targetPosition);
		int nextPosition = Math.min(cases.size() - 1, caze.getNextPosition(targetPosition));
		caze = cases.get(nextPosition);
		
		joueur.setPosition(nextPosition);
		
		if (caze.isARejouer()) {
			jouer (joueur, 0);
		}
		
		//TODO affecter qq part le prochain joueur
	}

	public Joueur getGagnant() {

		for (Joueur joueur : joueurs) {
			if (joueur.getPosition() >= cases.size() - 1) {
				return joueur;
			}
		}
		return null;
	}

	public Joueur getNextJoueur() {
	
		Iterator<Joueur> iterator = joueurs.iterator();
		while (iterator.hasNext()){
			Joueur joueur = iterator.next();
			if(joueur.equals(joueurCourant)){
				if(iterator.hasNext()){
					return iterator.next();
				} else {
					//TODO renvoyer le premier joueur
				}
			}
		}
		return null;
	}

}
