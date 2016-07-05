package fr.thales;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class JoueurTest {

	@Test
	public void testPositionParDefaut() {
		Joueur mJoueur = new Joueur("Florian", "FCO");
		Assert.assertEquals(-1, mJoueur.getPosition());
	}

	@Test
	public void testAfficherTrigrammes() {
		Set<Joueur> joueurs = new LinkedHashSet<Joueur>();
		joueurs.add(new Joueur("Géraldine", "GPR"));
		joueurs.add(new Joueur("Aurélien", "ALE"));
		
		Assert.assertEquals("GPR|ALE", Joueurs.afficherTrigrammes(joueurs ));
	}
}
