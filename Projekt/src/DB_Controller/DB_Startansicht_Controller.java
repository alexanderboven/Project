package DB_Controller;

import java.sql.*;

public class DB_Startansicht_Controller {
	private Connection con;

	public DB_Startansicht_Controller(Connection con) {
		this.con = con;
	}

	public String getRolle(String nutzername) {
		String rolle = null;
		try {

			String sql = "select rolle from User where nutzername = "
					+ nutzername;
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			rolle = rs.getString("rolle");

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
			String sql = "select name from User where nutzername = "
					+ nutzername;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			name = rs.getString("name");
			rs.close();
			stmt.close();

		} catch (SQLException e) {
			System.err.println("Fehler bei getName in DB" + e.getMessage());
		}
		return name;
	}

}
