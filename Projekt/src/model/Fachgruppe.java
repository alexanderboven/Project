package model;

public class Fachgruppe {
	private String name;
	private boolean aktiv;
	private String referent;
	
	public Fachgruppe(String name, String referent, boolean aktiv){
		this.name = name;
		this.referent = referent;
		this.aktiv = aktiv;
	}
	
	public String getReferent() {
		return referent;
	}

	public void setReferent(String referent) {
		this.referent = referent;
	}

	public boolean getAktiv() {
		return aktiv;
	}

	public void setAktiv(boolean aktiv) {
		this.aktiv = aktiv;
	}	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
