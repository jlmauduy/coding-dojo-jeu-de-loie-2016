package fr.thales;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class DispositionDePlateau {

	private Set<Integer> casesBonus = new HashSet<Integer>();
	private Set<Integer> casesRetour = new HashSet<Integer>();

	public DispositionDePlateau(int nbCasesBonus, int nbCasesRetour) {
		super();
		if (nbCasesBonus < 0) {
			nbCasesBonus = 0;
		}

		if (nbCasesRetour < 0) {
			nbCasesRetour = 0;
		}

		Set<Integer> caseSpeciales = getRandom(nbCasesBonus + nbCasesRetour);
		
		caseSpeciales.stream().limit(nbCasesBonus).forEach(casesBonus::add);
		caseSpeciales.stream().skip(nbCasesBonus).limit(nbCasesRetour).forEach(casesRetour::add);
	}

	public Set<Integer> getCasesBonus() {
		return casesBonus;
	}

	public Set<Integer> getCasesRetour() {
		return casesRetour;
	}

	static Set<Integer> getRandom(int size) {
		return new Random().ints(1, 36).distinct().limit(size).boxed().collect(Collectors.toSet());
	}
	
}
