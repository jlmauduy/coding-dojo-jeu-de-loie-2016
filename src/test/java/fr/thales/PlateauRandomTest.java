package fr.thales;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class PlateauRandomTest {

	@Test
	public void testPlateauRandom() {
		Plateau plateau = new PlateauRandom();
		int sommeCaseRetour = 0;
		List<Case> cases = plateau.getCases();
		for (Case caze : cases) {
			if (caze instanceof CaseRetour) {
				sommeCaseRetour++;
			}
		}
		Assert.assertEquals(3, sommeCaseRetour);
	}

}
