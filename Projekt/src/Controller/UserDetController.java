package Controller;

import java.sql.Connection;

import DB_Controller.UserDetSQLController;

public class UserDetController {
UserDetSQLController controller;
	public UserDetController(Connection con){
		controller = new UserDetSQLController(con);
		
		
	}
	public String[] getHeadder() {
		String[]headder = new String[2];
		headder[0] = "Name";
		headder[1] ="Referent";
		return headder;
	}
	public Object[][] getData(String benutzername) {
		Object[][]data= controller.getData(benutzername);
		return data;
	}
}
