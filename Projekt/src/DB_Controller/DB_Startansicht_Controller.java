package DB_Controller;

import java.sql.*;
import java.util.Date;

public class DB_Startansicht_Controller {
	public Connection con;

	public DB_Startansicht_Controller(Connection con) {
		this.con = con;
	}

	public String getRolle(String nutzername) {
		String rolle=null;
		try {

			String sql = "select rolle from Nutzer where benutzername = '" + nutzername+"'";
			
			Statement stmt;
			stmt = con.createStatement();

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
			String sql = "select nachname from Nutzer where benutzername = '"
					+ nutzername+"'";
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

	public Date getServerDate() {
		String sql = "select distinct trunc(sysdate,'dd')from nutzer";
		Date datum = null;
		try {
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()){
				datum = rs.getDate(1);
			}
			
			rs.close();
			stmt.close();

		} catch (SQLException e) {
			System.err.println("Fehler bei getName in DB" + e.getMessage());
		}
		return datum;
	}

	public Date getFrist(String semester) {
		String sql = "select frist from fachsemester where frist = '" + semester + "'";
		Date datum = null;
		try {
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()){
				datum = rs.getDate(1);
			}
			
			rs.close();
			stmt.close();

		} catch (SQLException e) {
			System.err.println("Fehler bei getName in DB" + e.getMessage());
		}
		return datum;
	}

	public Object[][] getStudiengaenge() {
		return null;
		
	}

	public Object[][] getModule() {
		Object[][] datas = new Object[2][3];

		datas[0][0] = "Rechnungswesen";
		datas[0][1] = "1001";
		datas[0][2] = true;

		datas[1][0] = "Produktion";
		datas[1][1] = "1002";
		datas[1][2] = false;
		return datas;
	}

	public Object[][] getAllePruefungen() {
		Object[][] datas = new Object[4][6];

		datas[0][0] = "1001";
		datas[0][1] = "120";
		datas[0][2] = "klausur";
		datas[0][3] = "12.12.1992";
		datas[0][4] = "b3";
		datas[0][5] = true;

		datas[1][0] = "1002";
		datas[1][1] = "30";
		datas[1][2] = "Präsi";
		datas[1][3] = "11.11.1990";
		datas[1][4] = "b2";
		datas[1][5] = false;

		datas[2][0] = "1002";
		datas[2][1] = "30";
		datas[2][2] = "Präsi";
		datas[2][3] = "11.11.1991";
		datas[2][4] = "b2";
		datas[2][5] = false;

		datas[3][0] = "1002";
		datas[3][1] = "30";
		datas[3][2] = "Präsi";
		datas[3][3] = "11.11.1993";
		datas[3][4] = "b2";
		datas[3][5] = false;
		
		return datas;
	}

	public Object[][] getNutzer() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object[][] getFachgruppen() {
		// TODO Auto-generated method stub
		return null;
	}

}
