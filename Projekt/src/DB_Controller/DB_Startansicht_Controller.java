package DB_Controller;

import java.sql.*;

public class DB_Startansicht_Controller {
	public Connection con;

	public DB_Startansicht_Controller(Connection con) {
		this.con = con;
	}

	public String getRolle(String nutzername) {
		String rolle="";
		try {

			String sql = "select rolle from Nutzer where nutzername = "
					+ nutzername;
			
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				rolle = rs.getString("rolle");
			}
			

			rs.close();
			stmt.close();

		} catch (SQLException e) {
			System.err.println("Fehler bei getRolle in DB" + e.getMessage());
		}

		return rolle;
	}

	public String getName(String nutzername) {
		String name = null;

		try {
			String sql = "select name from Nutzer where nutzername = "
					+ nutzername;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()){
				name = rs.getString("nachname");
			}
			
			rs.close();
			stmt.close();

		} catch (SQLException e) {
			System.err.println("Fehler bei getName in DB" + e.getMessage());
		}
		return name;
	}

}
