package fr.thales;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlateauTest {
	
	private PlateauImpl plateau;

	@Before
	public void setup(){
		
		Set<Integer> casesRetour = new HashSet<Integer>();
		casesRetour.add(2);
		casesRetour.add(7);
		casesRetour.add(12);
		
		Set<Integer> casesBonus = new HashSet<Integer>();
		casesBonus.add(4);
		casesBonus.add(10);
		casesBonus.add(15);

		CasesSpeciales casesSpeciales = new CasesSpeciales(casesRetour, casesBonus);
		
		plateau = new PlateauImpl(casesSpeciales);
	}
	
	@Test
	public void testPlateauADesCases() {
		Plateau plateau = new PlateauImpl();
		List<Case> cases = plateau.getCases();
		Assert.assertEquals(37, cases.size());

		for (Case caze : cases) {
			Assert.assertNotNull(caze);
		}
	}

	@Test
	public void testPlateauCaseDepart() {
		Plateau plateau = new PlateauImpl();
		List<Case> cases = plateau.getCases();
		Assert.assertEquals("Depart", cases.get(0).getNom());

	}

	@Test
	public void testPlateauCaseLambda() {
		Plateau plateau = new PlateauImpl();
		List<Case> cases = plateau.getCases();
		Assert.assertNotEquals("Depart", cases.get(4).getNom());

	}

	@Test
	public void testPlateauCaseArrivee() {
		Plateau plateau = new PlateauImpl();
		List<Case> cases = plateau.getCases();
		Assert.assertEquals(CaseArrivee.class, cases.get(36).getClass());
	}
	
	@Test
	public void testPlateauCaseRetour() {
		Plateau plateau = new PlateauImpl();
		int sommeCaseRetour = 0;
		List<Case> cases = plateau.getCases();
		for (Case caze : cases) {
			if (caze instanceof CaseRetour) {
				sommeCaseRetour++;
			}
		}
		Assert.assertEquals(3, sommeCaseRetour);
	}

	@Test
	public void testPlateauNaPasDeJoueur() {
		Plateau plateau = new PlateauImpl();
		Assert.assertTrue(plateau.getListeJoueurs().isEmpty());
	}

	@Test
	public void testAjoutJoueurPlateau() {
		Plateau plateau = new PlateauImpl();

		plateau.ajouterJoueur(new Joueur("Géraldine", "GPR"));
		plateau.ajouterJoueur(new Joueur("Aurélien", "ALE"));

		Set<Joueur> listeJoueur = plateau.getListeJoueurs();
		Assert.assertTrue(listeJoueur.contains(new Joueur("Géraldine", "GPR")));
		Assert.assertTrue(listeJoueur.contains(new Joueur("Aurélien", "ALE")));
		Assert.assertEquals(0, listeJoueur.iterator().next().getPosition());
		Assert.assertEquals(2, listeJoueur.size());
	}

	@Test
	public void testAfficherPlateau() {
		Assert.assertEquals("[D][][<-][][+3][][][<-][][][+3][][<-][][][+3][][][][][][][][][][][][][][][][][][][][][A]",
				plateau.afficher());
	}
	
	@Test
	public void testResolutionDeCases() throws Exception {
		Joueur gpr = new Joueur("Géraldine", "GPR");
		plateau.ajouterJoueur(gpr);

		plateau.jouer(gpr, 4);
		
		Assert.assertEquals("[GPR][][<-][][+3][][][<-][][][+3][][<-][][][+3][][][][][][][][][][][][][][][][][][][][][A]",
				plateau.afficher());
	}

	@Test
	public void testCaseBonusSortDuPlateau() throws Exception {
		
		Set<Integer> casesRetour = new HashSet<Integer>();
		casesRetour.add(2);
		casesRetour.add(7);
		casesRetour.add(12);
		
		Set<Integer> casesBonus = new HashSet<Integer>();
		casesBonus.add(4);
		casesBonus.add(10);
		casesBonus.add(34);

		CasesSpeciales casesSpeciales = new CasesSpeciales(casesRetour, casesBonus);
		
		PlateauImpl plateau = new PlateauImpl(casesSpeciales);
		
		Joueur gpr = new Joueur("Géraldine", "GPR");
		plateau.ajouterJoueur(gpr);

		plateau.jouer(gpr, 34);
		
		Assert.assertEquals("[D][][<-][][+3][][][<-][][][+3][][<-][][][][][][][][][][][][][][][][][][][][][][+3][][GPR]",
				plateau.afficher());
	}

	
	// TODO: test enchainement de résolution de case
	// TODO: test la case bonus sort du plateau

	@Test
	public void testAfficherPlateauAvecDesJoueurs() {
		plateau.ajouterJoueur(new Joueur("Géraldine", "GPR"));
		plateau.ajouterJoueur(new Joueur("Aurélien", "ALE"));
		Assert.assertEquals("[GPR|ALE][][<-][][+3][][][<-][][][+3][][<-][][][+3][][][][][][][][][][][][][][][][][][][][][A]",
				plateau.afficher());
	}

	@Test
	public void testFaireJouerUnJoueur() throws Exception {
		Joueur gpr = new Joueur("Géraldine", "GPR");
		plateau.ajouterJoueur(gpr);

		Joueur ale = new Joueur("Aurélien", "ALE");
		plateau.ajouterJoueur(ale);

		plateau.jouer(gpr, 3);
		Assert.assertEquals("[ALE][][<-][GPR][+3][][][<-][][][+3][][<-][][][+3][][][][][][][][][][][][][][][][][][][][][A]",
				plateau.afficher());
	}

	@Test
	public void testFaireJouerUnJoueurApresLArrivee() throws Exception {
		PlateauImpl plateau = new PlateauImpl();

		Joueur gpr = new Joueur("Géraldine", "GPR");
		plateau.ajouterJoueur(gpr);

		plateau.jouer(gpr, 50);
		Assert.assertEquals(36, gpr.getPosition());
	}

	@Test
	public void testDéRandom() throws Exception {
		Plateau plateau = new PlateauImpl();

		Joueur gpr = new Joueur("Géraldine", "GPR");
		plateau.ajouterJoueur(gpr);

		for (int i = 0; i < 1000; i++) {
			int resultat = plateau.jouer(gpr);
			Assert.assertTrue(resultat > 0 && resultat < 7);
		}
	}
	
	@Test
	public void testJoueurGagnant() throws Exception {
		PlateauImpl plateau = new PlateauImpl();

		Joueur gpr = new Joueur("Géraldine", "GPR");
		plateau.ajouterJoueur(gpr);

		plateau.jouer(gpr, 50);
		Joueur gagnant = plateau.getGagnant();
		Assert.assertEquals(gpr, gagnant);
		
	}
	
	@Test
	public void testJoueurGagnantPilePoil() throws Exception {
		PlateauImpl plateau = new PlateauImpl();

		Joueur gpr = new Joueur("Géraldine", "GPR");
		plateau.ajouterJoueur(gpr);

		plateau.jouer(gpr, 36);
		Joueur gagnant = plateau.getGagnant();
		Assert.assertEquals(gpr, gagnant);
		
	}
	
	@Test
	public void testFaireJouerUnJoueurTombeCaseRetour() throws Exception {
		Joueur gpr = new Joueur("Géraldine", "GPR");
		plateau.ajouterJoueur(gpr);

		plateau.jouer(gpr, 1);
		Assert.assertEquals("[D][GPR][<-][][+3][][][<-][][][+3][][<-][][][+3][][][][][][][][][][][][][][][][][][][][][A]",
				plateau.afficher());
		plateau.jouer(gpr, 1);
		Assert.assertEquals("[GPR][][<-][][+3][][][<-][][][+3][][<-][][][+3][][][][][][][][][][][][][][][][][][][][][A]",
				plateau.afficher());
	}
	
	@Test(expected=PasAToiDeJouerException.class)
	public void testMultiJoueur() throws Exception{
		Joueur gpr = new Joueur("Géraldine", "GPR");
		Joueur ale = new Joueur("Aurélien", "ALE");
		plateau.ajouterJoueur(gpr);
		plateau.ajouterJoueur(ale);
		
		plateau.jouer(gpr, 1);
		plateau.jouer(gpr, 2);
	}
	
	@Test
	public void testJoueurSuivant() {
		Joueur gpr = new Joueur("Géraldine", "GPR");
		Joueur ale = new Joueur("Aurélien", "ALE");
		plateau.ajouterJoueur(gpr);
		plateau.ajouterJoueur(ale);
		
		Joueur nextJoueur = plateau.getNextJoueur();
		Assert.assertEquals(ale, nextJoueur);
	
	}
}
