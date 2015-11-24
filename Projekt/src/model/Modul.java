package model;

public class Modul {

	private String bezeichnung;
	private String modNr;
	private boolean aktiv;
	private String fachgruppe;
	
	public Modul(String bezeichnung, String modNr, String fachgruppe, boolean aktiv) {
		this.bezeichnung = bezeichnung;
		this.modNr = modNr;
		this.aktiv = aktiv;
		this.fachgruppe = fachgruppe;
	}
	
	public String getFachgruppe() {
		return fachgruppe;
	}

	public void setFachgruppe(String fachgruppe) {
		this.fachgruppe = fachgruppe;
	}

	public boolean getAktiv() {
		return aktiv;
	}

	public void setAktiv(boolean aktiv) {
		this.aktiv = aktiv;
	}

	public String getModNr() {
		return modNr;
	}

	public void setModNr(String modNr) {
		this.modNr = modNr;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

}
