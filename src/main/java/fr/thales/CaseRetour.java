package fr.thales;

public class CaseRetour extends Case {

	public CaseRetour() {
		super("Retour", "<-");
	}

	@Override
	public int getNextPosition(int targetPosition) {
		return 0;
	}
	
	@Override
	public boolean isARejouer() {
		return true;
	}
}
