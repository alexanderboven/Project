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

				switch (klasse) {

				case "pruefung":
					// Auslesen der Werte in den Zellen
					int prfnr = Integer.parseInt((String) gui.tabelle
							.getValueAt(gui.tabelle.getSelectedRow(), 0));
					int dauer = Integer.parseInt((String) gui.tabelle
							.getValueAt(gui.tabelle.getSelectedRow(), 1));
					String prfForm = gui.tabelle.getValueAt(
							gui.tabelle.getSelectedRow(), 2).toString();

					DateFormat df = new SimpleDateFormat("dd.mm.yyyy");
					Date datum = null;
					try {
						datum = df.parse((String) gui.tabelle.getValueAt(
								gui.tabelle.getSelectedRow(), 3));
					} catch (ParseException e) {

						e.printStackTrace();
					}

					String raum = gui.tabelle.getValueAt(
							gui.tabelle.getSelectedRow(), 4).toString();

					if (gui.tabelle.getValueAt(gui.tabelle.getSelectedRow(), 4)
							.toString() == "false") {
						aktiv = false;
					}

					// aktualisieren des Obejektes, welches die aktuell
					// ausgewählte Prüfung darstellt
					gui.startansichtController.aenderAktPruefung(prfnr, datum,
							prfForm, dauer, raum, aktiv);

				case "modul":
					String modbez = gui.tabelle.getValueAt(
							gui.tabelle.getSelectedRow(), 0).toString();
					int modnr = Integer.parseInt((String) gui.tabelle
							.getValueAt(gui.tabelle.getSelectedRow(), 1));
					if (gui.tabelle.getValueAt(gui.tabelle.getSelectedRow(), 2)
							.toString() == "false") {
						aktiv = false;
					}
					gui.startansichtController.aenderAktModul(modbez, modnr,
							aktiv);

				case "fachgruppe":
					String bezeichnung = gui.tabelle.getValueAt(
							gui.tabelle.getSelectedRow(), 0).toString();
					if (gui.tabelle.getValueAt(gui.tabelle.getSelectedRow(), 1)
							.toString() == "false") {
						aktiv = false;
					}
					gui.startansichtController.aenderAktFachgruppe(bezeichnung,
							aktiv);

				case "studiengang":
					String bez = gui.tabelle.getValueAt(
							gui.tabelle.getSelectedRow(), 0).toString();
					;
					if (gui.tabelle.getValueAt(gui.tabelle.getSelectedRow(), 1)
							.toString() == "false") {
						aktiv = false;
					}
					gui.startansichtController.aenderAktStudiengang(bez, aktiv);

				case "prueferkonstellation":
					Studiengang[] studiengaenge = null;

					User erstpruefer = null;

					User[] zweitpruefer = null;

					Pruefung[] pruefungen = null;

					// gui.startansichtController.aenderPrufestkonst(studiengaenge,
					// erstpruefer, zweitpruefer, pruefungen);

				//	gui.startansichtController.aenderPrufestkonst(
				//			studiengaenge, erstpruefer, zweitpruefer,
				//			pruefungen);

				case "user":
					String benutzername = gui.tabelle.getValueAt(
							gui.tabelle.getSelectedRow(), 0).toString();
					char[] passwort = null;
					String nachname = gui.tabelle.getValueAt(
							gui.tabelle.getSelectedRow(), 1).toString();
					String rolle = gui.tabelle.getValueAt(
							gui.tabelle.getSelectedRow(), 2).toString();
					if (gui.tabelle.getValueAt(gui.tabelle.getSelectedRow(), 3)
							.toString() == "false") {
						aktiv = false;
					}

					gui.startansichtController.aenderAktUser(benutzername,
							passwort, nachname, rolle, aktiv);

				}
			}
		}
	}
}
