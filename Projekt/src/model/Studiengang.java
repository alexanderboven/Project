package model;

public class Studiengang {
	private String bezeichnung;
	String kuerzel;
	private boolean aktiv;
	
	public Studiengang(String id,String bezeichnung, boolean aktiv) {
		this.bezeichnung = bezeichnung;
		this.aktiv = aktiv;
		this.kuerzel = id;
	}
	
	public boolean getAktiv() {
		return aktiv;
	}

	public void setAktiv(boolean aktiv) {
		this.aktiv = aktiv;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public String getKuerzel() {
		return kuerzel;
	}

	public void setKuerzel(String kuerzel) {
		this.kuerzel = kuerzel;
	}

}
