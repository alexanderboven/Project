package gui;

import javax.swing.table.DefaultTableModel;

public class MyTableModel extends DefaultTableModel {
	private String klasse;
	private Object[][] data;
	private Class[] columnTypes= new Class[] { Object.class, Object.class,
			Object.class, Object.class, Object.class, Boolean.class };

	private static String[] columnHeaderUser = new String[] { "Benutzername",
			"Nachname", "Rolle", "aktiv" };
	private static String[] columnHeaderFachgurppe = new String[] {
			"Bezeichnung", "aktiv" };
	private static String[] columnHeaderModul = new String[] {
			"Modulbezeichnung", "Modulnr.", "aktiv" };
	private static String[] columnHeaderPrfkonst = new String[] {
			"Studiengänge", "Erstpruefer", "Zweitpruefer", "Prüfungen" };
	private static String[] columnHeaderPrfg = new String[] { "Pruefungsnr.",
			"Dauer", "Pruefungsform", "Datum", "Raum", "aktiv" };
	private static String[] columnHeaderStdg = new String[] { "Bezeichnung",
			"aktiv" };

	
	
	
	public MyTableModel(String klasse, Object[][] data) {
		super(data, getColumnHeader(klasse));
		setColumnTypes(klasse);
		this.klasse = klasse;

	}

	public String getKlasse() {
		return klasse;
	}

	public Object[][] getData() {
		return data;
	}

	public void setKlasse(String klasse) {
		this.klasse = klasse;
	}

	public void setData(Object[][] data) {
		this.data = data;
	}

	public Class getColumnClass(int columnIndex) {
		return columnTypes[columnIndex];
	}

	public boolean isCellEditable(int row, int column) {
		return false;
	}

	public void setColumnTypes(String klasse) {

		switch (klasse) {
		case "nutzer":
			columnTypes = new Class[] { Object.class, Object.class,
					Object.class, Boolean.class };
		case "fachgruppe":
			columnTypes = new Class[] { Object.class, Boolean.class };
		case "modul":
			columnTypes = new Class[] { Object.class, Object.class,
					Boolean.class };
		case "prueferkonstellation":

		case "pruefung":
			columnTypes = new Class[] { Object.class, Object.class,
					Object.class, Object.class, Object.class, Boolean.class };
		case "studiengang":
			columnTypes = new Class[] { Object.class, Boolean.class };
		}

	}

	private static String[] getColumnHeader(String klasse) {
		switch (klasse) {
		case "nutzer":
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
}