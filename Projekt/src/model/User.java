package model;

public class User {
	private String benutzername;
	private String nachname;
	private String rolle;
	private String fachgruppe;
	private boolean aktiv;
	private boolean registriert;
	
	public User(String benutzername, String nachname, String rolle, String fachgruppe, boolean registriert, boolean aktiv){
		this.benutzername = benutzername;
		this.nachname = nachname;
		this.fachgruppe = fachgruppe;
		this.rolle = rolle;
		this.aktiv = aktiv;
	}	
		
	public boolean getAktiv() {
		return aktiv;
	}

	public void setAktiv(boolean aktiv) {
		this.aktiv = aktiv;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getRolle() {
		return rolle;
	}

	public void setRolle(String rolle) {
		this.rolle = rolle;
	}

	public String getBenutzername() {
		return benutzername;
	}

	public void setBenutzername(String benutzername) {
		this.benutzername = benutzername;
	}

	public boolean isRegistriert() {
		return registriert;
	}

	public void setRegistriert(boolean registriert) {
		this.registriert = registriert;
	}

	public String getFachgruppe() {
		return fachgruppe;
	}

	public void setFachgruppe(String fachgruppe) {
		this.fachgruppe = fachgruppe;
	}
	
	
}
