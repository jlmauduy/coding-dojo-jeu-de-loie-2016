package fr.thales;

public class CaseBonus extends Case {

	private static final int DELTA_CASE = 3;

	public CaseBonus() {
		super("Bonus","+3");
	}

	@Override
	public int getNextPosition(int targetPosition) {
		return targetPosition + DELTA_CASE;
	}
	
	@Override
	public boolean isARejouer() {
		return true;
	}
}
