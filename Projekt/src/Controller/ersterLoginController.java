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
		try {	
			
			String sql = "update nutzer set registriert = 'n' where benutzername = '" + nutzername + "'";
			Statement stmt = con.createStatement();
			System.out.println("asd");
			stmt.execute(sql);
			System.out.println("am Anfang von setRegistriert2");
			stmt.close();
			System.out.println("am Anfang von setRegistriert3");
			
		} catch (SQLException e) {

			e.printStackTrace();
		}

		
	}
	public void setPasswort(String nutzername2) {
		// Befehle zum Ändern des Passwortes
		
	}
}
