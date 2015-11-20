package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import model.Fachgruppe;
import model.Modul;
import model.Pruefung;
import model.Studiengang;
import model.User;
import details.FachgruppeDet;
import details.ModulDet;
import details.PruefungDet;
import details.StudiengangDet;
import details.UserDet;

public class MyActionListener implements ActionListener {

	private SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
	Startansicht gui;
	Connection con;

	public MyActionListener(Startansicht gui, Connection con) {
		this.con = con;
		this.gui = gui;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		
		
		/*	Aus der gui.tabelle.getKlass() wird ausgelesen welcher Klasse die aktuell in der Tabelle anzeigten Daten angehören. 
		 * 
		 */
		
		String klasse = gui.tabelle.getKlasse();
		
		
		if (ae.getSource() == gui.btnBearbeiten) {
			
			
			/*
			 * Sicherstellen, dass Änderungsanweisungen nur dann durchgeführt
			 * werden können, wenn eine Zeile markiert wurde.
			 */
			
			if (gui.tabelle.getSelectedRow() >= 0) {
				
				/*	Fallunterscheidungen je nach Klasse der Tabelle.
				 * 
				 */
				

				if (klasse.equals("pruefung")){
					
					try {
						Pruefung prfg = gui.startansichtController
								.getAktPruefung();

						PruefungDet frame = new PruefungDet(prfg.getPrfNr(),
								prfg.getDatum(), prfg.getPruefungsForm(),
								prfg.getDauer(), prfg.getRaum(),
								prfg.getAktiv(), con);
						frame.setVisible(true);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if (klasse.equals("modul")){
					try {
						Modul mod = gui.startansichtController
								.getAktModul();

						
						//String modbez, int modnr, boolean aktiv, Connection con
						ModulDet frame = new ModulDet(mod.getBezeichnung(), mod.getModNr(),
								mod.getAktiv(), con);
						frame.setVisible(true);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if (klasse.equals("nutzer")){
					try {
						User user = gui.startansichtController
								.getAktUser();

						
						//String name, final String nutzername,  String rolle, final Connection con
						UserDet frame = new UserDet(user.getNachname(),user.getBenutzername(), user.getRolle(),
								user.getAktiv(), con);
						frame.setVisible(true);

					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
				if (klasse.equals("fachgruppe")){
					try {
						Fachgruppe fg = gui.startansichtController
								.getAktFachgruppe();

						
						//String bezeichnung, boolean aktiv, Connection con
						FachgruppeDet frame = new FachgruppeDet(fg.getName(),
								fg.getAktiv(), con);
						frame.setVisible(true);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if(klasse.equals("studiengang")){
					try {
						Studiengang stdg = gui.startansichtController
								.getAktStudiengang();

						
						//(String bezeichnung, boolean aktiv, Connection con)
						StudiengangDet frame = new StudiengangDet(stdg.getBezeichnung(),
								stdg.getAktiv(), con);
						frame.setVisible(true);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				

				

			}
		}
		
		
		
		
		if (ae.getSource() == gui.btnNeu) {
			
			/*	Unterscheidung, 
			
			
			*/
			if (klasse.equals("pruefung")){
			
				try {
					PruefungDet frame = new PruefungDet(0, new Date(
							"12.12.1993"), "", 0, "", true, con);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			if (klasse.equals("modul")){
				try {
					ModulDet frame = new ModulDet("", 0, true, con);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (klasse.equals("user")){
				try {
					UserDet frame = new UserDet("", "", "", true, con);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			if (klasse.equals("fachgruppe")){
				try {
					FachgruppeDet frame = new FachgruppeDet("",  true, con);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			if (klasse.equals("studiengang")){
				try {
					StudiengangDet frame = new StudiengangDet("", true, con);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
		
		if (ae.getSource() == gui.mntmModule) {
			
			MyTableModel tm = gui.startansichtController.aendereTm("modul");
			gui.tabelle.setModel(tm);
			gui.tabelle.setKlasse("modul");
			aktTabelle();
		}
		

		if (ae.getSource() == gui.mntmNutzer) {
			
			MyTableModel tm = gui.startansichtController.aendereTm("nutzer");
			gui.tabelle.setModel(tm);
			gui.tabelle.setKlasse("nutzer");
			aktTabelle();
		}
		
		if (ae.getSource() == gui.mntmFachgruppen) {
			
			MyTableModel tm = gui.startansichtController.aendereTm("fachgruppe");
			gui.tabelle.setModel(tm);
			gui.tabelle.setKlasse("fachgruppe");
			aktTabelle();
		}
		if (ae.getSource() == gui.mntmPrfungen) {
			
			MyTableModel tm = gui.startansichtController.aendereTm("pruefung");
			gui.tabelle.setModel(tm);
			gui.tabelle.setKlasse("pruefung");
			aktTabelle();
		}
		
		
	}
	private void aktTabelle(){
		gui.myListSelectionListener = new MyListSelectionListener(
				gui);
		gui.tabelle.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		gui.listmodel = gui.tabelle.getSelectionModel();
		gui.listmodel.addListSelectionListener(gui.myListSelectionListener);
	}
}