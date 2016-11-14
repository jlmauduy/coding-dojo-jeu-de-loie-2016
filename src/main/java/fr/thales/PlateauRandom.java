package fr.thales;

import javax.annotation.PostConstruct;

public class PlateauRandom extends PlateauImpl {

	public PlateauRandom() {
		super();
		DispositionDePlateau casesSpeciales = new DispositionDePlateau(3, 3);
		this.avecCaseBonus(casesSpeciales.getCasesBonus().stream().mapToInt(i ->i ).toArray()).
		avecCaseRetour(casesSpeciales.getCasesRetour().stream().mapToInt(i ->i ).toArray());
	}
}
