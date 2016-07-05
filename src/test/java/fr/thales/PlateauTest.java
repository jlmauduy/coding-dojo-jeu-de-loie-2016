package fr.thales;

import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class PlateauTest {

	
	@Test
	public void testPlateauADesCases() {
		Plateau plateau = new Plateau();
		List<Case> cases = plateau.getCases();
		Assert.assertEquals(37,  cases.size());
	
		for (Case caze : cases) {
			Assert.assertNotNull(caze);
		}
	}
	
	@Test
	public void testPlateauCaseDepart() {
		Plateau plateau = new Plateau();
		List<Case> cases = plateau.getCases();
		Assert.assertEquals("Depart", cases.get(0).getNom());
		
	}
	
	@Test
	public void testPlateauCaseLambda() {
		Plateau plateau = new Plateau();
		List<Case> cases = plateau.getCases();
		Assert.assertNotEquals("Depart", cases.get(4).getNom());
		
	}
	
	@Test
	public void testPlateauNaPasDeJoueur() {
		Plateau plateau = new Plateau();
		Assert.assertTrue(plateau.getListeJoueurs().isEmpty());
	}
	
	@Test
	public void testAjoutJoueurPlateau() {
		Plateau plateau = new Plateau();
		
		plateau.ajouterJoueur(new Joueur("Géraldine", "GPR"));
		plateau.ajouterJoueur(new Joueur("Aurélien", "ALE"));
		
		Set<Joueur> listeJoueur = plateau.getListeJoueurs();
		Assert.assertTrue(listeJoueur.contains(new Joueur("Géraldine", "GPR")));
		Assert.assertTrue(listeJoueur.contains(new Joueur("Aurélien", "ALE")));
		Assert.assertEquals(0,listeJoueur.iterator().next().getPosition());
		Assert.assertEquals(2, listeJoueur.size());
	}
	
	@Test
	public void testAfficherPlateau() {
		Plateau plateau = new Plateau();
		Assert.assertEquals("[D][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]", plateau.afficher());
	}
	
	@Test
	public void testAfficherPlateauAvecDesJoueurs() {
		Plateau plateau = new Plateau();
		plateau.ajouterJoueur(new Joueur("Géraldine", "GPR"));
		plateau.ajouterJoueur(new Joueur("Aurélien", "ALE"));
		Assert.assertEquals("[GPR|ALE][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]", plateau.afficher());
	}
}
