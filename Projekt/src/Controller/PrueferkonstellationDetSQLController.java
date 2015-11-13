package Controller;

import java.sql.*;

public class PrueferkonstellationDetSQLController {
	Connection con;
	public PrueferkonstellationDetSQLController(Connection con){
		this.con = con;
	}

	public String getFachgruppe(String nutzername) {
		String result = "";
		String sql = "select bezeichnung from fachgruppe where nutzername = " + nutzername;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()){
				result = rs.getString(1);
			}
		} catch (SQLException e) {
			System.out.println("Fehler in getFachgruppe");
			e.printStackTrace();
		}
		return result;
	}

	public String[] getModule(String fachgruppe) {
		
			String[] result = null;
			int i = 0;
			String sql = "select bezeichnung from modul where fachgruppe.bezeichnung = " + fachgruppe;
			try {
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()){
					i += 1;
				}
				rs.beforeFirst();
				i = 0;
				while (rs.next()){
					result[i] = rs.getString(1);
					i += 1;
				}
			} catch (SQLException e) {
				System.out.println("Fehler in getModule");
				e.printStackTrace();
			}
			return result;
	}

	public Object[][] getData(String modul) {
		String sql = "select bezeichnung, nr, form, dauer, raum from pruefung where modnr =" + modul;
		Object[][] toreturn = null;
		int i = 0;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()){
				i+=1;
			}
			rs.beforeFirst();
			i = 0;
			while (rs.next()){
				toreturn = new Object[i][4];
				toreturn[i][0] = rs.getString(1);
				toreturn[i][1] = rs.getInt(2);
				toreturn[i][2] = rs.getString(3);
				toreturn[i][3] = rs.getInt(4);
				toreturn[i][4] = rs.getString(5);
				
				i+=1;
			}
			
		} catch (SQLException e) {
			System.out.println("Fehler in getData");
			e.printStackTrace();
		}
		
		return toreturn;
	}

	public String getErstpruefer(String fachgruppe) {
		String result = "";
		String sql = "select benutzername from user/fg where fachgruppe.bezeichnung = " + fachgruppe;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()){
				result = rs.getString(1);
			}
		} catch (SQLException e) {
			System.out.println("Fehler in getFachgruppe");
			e.printStackTrace();
		}
		return result;
	}
}
