package Controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ersterLoginController {
	Connection con;

	public ersterLoginController(Connection con) {
		this.con = con;
		
	}
	public void setRegistriert(String nutzername) {
		String sql = "";
		try {	
			
			sql = "update nutzer set registriert = 'j' where benutzername = '" + nutzername + "'";
			Statement stmt = con.createStatement();
			System.out.println("vor dem Ausführen der SQL-Abfrage");
			int i = stmt.executeUpdate(sql);
			System.out.println("Status der setRegistriert-Abfrage: " + i);
			stmt.close();
			
		} catch (SQLException e) {

			e.printStackTrace();
		}

		
	}
	public void setPasswort(String nutzername2) {
		// Befehle zum Ändern des Passwortes
		
	}
}
