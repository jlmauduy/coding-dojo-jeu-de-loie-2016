package fr.thales;

import static org.junit.Assert.*;

import org.junit.Test;

public class CasesSpecialesTest {

	@Test
	public void bonNbCasesBonus() {
		CasesSpeciales cs = new CasesSpeciales(5, 3);
		assertEquals(5, cs.getCasesBonus().size());
	}

	@Test
	public void bonNbCasesRetours() {
		CasesSpeciales cs = new CasesSpeciales(5, 3);
		assertEquals(3, cs.getCasesRetour().size());
	}
	
	@Test
	public void zeroCasesBonus() {
		CasesSpeciales cs = new CasesSpeciales(0, 3);
		assertEquals(0, cs.getCasesBonus().size());
	}
	
	@Test
	public void casesBonusNegative() {
		CasesSpeciales cs = new CasesSpeciales(-15, 3);
		assertEquals(0, cs.getCasesBonus().size());
	}
}
