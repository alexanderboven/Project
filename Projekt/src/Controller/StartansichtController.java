package Controller;

import gui.MyTableModel;

import java.sql.Connection;
import java.util.Date;
import java.util.TreeMap;

import javax.swing.table.DefaultTableModel;

import DB_Controller.DB_Startansicht_Controller;
import model.Fachgruppe;
import model.Modul;
import model.Pruefung;
import model.Studiengang;
import model.User;

public class StartansichtController {

	private TreeMap<Integer, Pruefung> pruefungen;
	private TreeMap<Integer, Modul> module;
	private TreeMap<Integer, Fachgruppe> fachgruppen;
	private TreeMap<Integer, User> user;
	private TreeMap<Integer, Studiengang> studgaenge;

	private Pruefung aktPruefung;
	private Modul aktModul;
	private Fachgruppe aktFachgruppe;
	private User aktUser;
	private Studiengang aktStudiengang;
	private DB_Startansicht_Controller dbStartansichtController;
	private Date serverDatum;

	public StartansichtController(Connection con) {

		dbStartansichtController = new DB_Startansicht_Controller(con);
	}

	public String bestimmeName(String nutzername, Connection con) {
		String name = dbStartansichtController.getName(nutzername);
		return name;
	}

	public String bestimmeRolle(String nutzername, Connection con) {
		// Verbindung mit DB_Controller
		String rolle = dbStartansichtController.getRolle(nutzername);

		return rolle;
	}

	public Pruefung getAktPruefung() {
		return aktPruefung;
	}

	public Modul getAktModul() {
		return aktModul;
	}

	public Fachgruppe getAktFachgruppe() {
		return aktFachgruppe;
	}

	public User getAktUser() {
		return aktUser;
	}

	public Studiengang getAktStudiengang() {
		return aktStudiengang;
	}

	public void aenderAktPruefung(String bezeichnung, String prf_id, String mod_id, String stdg_id, String sem_id, String erstpruefer, String zweitpruefer, Date datum, int dauer, String art, String raum, 
	int teilnehmerzahl, boolean aktiv) {
		// String bezeichnung, String prf_id, String mod_id, String stdg_id, String sem_id, String erstpruefer, String zweitpruefer, Date datum, int dauer, String art, String raum, 
		// int teilnehmerzahl, boolean aktiv
		aktPruefung = new Pruefung(bezeichnung, prf_id, mod_id, stdg_id, sem_id, erstpruefer, zweitpruefer, datum, dauer, art, raum, 
				teilnehmerzahl, aktiv);
	}

	public void aenderAktModul(String bezeichnung, String modNr, String fachgruppe, boolean aktiv) {
		// String bezeichnung, String modNr, String fachgruppe, boolean aktiv
		aktModul = new Modul(bezeichnung, modNr, fachgruppe, aktiv);
	}

	public void aenderAktFachgruppe(String name, String referent, boolean aktiv) {
		// String name, String referent, boolean aktiv
		aktFachgruppe = new Fachgruppe(name, referent, aktiv);
	}

	public void aenderAktUser(String benutzername, 
			String nachname, String rolle, String fachgruppe, boolean registriert, boolean aktiv) {
		// String benutzername, String nachname, String rolle, String fachgruppe, boolean registriert, boolean aktiv
		aktUser = new User(benutzername, nachname, rolle, fachgruppe, registriert, aktiv);
	}

	public void aenderAktStudiengang(String kuerzel, String bezeichnung, boolean aktiv) {
		// String id,String bezeichnung, boolean aktiv
		aktStudiengang = new Studiengang(kuerzel, bezeichnung, aktiv);
	}

	private Object[][] getData(String klasse) {

		Object[][] datas = null;
		
		if (klasse.equals("pruefung")) {
			datas = dbStartansichtController.getAllePruefungen();
		}
			
		if (klasse.equals("modul")) {
		
			datas = dbStartansichtController.getModule();
		}
		
		if (klasse.equals("eigenePruefung")) {
			String nutzername = aktUser.getBenutzername();
			datas = dbStartansichtController.getEigenePruefungen(nutzername);
		}
		
		if (klasse.equals("FGPruefungen")) {
			String nutzername = aktUser.getBenutzername();
			datas = dbStartansichtController.getPruefungenFG(nutzername);
		}
		
		if (klasse.equals("nutzer")) {
		
			datas = dbStartansichtController.getNutzer();
		}
		
		if (klasse.equals("fachgruppe")) {
		
			datas = dbStartansichtController.getFachgruppen();
		}
		
		if (klasse.equals("studiengang")) {
			datas = dbStartansichtController.getStudiengaenge();
		}
		return datas;
	}

	public MyTableModel aendereTm(String klasse) {
		Object[][] data = getData(klasse);

		MyTableModel tm = new MyTableModel(klasse, data);
		return tm;

	}

	public Date getServerDatum() {
		return dbStartansichtController.getServerDate();
	}

	public Date getFrist(String semester) {

		return dbStartansichtController.getFrist(semester);
	}
}
