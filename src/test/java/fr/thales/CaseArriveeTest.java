package fr.thales;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Test;

public class CaseArriveeTest {

	@Test
	public void testGetNom() {
		CaseArrivee caze = new CaseArrivee();
		assertEquals("Arrivee", caze.getNom());
	}

	@Test
	public void testAfficherSansJoueur() {
		CaseArrivee caze = new CaseArrivee();
		assertEquals("[A]", caze.afficher(new HashSet<Joueur>()));
	}
	
	@Test
	public void testAfficherNull() {
		CaseArrivee caze = new CaseArrivee();
		assertEquals("[A]", caze.afficher(null));
	}

	@Test
	public void testIsCaseARejouer(){
		CaseArrivee caze = new CaseArrivee();
		assertFalse(caze.isARejouer());
	}

}
