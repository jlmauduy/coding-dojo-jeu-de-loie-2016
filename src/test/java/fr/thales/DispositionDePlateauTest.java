package fr.thales;

import static org.junit.Assert.*;

import org.junit.Test;

public class DispositionDePlateauTest {

	@Test
	public void bonNbCasesBonus() {
		DispositionDePlateau cs = new DispositionDePlateau(5, 3);
		assertEquals(5, cs.getCasesBonus().size());
	}

	@Test
	public void bonNbCasesRetours() {
		DispositionDePlateau cs = new DispositionDePlateau(5, 3);
		assertEquals(3, cs.getCasesRetour().size());
	}
	
	@Test
	public void zeroCasesBonus() {
		DispositionDePlateau cs = new DispositionDePlateau(0, 3);
		assertEquals(0, cs.getCasesBonus().size());
	}
	
	@Test
	public void casesBonusNegative() {
		DispositionDePlateau cs = new DispositionDePlateau(-15, 3);
		assertEquals(0, cs.getCasesBonus().size());
	}
	
	@Test
	public void testGetRandom() {
		for (int i = 0 ; i<100 ; i++) {
			assertEquals(34, DispositionDePlateau.getRandom(34).size());
		}
	}
}
