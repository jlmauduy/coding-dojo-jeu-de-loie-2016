package fr.thales;

public class Joueur {

	private String nom;
	private String trigram;
	private int position;

	public Joueur(String nom, String trigram) {
		super();
		this.nom = nom;
		this.trigram = trigram;
		this.position = -1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((trigram == null) ? 0 : trigram.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Joueur other = (Joueur) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (trigram == null) {
			if (other.trigram != null)
				return false;
		} else if (!trigram.equals(other.trigram))
			return false;
		return true;
	}
	
	public void setPosition(int position) {
		this.position = position;
	}

	public int getPosition() {
		// TODO Auto-generated method stub
		return position;
	}

	public String getTrigram() {
		return trigram;
	}

}
