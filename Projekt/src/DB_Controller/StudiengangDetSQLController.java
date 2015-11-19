package DB_Controller;
import java.sql.*;

public class StudiengangDetSQLController {
	Connection con;	
	
	
	public StudiengangDetSQLController(Connection con){
			this.con = con;
			
	}
		
	public Object[][] getData(String bezeichnung) {
		String sql = "select modul_id from modulStdg where stdg_id = '" + bezeichnung + "'";
		String sql2 = "select modul_id, bezeichnung from modul where modul_id in ("+ sql +")";
		Object[][] data = null;
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql2);
			int i = 0;
			
			// Schleife zum Zählen der Datensätze im Resultset. Wird benötigt um die Länge des data-Arrays zu ermitteln
			while(rs.next()){
				i = i+1 ;
			}
			// data-Array wird initiallisiert, rs-zeiger wird wieder vor den ersten Eintrag gesetzt, i wird wieder auf 0 gesetzt
			data  = new Object[i][2];
			i = 0;
			rs.beforeFirst();
			
			while (rs.next()){
				data[i][0] = rs.getString(1);
				data[i][1] = rs.getString(2);
				i = i+1;
			}
			rs.close();
			stmt.close();
			
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();	
		}
		
		
		return data;
	}

	public Object[][] getAllModule(String stdg) {
		Object[][] data = null;
		String sql1 = "select modul_id from modstdg where stud_id not like '" + stdg + "'";
		String sql2 = "select modul_id, bezeichnung from modul where modul_id in ("+ sql1 +")";
		try {
			Statement stmt  = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql2);
			
			int i = 0;
			while(rs.next()){
				i = i+1 ;
			}
			// data-Array wird initiallisiert, rs-zeiger wird wieder vor den ersten Eintrag gesetzt, i wird wieder auf 0 gesetzt
			data  = new Object[i][3];
			i = 0;
			rs.beforeFirst();
			
			while (rs.next()){
				data[i][0] = false;
				data[i][1] = rs.getString(1);
				data[i][2] = rs.getString(2);
				i = i+1;
			}
			rs.close();
			stmt.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
}
