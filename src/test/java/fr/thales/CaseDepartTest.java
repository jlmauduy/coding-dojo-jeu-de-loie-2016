package fr.thales;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Test;

public class CaseDepartTest {

	@Test
	public void testGetNom() {
		CaseDepart caze = new CaseDepart();
		assertEquals("Depart", caze.getNom());
	}

	@Test
	public void testAfficherSansJoueur() {
		CaseDepart caze = new CaseDepart();
		assertEquals("[D]", caze.afficher(new HashSet<Joueur>()));
	}

	@Test
	public void testAfficherAvecJoueurs() {
		CaseDepart caze = new CaseDepart();
		Set<Joueur> joueurs = new LinkedHashSet<Joueur>();
		joueurs.add(new Joueur("Géraldine", "GPR"));
		joueurs.add(new Joueur("Aurélien", "ALE"));
		
		assertEquals("[GPR|ALE]", caze.afficher(joueurs));
	}
	
	@Test
	public void testAfficherNull() {
		CaseDepart caze = new CaseDepart();
		assertEquals("[D]", caze.afficher(null));
	}
	
	@Test
	public void testIsCaseARejouer(){
		CaseDepart caze = new CaseDepart();
		assertFalse(caze.isARejouer());
	}

}
