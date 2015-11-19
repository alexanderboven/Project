package Controller;

import java.sql.Connection;




import javax.swing.table.DefaultTableModel;

import DB_Controller.StudiengangDetSQLController;



public class StudiengangDetController {

	
	StudiengangDetSQLController sqlController;
	
	
	public StudiengangDetController(Connection con){	
		sqlController = new StudiengangDetSQLController(con);
		
	}

	public Object[][] getData(String bezeichnung) {
		Object[][] data = sqlController.getData(bezeichnung);
		return data;
	}

	public String[] getHeader() {
		String[] header = new String[2];
		header[0] = "Modulbezeichnung";
		header[1] = "Modul-ID";
		return header;
	}

	public Object[][] getAllModule(String stdg) {
		Object[][] data = sqlController.getAllModule(stdg);
		return data;
	}

	public String[] getHeaderModHinzu() {
		String[] header = new String[3];
		header[1] = "Auswahl";
		header[1] = "Modulbezeichnung";
		header[2] = "Modul-ID";
		return header;
	}
	
	
	
	
	
	
}
