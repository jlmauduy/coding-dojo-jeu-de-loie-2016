package fr.thales;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

// TODO renommer (ex. DispositionDePlateau ? PlateauLayout ?)
// TODO pattern builder : new PlateauImpl().avecCasesBonus(2,4,12).avecCasesRetour(3,5,7).build();
public class CasesSpeciales {

	private Set<Integer> casesBonus = new HashSet<Integer>();
	private Set<Integer> casesRetour = new HashSet<Integer>();

	public CasesSpeciales(int nbCasesBonus, int nbCasesRetour) {
		super();
		if (nbCasesBonus < 0) {
			nbCasesBonus = 0;
		}

		if (nbCasesRetour < 0) {
			nbCasesRetour = 0;
		}

		Set<Integer> caseSpeciales = getRandom(nbCasesBonus + nbCasesRetour);
		// TODO A faire avec des streams pour test
		int i = 0;
		for (Integer integer : caseSpeciales) {
			if (i < nbCasesBonus) {
				casesBonus.add(integer);
			} else {
				casesRetour.add(integer);
			}
			i++;
		}
	}

	public CasesSpeciales(Set<Integer> casesRetour, Set<Integer> casesBonus) {
		if (casesRetour != null) {
			this.casesRetour = casesRetour;
		}
		if (casesBonus != null) {
			this.casesBonus = casesBonus;
		}
	}

	public Set<Integer> getCasesBonus() {
		return casesBonus;
	}

	public Set<Integer> getCasesRetour() {
		return casesRetour;
	}

	private static Set<Integer> getRandom(int size) {
		Set<Integer> randomInt = new HashSet<Integer>();

		while (randomInt.size() != size) {
			randomInt.add((int) (Math.random() * 35) + 1);
		}
		return randomInt;
	}

}
