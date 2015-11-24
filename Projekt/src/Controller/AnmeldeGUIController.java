package Controller;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

import DB_Controller.AnmeldeGUISQLController;

public class AnmeldeGUIController {
	private AnmeldeGUISQLController controller;
	
	public AnmeldeGUIController(){
		controller = new AnmeldeGUISQLController();
	}
	
	public boolean passwortPruefen(String nutzer, char[] passwort){	
		return controller.passwortPruefen(nutzer, passwort);
	}
	
	public boolean nutzerAktiv(String nutzer){	
		return controller.nutzerAktiv(nutzer);
	}
	
	public boolean nutzerRegistriert(String nutzer){	
		return controller.NutzerRegistriert(nutzer);
	}
	
	
	public Connection getConnection(){
		return controller.getConnection();
	}
	
}
