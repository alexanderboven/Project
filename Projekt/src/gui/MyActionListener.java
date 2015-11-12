package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import model.Pruefung;
import details.ModulDet;
import details.PruefungDet;

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
		/*
		 * Die Textfelder showName und showNachname k�nnen editiert werden. Wenn
		 * �nderungen dauerhaft gespeichert werden sollen, dann kann dies durch
		 * den Klick des Buttons aendern durchgef�hrt werden. Die �nderungen
		 * werden zum einen in der tabellarischen Anzeige angepasst und zum
		 * anderen beim jeweiligen Objekt in der TreeMap durchgef�hrt.
		 * �nderungen werden allerdings erst dann durchgef�hrt, wenn die
		 * Eingaben mindestens ein Zeichen lang sind
		 */
		String klasse = gui.tabelle.getKlasse();
		
		
		if (ae.getSource() == gui.btnBearbeiten) {
			
			/*
			 * Sicherstellen, dass �nderungsanweisungen nur dann durchgef�hrt
			 * werden k�nnen, wenn eine Zeile markiert wurde.
			 */
			
			if (gui.tabelle.getSelectedRow() >= 0) {
				
				/*
				 * �nderungen werden erst dann durchgef�hrt, wenn die jeweilige
				 * Eingabel�nge mindestens den Wert 1 hat.
				 */
				switch (klasse) {

				case "pruefung":
					
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
				case "modul":
				case "user":
				case "fachgruppe":
				case "studiengang":
				case "prueferkonstellation":

				}

			}
		}
		/*
		 * Wenn markierte Zeile und das dazugeh�rige Objekt gel�scht werden
		 * soll, kann diesesmit einem Klick auf den Buttom loeschen durchgef�hrt
		 * werden. Es werden die Anzeige aus dertabellarischen Darstellung und
		 * das entsprechende Objekt aus der TreeMap entfernt.
		 */
		if (ae.getSource() == gui.btnNeu) {
			/*
			 * Sicherstellen, dass L�schanweisungen nur dann durchgef�hrt werden
			 * k�nnen, wenn eine Zeile markiert wurde
			 */
			if (klasse == "pruefung"){
			
				try {
					PruefungDet frame = new PruefungDet(0, new Date(
							"12.12.1993"), "", 0, "", true, con);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (klasse == "modul"){
				try {
					ModulDet frame = new ModulDet("", 0, true, con);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			/*case "user":
			case "fachgruppe":
			case "studiengang":
			case "prueferkonstellation":
			

			}
			*/
		}
		
		if (ae.getSource() == gui.mntmModule) {
			System.out.println("actionevent Module");
			
			DefaultTableModel dtm = gui.startansichtController.aendereDtm("modul");
			gui.tabelle.setModel(dtm);
			gui.tabelle.setKlasse("modul");
			
		}

	}
}