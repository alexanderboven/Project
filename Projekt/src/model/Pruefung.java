package model;

import java.util.Date;

public class Pruefung {
	private String bezeichnung;
	private String prf_id;
	private String mod_id;
	private String stdg_id;
	private String sem_id;
	private String erstpruefer;
	private String zweitpruefer;
	private Date datum;
	private int dauer;
	private String art;
	private String raum;
	private int teilnehmerzahl;
	private boolean aktiv;

	public Pruefung(String bezeichnung, String prf_id, String mod_id, String stdg_id, String sem_id, String erstpruefer, String zweitpruefer, Date datum, int dauer, String art, String raum, int teilnehmerzahl, boolean aktiv){
		this.bezeichnung = bezeichnung;
		this.prf_id = prf_id;
		this.mod_id = mod_id;
		this.sem_id = sem_id;
		this.erstpruefer = erstpruefer;
		this.zweitpruefer = zweitpruefer;
		this.datum = datum;
		this.dauer = dauer;
		this.art = art;
		this.raum = raum;
		this.teilnehmerzahl = teilnehmerzahl;
		this.aktiv = aktiv;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public String getPrf_id() {
		return prf_id;
	}

	public String getMod_id() {
		return mod_id;
	}

	public String getStdg_id() {
		return stdg_id;
	}

	public String getSem_id() {
		return sem_id;
	}

	public String getErstpruefer() {
		return erstpruefer;
	}

	public String getZweitpruefer() {
		return zweitpruefer;
	}

	public Date getDatum() {
		return datum;
	}

	public int getDauer() {
		return dauer;
	}

	public String getArt() {
		return art;
	}

	public String getRaum() {
		return raum;
	}

	public int getTeilnehmerzahl() {
		return teilnehmerzahl;
	}

	public boolean isAktiv() {
		return aktiv;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public void setPrf_id(String prf_id) {
		this.prf_id = prf_id;
	}

	public void setMod_id(String mod_id) {
		this.mod_id = mod_id;
	}

	public void setStdg_id(String stdg_id) {
		this.stdg_id = stdg_id;
	}

	public void setSem_id(String sem_id) {
		this.sem_id = sem_id;
	}

	public void setErstpruefer(String erstpruefer) {
		this.erstpruefer = erstpruefer;
	}

	public void setZweitpruefer(String zweitpruefer) {
		this.zweitpruefer = zweitpruefer;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public void setDauer(int dauer) {
		this.dauer = dauer;
	}

	public void setArt(String art) {
		this.art = art;
	}

	public void setRaum(String raum) {
		this.raum = raum;
	}

	public void setTeilnehmerzahl(int teilnehmerzahl) {
		this.teilnehmerzahl = teilnehmerzahl;
	}

	public void setAktiv(boolean aktiv) {
		this.aktiv = aktiv;
	}
}
