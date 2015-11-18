package DB_Controller;

import java.sql.*;

public class UserDetSQLController {
	Connection con;
	public UserDetSQLController(Connection con){
		this.con=con;
	}
	public Object[][] getData(String benutzername) {
		String sql ="Select benutzername, bezeichnung from usfg where benutzername= " + benutzername;
		Object[][] rueckgabe = null;
		int i = 0;
		
		try(Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)){
		
			while(rs.next()){
			i++;
		}
			rueckgabe= new Object[i][2];
			rs.beforeFirst();
			i=0;
			while(rs.next()){
				
				rueckgabe[i][0]= rs.getString(1);
				rueckgabe[i][1]= rs.getString(2);
				i++;
			}
		}catch(SQLException sqle){
			System.err.println("Fehler in getData(String benutzername): "+sqle.getMessage());
		}
		return rueckgabe;
	}

}
