package gui;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Pruefung;
import model.Studiengang;
import model.User;

public class MyListSelectionListener implements ListSelectionListener {
	private Startansicht gui;
	private boolean aktiv;
	

	public MyListSelectionListener(Startansicht gui) {
		this.gui = gui;
	}

	@Override
	public void valueChanged(ListSelectionEvent lse) {
		if (lse.getSource() == gui.listmodel) {
			/*
			 * Wenn in der Tabelle eine Zeile markiert ist, sollen die
			 * Detailinformationen zu der markierten Zeile in den Textfeldern
			 * angezeigt werden.
			 */
			if (gui.tabelle.getSelectedRow() >= 0) {

				// speichern der Informationen der aktuell selektiereten Tabelle
				// in einem Objekt des jeweiligen Typs
				// Unterscheidung welche Objekte aktuell in der Tabelle sind. Je
				// nach Objekttyp werden unterschiedliche aktXXX Objekte
				// verändert

				String klasse = gui.tabelle.getKlasse();
				aktiv = true;

				

				if (klasse.equals("pruefung")){
				// String bezeichnung, String prf_id, String mod_id, String stdg_id, String sem_id, String erstpruefer, String zweitpruefer, Date datum, int dauer, String art, String raum, 
				// int teilnehmerzahl, boolean aktiv
					String bezeichnung = gui.tabelle.getValueAt(
							gui.tabelle.getSelectedRow(), 0).toString();
					String prf_id = gui.tabelle.getValueAt(
							gui.tabelle.getSelectedRow(), 1).toString();
					String mod_id = gui.tabelle.getValueAt(
							gui.tabelle.getSelectedRow(), 2).toString();
					String stdg_id = gui.tabelle.getValueAt(
							gui.tabelle.getSelectedRow(), 3).toString();
					String sem_id = gui.tabelle.getValueAt(
							gui.tabelle.getSelectedRow(), 4).toString();
					String erstprfer = gui.tabelle.getValueAt(
							gui.tabelle.getSelectedRow(), 5).toString();
					String zweitprfer = gui.tabelle.getValueAt(
							gui.tabelle.getSelectedRow(), 6).toString();
					
					DateFormat df = new SimpleDateFormat("dd.mm.yyyy");
					Date datum = null;
					try {
						datum = df.parse((String) gui.tabelle.getValueAt(
								gui.tabelle.getSelectedRow(), 7));
					} catch (ParseException e) {

						e.printStackTrace();
					}
					
					int dauer = Integer.parseInt((String) gui.tabelle
							.getValueAt(gui.tabelle.getSelectedRow(), 8));
					
					String art = gui.tabelle.getValueAt(
							gui.tabelle.getSelectedRow(), 9).toString();

					

					String raum = gui.tabelle.getValueAt(
							gui.tabelle.getSelectedRow(), 10).toString();

					int teilnehmerzahl = Integer.parseInt((String) gui.tabelle
							.getValueAt(gui.tabelle.getSelectedRow(), 10));
					
					if (gui.tabelle.getValueAt(gui.tabelle.getSelectedRow(), 11)
							.toString().equals("false")) {
						aktiv = false;
					}

					// aktualisieren des Obejektes, welches die aktuell
					// ausgewählte Prüfung darstellt
					gui.startansichtController.aenderAktPruefung(bezeichnung, prf_id, mod_id, stdg_id, sem_id, erstprfer, zweitprfer, datum, dauer, art, raum, teilnehmerzahl, aktiv);	
				}
					

				if(klasse.equals("modul")){
					// String bezeichnung, String modNr, String fachgruppe, boolean aktiv
					String modbez = gui.tabelle.getValueAt(
							gui.tabelle.getSelectedRow(), 0).toString();
					String modnr = gui.tabelle.getValueAt(
							gui.tabelle.getSelectedRow(), 1).toString();
					String fachgruppe = gui.tabelle.getValueAt(
							gui.tabelle.getSelectedRow(), 2).toString();
					if (gui.tabelle.getValueAt(gui.tabelle.getSelectedRow(), 3)
							.toString().equals("false")) {
						aktiv = false;
					}
					gui.startansichtController.aenderAktModul(modbez, modnr,fachgruppe,aktiv);

				}
				
				if(klasse.equals("fachgruppe")){
					// String name, String referent, boolean aktiv
					String bezeichnung = gui.tabelle.getValueAt(
							gui.tabelle.getSelectedRow(), 0).toString();
					String referent = gui.tabelle.getValueAt(
							gui.tabelle.getSelectedRow(), 1).toString();
					if (gui.tabelle.getValueAt(gui.tabelle.getSelectedRow(), 2)
							.toString().equals("false")) {
						aktiv = false;
					}
					gui.startansichtController.aenderAktFachgruppe(bezeichnung,referent,
							aktiv);

				}
				if(klasse.equals("studiengang")){
					// String id,String bezeichnung, boolean aktiv
					String id = gui.tabelle.getValueAt(
							gui.tabelle.getSelectedRow(), 0).toString();
					String bez = gui.tabelle.getValueAt(
							gui.tabelle.getSelectedRow(), 1).toString();
					;
					if (gui.tabelle.getValueAt(gui.tabelle.getSelectedRow(), 1)
							.toString().equals("false")) {
						aktiv = false;
					}
					gui.startansichtController.aenderAktStudiengang(id,bez, aktiv);

				}
				
				if(klasse.equals("user")){
					// String benutzername, String nachname, String rolle, String fachgruppe, boolean registriert, boolean aktiv
					boolean registriert = false;
					
					String benutzername = gui.tabelle.getValueAt(
							gui.tabelle.getSelectedRow(), 0).toString();
					String nachname = gui.tabelle.getValueAt(
							gui.tabelle.getSelectedRow(), 1).toString();
					String rolle = gui.tabelle.getValueAt(
							gui.tabelle.getSelectedRow(), 2).toString();
					String fachgruppe = gui.tabelle.getValueAt(
							gui.tabelle.getSelectedRow(), 3).toString();
					
					
					if (gui.tabelle.getValueAt(gui.tabelle.getSelectedRow(), 4)
							.toString().equals("true")) {
						registriert = true;
					}
					
					if (gui.tabelle.getValueAt(gui.tabelle.getSelectedRow(), 5)
							.toString().equals("false")) {
						aktiv = false;
					}

					gui.startansichtController.aenderAktUser(benutzername,
							nachname,rolle, fachgruppe, registriert,aktiv);

				}
			}
		}
	}
}
