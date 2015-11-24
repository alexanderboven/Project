package DB_Controller;

import java.sql.*;
import java.util.Date;

public class DB_Startansicht_Controller {
	public Connection con;

	public DB_Startansicht_Controller(Connection con) {
		this.con = con;
	}

	public String getRolle(String nutzername) {
		String rolle = null;
		try {
			String sql = "select rolle from Nutzer where benutzername = '"
					+ nutzername + "'";
			Statement stmt;
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
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
					+ nutzername + "'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
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
			while (rs.next()) {
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
		String sql = "select frist from fachsemester where name = '" + semester
				+ "'";
		Date datum = null;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
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
		Object[][] datas = null;
		try {
			int zeilen = 0;
			String sql = "select name, stdg_ID, status from studiengang";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			rs.beforeFirst();
			while (rs.next()) {
				zeilen++;
			}
			datas = new Object[zeilen][3];
			zeilen = 0;
			rs.beforeFirst();
			while (rs.next()) {
				datas[zeilen][0] = rs.getString("name");
				datas[zeilen][1] = rs.getString("stdg_ID");
				datas[zeilen][2] = rs.getString("status");
				zeilen++;
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.err.println("Fehler bei getStudiengang in DB"
					+ e.getMessage());
		}
		return datas;
	}

	public Object[][] getModule() {
		Object[][] datas = null;
		try {
			int zeilen = 0;
			String sql = "select bezeichnung, modul_ID, fgbezeichnung, status from module";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			rs.beforeFirst();
			while (rs.next()) {
				zeilen++;
			}
			datas = new Object[zeilen][4];
			zeilen = 0;
			rs.beforeFirst();
			while (rs.next()) {
				datas[zeilen][0] = rs.getString("bezeichnung");
				datas[zeilen][1] = rs.getString("modul_ID");
				datas[zeilen][2] = rs.getString("fgbezeichnung");
				datas[zeilen][3] = rs.getString("status");
				zeilen++;
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.err.println("Fehler bei getModule in DB" + e.getMessage());
		}
		return datas;
	}

	public Object[][] getAllePruefungen() {
		Object[][] datas = null;
		try {
			int zeilen = 0;
			String sql = "select bezeichnung, pruef_ID, modul_ID, stdg_ID, sem_ID, erstpruefer, datum, raum, anmeldezahl, status from pruefung";
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				zeilen++;
			}
			datas = new Object[zeilen][13];
			System.out.println(zeilen);
			zeilen = 0;

			// rs.beforeFirst();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				datas[zeilen][0] = rs.getString("bezeichnung");
				datas[zeilen][1] = rs.getString("pruef_ID");
				datas[zeilen][2] = rs.getString("modul_ID");
				datas[zeilen][3] = rs.getString("stdg_ID");
				datas[zeilen][4] = rs.getString("sem_ID");
				datas[zeilen][5] = rs.getString("erstpruefer");

				System.out.println("ich bin beim erstprüfer");

				Statement stmt2 = con.createStatement();
				String zweitprüfer = "";

				String sql2 = "select benutzername from zweitpruefer where pruef_ID= '"
						+ rs.getString("pruef_ID")+"'";

				ResultSet rs2 = stmt2.executeQuery(sql2);
			
				while (rs2.next()) {
					zweitprüfer = zweitprüfer + rs2.getString("benutzername") + ",";
				}
				if (zweitprüfer.length() > 0) {
					zweitprüfer = zweitprüfer.substring(0,
							zweitprüfer.length() - 1);
				}
				datas[zeilen][6] = zweitprüfer;
				System.out.println("ich bin beim zweitp");
				datas[zeilen][7] = rs.getDate("datum");

				System.out.println("ich bin beim datum");

				String sql5 = "select dauer, art_ID from prfgart where pruef_ID = '"
						+ rs.getString("pruef_ID") + "'";

				Statement stmt5 = con.createStatement();
				ResultSet rs5 = stmt5.executeQuery(sql5);
				String prfgArt = null;
				String prfgDauer = null;
				while (rs5.next()) {
					prfgArt = prfgArt + rs5.getString("art_ID") + ",";
					prfgDauer = prfgDauer + rs.getString("dauer") + ",";

				}
				prfgArt = prfgArt.substring(0, prfgArt.length() - 1);
				prfgDauer = prfgDauer.substring(0, prfgDauer.length() - 1);

				datas[zeilen][8] = prfgDauer;
				datas[zeilen][9] = prfgArt;
				datas[zeilen][10] = rs.getString("raum");
				datas[zeilen][11] = rs.getInt("anmeldezahl");
				datas[zeilen][12] = rs.getString("status");
				rs2.close();
				stmt2.close();
				zeilen++;
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.err.println("Fehler bei getAllePrüfungen in DB"
					+ e.getMessage());
		}
		return datas;
	}

	public Object[][] getNutzer() {
		Object[][] datas = null;
		try {
			int zeilen = 0;
			String sql = "select benutzername, nachname, rolle, status, registriert from Nutzer";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			rs.beforeFirst();
			while (rs.next()) {
				zeilen++;
			}
			datas = new Object[zeilen][6];
			zeilen = 0;
			rs.beforeFirst();
			while (rs.next()) {
				datas[zeilen][0] = rs.getString("benutzername");
				datas[zeilen][1] = rs.getString("nachname");
				datas[zeilen][2] = rs.getString("rolle");
				Statement stmt2 = con.createStatement();
				String fachgruppen = null;
				String sql2 = "select benutzername from usfg where benutzername= "
						+ rs.getString("benutzername");
				ResultSet rs2 = stmt2.executeQuery(sql2);
				rs2.beforeFirst();
				while (rs2.next()) {
					fachgruppen = fachgruppen + rs2.getString("bezeichnung")
							+ ",";
				}
				fachgruppen = fachgruppen
						.substring(0, fachgruppen.length() - 1);
				datas[zeilen][3] = fachgruppen;
				datas[zeilen][4] = rs.getString("status");
				datas[zeilen][5] = rs.getString("registriert");
				rs2.close();
				stmt2.close();
				zeilen++;
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.err.println("Fehler bei getNutzer in DB" + e.getMessage());
		}
		return datas;
	}

	public Object[][] getFachgruppen() {
		Object[][] datas = null;
		try {
			int zeilen = 0;
			String sql = "select name, bezeichnung, referent, status from fachgruppe";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			rs.beforeFirst();
			while (rs.next()) {
				zeilen++;
			}
			datas = new Object[zeilen][4];
			zeilen = 0;
			rs.beforeFirst();
			while (rs.next()) {
				datas[zeilen][0] = rs.getString("name");
				datas[zeilen][1] = rs.getString("bezeichnung");
				datas[zeilen][2] = rs.getString("referent");
				datas[zeilen][3] = rs.getString("status");
				zeilen++;
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.err.println("Fehler bei getFachgruppen in DB"
					+ e.getMessage());
		}
		return datas;
	}

	public Object[][] getEigenePruefungen(String benutzername) {
		Object[][] datas = null;
		try {
			int zeilen = 0;
			String sql1 = "(select pruef_ID from zweitpruefer where benutzername='"
					+ benutzername + "')";
			String sql = "select bezeichnung, pruef_ID, modul_ID, stdg_ID, sem_ID, erstpruefer, datum, raum, anmeldezahl, status from pruefung where pruef_ID='"
					+ sql1 + "'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				{
					zeilen++;
				}
			}
			String sql3 = "select erstpruefer from pruefung where erstpruefer='"
					+ benutzername + "'";
			Statement stmt3 = con.createStatement();
			ResultSet rs3 = stmt3.executeQuery(sql3);
			rs3.beforeFirst();
			while (rs3.next()) {
				zeilen++;
			}
			datas = new Object[zeilen][13];
			zeilen = 0;
			rs.beforeFirst();
			while (rs.next()) {
				datas[zeilen][0] = rs.getString("bezeichnung");
				datas[zeilen][1] = rs.getString("pruef_ID");
				datas[zeilen][2] = rs.getString("modul_ID");
				datas[zeilen][3] = rs.getString("stdg_ID");
				datas[zeilen][4] = rs.getString("sem_ID");
				datas[zeilen][5] = rs.getString("erstpruefer");
				Statement stmt4 = con.createStatement();
				String zweitprüfer = null;
				String sql2 = "select benutzername from zweitpruefer where pruef_ID= "
						+ rs.getString("pruef_ID");
				String sql4 = "select nachname from nutzer where benutzername='"
						+ sql2 + "'";
				ResultSet rs4 = stmt4.executeQuery(sql4);
				rs4.beforeFirst();
				while (rs4.next()) {
					zweitprüfer = zweitprüfer + rs4.getString("nachname") + ",";
				}
				zweitprüfer = zweitprüfer
						.substring(0, zweitprüfer.length() - 1);
				datas[zeilen][6] = zweitprüfer;
				datas[zeilen][7] = rs.getDate("datum");
				String sql5 = "select dauer, art_ID from prfgart where pruef_ID = '"
						+ rs.getString("pruef_ID") + "'";

				Statement stmt5 = con.createStatement();
				ResultSet rs5 = stmt5.executeQuery(sql5);
				String prfgArt = null;
				String prfgDauer = null;
				while (rs5.next()) {
					prfgArt = prfgArt + rs5.getString("art_ID") + ",";
					prfgDauer = prfgDauer + rs.getString("dauer") + ",";

				}
				prfgArt = prfgArt.substring(0, prfgArt.length() - 1);
				prfgDauer = prfgDauer.substring(0, prfgDauer.length() - 1);

				datas[zeilen][8] = prfgDauer;
				datas[zeilen][9] = prfgArt;
				datas[zeilen][10] = rs.getString("raum");
				datas[zeilen][11] = rs.getInt("anmeldezahl");
				datas[zeilen][12] = rs.getString("status");
				rs4.close();
				stmt4.close();
				zeilen++;
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.err.println("Fehler bei getEigenePrüfungen in DB"
					+ e.getMessage());
		}
		return datas;
	}

	// noch zu bearbeiten
	public Object[][] getPruefungenFG(String benutzername) {

		String sql = "select benutzername from usfg where bezeichnung ='"
				+ benutzername + "'";

		return null;
	}
}