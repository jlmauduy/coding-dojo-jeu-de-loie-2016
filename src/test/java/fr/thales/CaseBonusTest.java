package fr.thales;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

public class CaseBonusTest {

	private CaseBonus caze;

	@Before
	public void setUp() {
		caze = new CaseBonus();
	}

	@Test
	public void testGetNom() {
		assertEquals("Bonus", caze.getNom());
	}

	@Test
	public void testAfficherSansJoueur() {
		assertEquals("[+3]", caze.afficher(new HashSet<Joueur>()));
	}
	
	@Test
	public void testAfficherNull() {
		assertEquals("[+3]", caze.afficher(null));
	}
	
	@Test
	public void testPosition() {
		assertEquals(26, caze.getNextPosition(23));
	}
	
	@Test
	public void testIsCaseARejouer(){
		assertTrue(caze.isARejouer());
	}
}
