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

	public void aenderAktPruefung(int prfnr, Date datum, String prfForm,
			int dauer, String raum, boolean aktiv) {
		aktPruefung = new Pruefung(prfnr, datum, prfForm, dauer, raum, aktiv);
	}

	public void aenderAktModul(String modbez, int modnr, boolean aktiv) {
		aktModul = new Modul(modbez, modnr, aktiv);
	}

	public void aenderAktFachgruppe(String bezeichnung, boolean aktiv) {
		aktFachgruppe = new Fachgruppe(bezeichnung, aktiv);
	}

	public void aenderAktUser(String benutzername, char[] passwort,
			String nachname, String rolle, boolean aktiv) {
		aktUser = new User(benutzername, passwort, nachname, rolle, aktiv);
	}

	public void aenderAktStudiengang(String bezeichnung, boolean aktiv) {
		aktStudiengang = new Studiengang(bezeichnung, aktiv);
	}

	private Object[][] getData(String klasse) {

		Object[][] datas = null;
		if (klasse.equals("modul")) {
			// Modulbezeichnung, Modulnr., aktiv

			datas = new Object[2][3];

			datas[0][0] = "Rechnungswesen";
			datas[0][1] = "1001";
			datas[0][2] = true;

			datas[1][0] = "Produktion";
			datas[1][1] = "1002";
			datas[1][2] = false;
		}
		
		if (klasse.equals("pruefung")) {
			// prfnr, dauer, prfForm, datum, raum, aktiv

			datas = new Object[4][6];

			datas[0][0] = "1001";
			datas[0][1] = "120";
			datas[0][2] = "klausur";
			datas[0][3] = "12.12.1992";
			datas[0][4] = "b3";
			datas[0][5] = true;

			datas[1][0] = "1002";
			datas[1][1] = "30";
			datas[1][2] = "Präsi";
			datas[1][3] = "11.11.1990";
			datas[1][4] = "b2";
			datas[1][5] = false;

			datas[2][0] = "1002";
			datas[2][1] = "30";
			datas[2][2] = "Präsi";
			datas[2][3] = "11.11.1991";
			datas[2][4] = "b2";
			datas[2][5] = false;

			datas[3][0] = "1002";
			datas[3][1] = "30";
			datas[3][2] = "Präsi";
			datas[3][3] = "11.11.1993";
			datas[3][4] = "b2";
			datas[3][5] = false;
		}
		return datas;

	}

	public MyTableModel aendereTm(String klasse) {
		System.out.println("andereTm + " + klasse);

		Object[][] data = getData(klasse);
		
		MyTableModel tm = new MyTableModel(klasse, data);
		return tm;

	}
}

