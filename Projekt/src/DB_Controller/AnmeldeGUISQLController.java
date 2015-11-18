package DB_Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AnmeldeGUISQLController {
	private Connection con;
	
	
	public AnmeldeGUISQLController(){
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {

			System.out.println("Oracle JDBC Treiber installiert?");
			e.printStackTrace();
			

		}

		System.out.println("Oracle JDBC Treiber gefunden!");
		con = null;

		try {

			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@aix1.fh-bielefeld.de:1521:d2", "dvi992",
					"fh2274");

		} catch (SQLException e) {

			System.out.println("Verbindung fehlgeschlagen. Fehler in der Konsole.");
			e.printStackTrace();
			

		}

		if (con != null) {
			System.out.println("Erfolgreich in der Datenbank registriert!");
		} else {
			System.out.println("Fehler beim Erstellen der Verbindung.");
		}
		
	}
	
	
	public Connection getConnection(){
		return con;		
	}
	
	
	public boolean passwortPruefen(String nutzer, char[] passwort) {
		
		String sql = "";
		boolean korrekt = true;
		System.out.println("korrekt: " +korrekt);
		return korrekt;
	}
	
	
	public boolean nutzerAktiv(String nutzer) {
		String sql = "select status from nutzer where benutzername = '" + nutzer +"'";
		boolean aktiv = false;
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()){
				if(rs.getString(1).equals("j"))
					aktiv = true;
					
			}
			rs.close();	
			stmt.close();
		 }catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println("aktiv: " + aktiv);
		return aktiv;
	}
	
	
	public boolean NutzerRegistriert(String nutzer) {
		String sql = "select registriert from nutzer where benutzername = '" + nutzer + "'";
		boolean registriert = false;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()){
				if(rs.getString(1) == "j")
					registriert = true;
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println("registriert: " + registriert);
		return registriert;
	}
	
	
	
}
