package fr.thales;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class CaseRetourTest {
	
	private CaseRetour caze;

	@Before
	public void setUp() {
		caze = new CaseRetour();
	}

	@Test
	public void testGetNom() {
		assertEquals("Retour", caze.getNom());
	}

	@Test
	public void testAfficherSansJoueur() {
		assertEquals("[<-]", caze.afficher(new HashSet<Joueur>()));
	}
	
	@Test
	public void testAfficherNull() {
		assertEquals("[<-]", caze.afficher(null));
	}
	
	@Test
	public void testPosition() {
		assertEquals(0, caze.getNextPosition(23));
	}

	@Test
	public void testIsCaseARejouer(){
		assertTrue(caze.isARejouer());
	}

}
