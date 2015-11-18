package gui;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.util.TreeMap;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import details.PruefungDet;
import details.Selbstinformation;
import details.UserDet;

import javax.swing.JMenu;

import Controller.StartansichtController;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import model.Pruefung;

import javax.swing.JTextField;

public class Startansicht extends JFrame {

	ListSelectionModel listmodel;
	Tabelle tabelle;

	TableRowSorter<DefaultTableModel> sorter;
	StartansichtController startansichtController;
	final ButtonGroup buttonGroup = new ButtonGroup();
	
	JButton btnBearbeiten;
	JButton btnNeu;
	MyActionListener actionlistener;
	
	JMenuItem mntmModule;
	JMenuItem mntmPrfungen;
	JMenuItem mntmStudiengnge;
	JMenuItem mntmFachgruppen;
	JMenuItem mntmNutzer;
	JMenuItem mntmPrferkonstellationen;
	
	JMenuItem mntmPrfungsarten;
	JMenuItem mntmRollen;
	JMenuItem mntmPrfungszeitraum;
	JMenuItem mntmNeuesSemesterEinrichten;
	
	JTextField searchText;

	public Startansicht(String nutzername, final Connection con) {
		// Abfrage der Rolle des angemeldeten Nutzers
		String rolle;
		String name;
		startansichtController = new StartansichtController(con);
		rolle = startansichtController.bestimmeRolle(nutzername, con);
		name = startansichtController.bestimmeName(nutzername, con);
		
		
		
		
		actionlistener = new MyActionListener(this, con);

		setTitle("Pr\u00FCfungsverwaltung");
		getContentPane().setLayout(null);

		JLabel lblName = new JLabel("Name:");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(31, 41, 46, 14);
		getContentPane().add(lblName);

		JLabel lblJlblname = new JLabel(name);
		lblJlblname.setHorizontalAlignment(SwingConstants.LEFT);
		lblJlblname.setBounds(109, 41, 46, 14);
		getContentPane().add(lblJlblname);

		JLabel lblNewLabel = new JLabel("Rolle:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(31, 66, 46, 14);
		getContentPane().add(lblNewLabel);

		JLabel lblLblrolle = new JLabel(rolle);
		lblLblrolle.setHorizontalAlignment(SwingConstants.LEFT);
		lblLblrolle.setBounds(109, 66, 46, 14);
		getContentPane().add(lblLblrolle);

		JSeparator separator = new JSeparator();
		separator.setBounds(31, 91, 586, 2);
		getContentPane().add(separator);

		JLabel lblBenutzer = new JLabel("Benutzer:");
		lblBenutzer.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBenutzer.setBounds(10, 16, 67, 14);
		getContentPane().add(lblBenutzer);

		JLabel lblLblbenutzer = new JLabel(nutzername);
		lblLblbenutzer.setHorizontalAlignment(SwingConstants.LEFT);
		lblLblbenutzer.setBounds(109, 16, 77, 14);
		getContentPane().add(lblLblbenutzer);

		//if (rolle == "Admin" || rolle == "Fachgruppenreferent") {
			
			btnBearbeiten = new JButton("Bearbeiten");
			btnBearbeiten.setBounds(504, 266, 113, 23);
			getContentPane().add(btnBearbeiten);
			btnBearbeiten.addActionListener(actionlistener);

			btnNeu = new JButton("Neu");
			btnNeu.addActionListener(actionlistener);
			btnNeu.setBounds(405, 266, 89, 23);
			getContentPane().add(btnNeu);

			JRadioButton rbtnEigene = new JRadioButton("eigene Pr\u00FCfungen");
			rbtnEigene.setSelected(true);
			buttonGroup.add(rbtnEigene);
			rbtnEigene.setBounds(31, 104, 155, 23);
			getContentPane().add(rbtnEigene);

			JRadioButton rbtnFachgruppe = new JRadioButton(
					"Pr\u00FCfungen Fachgruppe");
			buttonGroup.add(rbtnFachgruppe);
			rbtnFachgruppe.setBounds(185, 104, 161, 23);
			getContentPane().add(rbtnFachgruppe);
		//}
		setBounds(100, 100, 677, 400);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnEinstellungen = new JMenu("Einstellungen");
		menuBar.add(mnEinstellungen);

		JMenuItem nutzerInformationen = new JMenuItem("Benutzerinformationen");
		nutzerInformationen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							String name = null;
							String nutzername = null;
							String rolle = null;
							Selbstinformation frame = new Selbstinformation(
									nutzername, con);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}

					}
				});

			}
		});

		mnEinstellungen.add(nutzerInformationen);

		//if (rolle == "Admin" || rolle == "Fachgruppenreferent") {

			JMenu mnBearbeiten = new JMenu("Bearbeiten");
			menuBar.add(mnBearbeiten);

			//if (rolle == "Admin") {

				mntmModule = new JMenuItem("Module");
				mntmModule.addActionListener(actionlistener);
				mnBearbeiten.add(mntmModule);

				mntmNutzer = new JMenuItem("Nutzer");
				mntmNutzer.addActionListener(actionlistener);
				mnBearbeiten.add(mntmNutzer);

				mntmStudiengnge = new JMenuItem("Studieng\u00E4nge");
				mnBearbeiten.add(mntmStudiengnge);

				mntmFachgruppen = new JMenuItem("Fachgruppen");

				mnBearbeiten.add(mntmFachgruppen);
				mntmPrfungen = new JMenuItem("Pr\u00FCfungen");
				mnBearbeiten.add(mntmNutzer);	
				
				
				mntmPrfungen = new JMenuItem("Pr\u00FCfungen");
				mnBearbeiten.add(mntmPrfungen);
				

					mnBearbeiten.add(mntmPrfungen);
				
				
					
					
				mntmPrferkonstellationen = new JMenuItem("Pr\u00FCferkonstellationen");
				mnBearbeiten.add(mntmPrferkonstellationen);
				
				JMenu mnVerwalten = new JMenu("Verwalten");
				menuBar.add(mnVerwalten);
				
				mntmPrfungsarten = new JMenuItem("Pr\u00FCfungsarten");
				mnVerwalten.add(mntmPrfungsarten);
				
				mntmRollen = new JMenuItem("Rollen");
				mnVerwalten.add(mntmRollen);
				
				mntmPrfungszeitraum = new JMenuItem("Pr\u00FCfungszeitraum");
				mnVerwalten.add(mntmPrfungszeitraum);
				
				mntmNeuesSemesterEinrichten = new JMenuItem("neues Semester einrichten");
				mnVerwalten.add(mntmNeuesSemesterEinrichten);

		
		

		//}

		ActionListener myActionListener = new MyActionListener(this, con);
		ListSelectionListener myListSelectionListener = new MyListSelectionListener(
				this);

		DefaultTableModel tm = startansichtController.aendereTm("pruefung");
		tabelle = new Tabelle("pruefung", tm);
		((JComponent) tabelle.getDefaultRenderer(Boolean.class)).setOpaque(true);
		tm.fireTableDataChanged();
		tm.fireTableStructureChanged();
		
		validate();
		
		
		
		tabelle.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		/* sorter = new TableRowSorter<MyTableModel>(tm);
		 tabelle.setRowSorter(sorter);
		
		sorter.setComparator(2, new DateComparator());
		sorter.setComparator(1, new IntegerComparator());
		*/
		
		/*
		 * Farbgestaltung der Tabelle wird durch Verwendung der Klasse
		 * ColoredTableCellRenderer definiert. Jede zweite Zeile wird farblich
		 * hervorgehoben. Wird eine Zeile ausgewählt, wird dies wiederum durch
		 * eine farbliche Hervorhebung angezeigt.
		 */

		/*
		 * Damit eine Tabelle ein Event auslöst, sobald eine Zeile ausgewählt
		 * ist, ist es erforderlich, eine Variable der Klasse ListSelectionModel
		 * zu deklarieren und diese mit dem SelectionModel der Tabelle zu
		 * initialisieren. Diese Variable wird anschließen beim Eventhandler
		 * LisSelectionListener registriert.
		 */
		listmodel = tabelle.getSelectionModel();
		listmodel.addListSelectionListener(myListSelectionListener);

		
		JScrollPane sp = new JScrollPane(tabelle);
		// JScrollPane sp = new JScrollPane(tabelle);
		sp.add(tabelle);
		sp.setBounds(31, 134, 586, 121);

		
		getContentPane().add(sp);

		JLabel lblSuchen = new JLabel("Suchen");
		lblSuchen.setBounds(165, 270, 46, 14);
		getContentPane().add(lblSuchen);

		searchText = new JTextField();
		searchText.setBounds(226, 267, 86, 20);
		getContentPane().add(searchText);
		searchText.setColumns(10);
		DocumentListener mySearchListener = new MySearchListener(this);
		searchText.getDocument().addDocumentListener(mySearchListener);
	}
}
