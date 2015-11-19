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

		
		if (klasse.equals("nutzer")){
			columnTypes = new Class[] { Object.class, Object.class,
					Object.class, Boolean.class };
		}
			
		if(klasse.equals("fachgruppe")){
				columnTypes = new Class[] { Object.class, Boolean.class };
		}
		
		if(klasse.equals("modul")){
				columnTypes = new Class[] { Object.class, Object.class,
					Boolean.class };
		}
		
		
		if(klasse.equals("pruefung")){
			columnTypes = new Class[] { Object.class, Object.class,
					Object.class, Object.class, Object.class, Boolean.class };
		}
			
		if(klasse.equals("studiengang")){
			columnTypes = new Class[] { Object.class, Boolean.class };
		}
			
		}

	

	private static String[] getColumnHeader(String klasse) {

		if (klasse.equals("nutzer")){
			return columnHeaderUser;
		}
			
		if(klasse.equals("fachgruppe")){
			return columnHeaderFachgurppe;
		}
		
		if(klasse.equals("modul")){
			return columnHeaderModul;	
		}
		
		
		if(klasse.equals("pruefung")){
			return columnHeaderPrfg;
		}
			
		if(klasse.equals("studiengang")){
			return columnHeaderStdg;
		}
			
			return null;
		
	}
}