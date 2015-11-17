package Controller;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

public class AnmeldeGUIController {
	public AnmeldeGUIController(){
		
	}
	
	//test
	
	public boolean passwortPruefen(String nutzer, char[] passwort){
		
		
		return true;
	}
	public boolean nutzerAktiv(String nutzer){
		
		
		return true;
	}
	
	public Connection getConnection(){
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
			

		}

		System.out.println("Oracle JDBC Driver Registered!");

		Connection connection = null;

		try {

			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@aix1.fh-bielefeld.de:1521:d2", "dvi992",
					"fh2274");

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			

		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
			return connection;
		} else {
			System.out.println("Failed to make connection!");
		}
	
		
		return null;
	}
	
}
