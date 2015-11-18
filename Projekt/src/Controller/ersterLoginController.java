package Controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ersterLoginController {
	Connection con;
	String nutzername;
	public ersterLoginController(String nutzername, Connection con) {
		this.con = con;
		this.nutzername = nutzername;
	}
	public void setRegistriert(String nutzername2) {
		try {	
			String sql = "update nutzer set registriert = 'j' where benutzername = '"
					+ nutzername + "'";
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
			
		} catch (SQLException e) {

			e.printStackTrace();
		}

		
	}
	public void setPasswort(String nutzername2) {
		// Befehle zum Ändern des Passwortes
		
	}
}
