package Controller;

import java.util.Date;
import java.util.TreeMap;

import javax.swing.table.DefaultTableModel;

import model.Dozent;
import model.Fachgruppe;
import model.Modul;
import model.Prueferkonstellation;
import model.Pruefung;
import model.Studiengang;
import model.User;

public class StartansichtController {
	
	private TreeMap<Integer, Pruefung> pruefungen;
	private TreeMap<Integer, Modul> module;
	private TreeMap<Integer, Fachgruppe> fachgruppen;
	private TreeMap<Integer, User> user;
	private TreeMap<Integer, Studiengang> studgaenge;
	private TreeMap<Integer, Prueferkonstellation> prueferkonst;
	
	
	
	private String[] columnHeaderUser = new String[] { "Benutzername", "Nachname", "Rolle", "aktiv" };
	private String[] columnHeaderFachgurppe = new String[] { "Bezeichnung", "aktiv" };
	private String[] columnHeaderModul = new String[] { "Modulbezeichnung", "Modulnr.", "aktiv" };
	private String[] columnHeaderPrfkonst = new String[] { "Studieng�nge", "Erstpruefer", "Zweitpruefer", "Pr�fungen" };
	private String[] columnHeaderPrfg = new String[] { "Pruefungsnr." , "Datum", "Pruefungsform", "Dauer", "Raum", "aktiv"};
	private String[] columnHeaderStdg = new String[] { "Bezeichnung", "aktiv" };
		
	private Pruefung aktPruefung;
	private Modul aktModul;
	private Fachgruppe aktFachgruppe;
	private User aktUser;
	private Studiengang aktStudiengang;
	private Prueferkonstellation aktPrueferkonst;
	
	public StartansichtController(){
		
	}
	
	public String BestimmeRolle(String nutzername){
		
		// SQL-Kommande zum Herausfinden der Rolle des angemeldeten Nutzers
		
		return "test";
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

	public Prueferkonstellation getAktPrueferkonst() {
		return aktPrueferkonst;
	}

	public void aenderAktPruefung(int prfnr, Date datum, String prfForm, int dauer, String raum, boolean aktiv){
		aktPruefung = new Pruefung(prfnr, datum, prfForm, dauer, raum, aktiv);
	}
	public void aenderAktModul(String modbez, int modnr, boolean aktiv){
		aktModul = new Modul(modbez, modnr, aktiv);
	}
	public void aenderAktFachgruppe(String bezeichnung, boolean aktiv){
		aktFachgruppe = new Fachgruppe(bezeichnung, aktiv);
	}
	public void aenderAktUser(String benutzername, char[] passwort, String nachname, String rolle, boolean aktiv){
		aktUser = new User(benutzername, passwort, nachname, rolle, aktiv);
	}
	public void aenderAktStudiengang(String bezeichnung, boolean aktiv){
		aktStudiengang = new Studiengang(bezeichnung, aktiv);
	}
	public void aenderPrufestkonst(Studiengang[] studiengaenge, Dozent erstpruefer, Dozent[] zweitpruefer, Pruefung[] pruefungen){
		aktPrueferkonst = new Prueferkonstellation(studiengaenge, erstpruefer, zweitpruefer,pruefungen);
	}

	private Object[][] data(String klasse){
			
			Object[][] datas = null;
			if (klasse == "modul"){
				// Modulbezeichnung, Modulnr., aktiv
				
				datas = new String[2][3];
				
				datas[0][0] = "Rechnungswesen";
				datas[0][1] = "1001";
				datas[0][2] = "true";
				
				datas = new String[2][3];
				datas[1][0] = "Produktion";
				datas[1][1] = "1002";
				datas[1][2] = "false";
			}
			if (klasse == "pruefung"){
				// prfnr, dauer, prfForm, datum, raum, aktiv
				
				datas = new String[2][6];
				
				datas[0][0] = "1001";
				datas[0][1] = "120";
				datas[0][2] = "klausur";
				datas[0][3] = "12.12.1992";
				datas[0][4] = "b3";
				datas[0][5] = "true";
				
				datas[1][0] = "1002";
				datas[1][1] = "30";
				datas[1][2] = "Pr�si";
				datas[1][3] = "11.11.1990";
				datas[1][4] = "b2";
				datas[1][5] = "false";
			}
			return datas;
		
	}
	
	private String[] getHeader(String klasse){
			switch (klasse){
			case "user":
				return columnHeaderUser;
			case "fachgruppe":
				return columnHeaderFachgurppe;
			case "modul":
				return columnHeaderModul;
			case "prueferkonstellation":
				return columnHeaderPrfkonst;
			case "pruefung":
				return columnHeaderPrfg;
			case "studiengang":
				return columnHeaderStdg;
			default:
				return null;
				}		
		}
	
	public DefaultTableModel aendereDtm(String klasse) {
		System.out.println("andereDTM + " + klasse);
		DefaultTableModel dtm = new DefaultTableModel(data(klasse),
				getHeader(klasse)) {

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		return dtm;
		
	}
	
	
}
