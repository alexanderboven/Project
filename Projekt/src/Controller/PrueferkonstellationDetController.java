package Controller;

import java.sql.Connection;

import javax.swing.table.DefaultTableModel;

public class PrueferkonstellationDetController {
PrueferkonstellationDetSQLController controller;
	public PrueferkonstellationDetController(Connection con){
	controller = new PrueferkonstellationDetSQLController(con);
}
	
	public String getFachgruppe(String nutzer){
		return controller.getFachgruppe(nutzer);
	}
	
	public String[] getModule(String fachgruppe) {
		
		return controller.getModule(fachgruppe);
	}

	public DefaultTableModel bestimmeDtm(String modul) {
		DefaultTableModel dtm = null;
		String[] header = new String[] {
				"asd"
		};
		Object[][] data = controller.getData(modul);
		return dtm;
	}

	public String getErstpruefer(String fachgruppe) {
		return controller.getErstpruefer(fachgruppe);		
	}
}
