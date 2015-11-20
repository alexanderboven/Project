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
import java.util.Date;
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

	ListSelectionListener myListSelectionListener;
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
		lblName.setBounds(10, 41, 67, 14);
		getContentPane().add(lblName);

		JLabel lblJlblname = new JLabel(name);
		lblJlblname.setHorizontalAlignment(SwingConstants.LEFT);
		lblJlblname.setBounds(109, 41, 113, 14);
		getContentPane().add(lblJlblname);

		JLabel lblNewLabel = new JLabel("Rolle:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 66, 67, 14);
		getContentPane().add(lblNewLabel);

		JLabel lblLblrolle = new JLabel(rolle);
		lblLblrolle.setHorizontalAlignment(SwingConstants.LEFT);
		lblLblrolle.setBounds(109, 66, 128, 14);
		getContentPane().add(lblLblrolle);

		JSeparator separator = new JSeparator();
		separator.setBounds(31, 91, 257, 2);
		getContentPane().add(separator);

		JLabel lblBenutzer = new JLabel("Benutzer:");
		lblBenutzer.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBenutzer.setBounds(10, 16, 67, 14);
		getContentPane().add(lblBenutzer);

		JLabel lblLblbenutzer = new JLabel(nutzername);
		lblLblbenutzer.setHorizontalAlignment(SwingConstants.LEFT);
		lblLblbenutzer.setBounds(109, 16, 169, 14);
		getContentPane().add(lblLblbenutzer);

		//if (rolle == "Admin" || rolle == "Fachgruppenreferent") {
			
			btnBearbeiten = new JButton("Bearbeiten");
			btnBearbeiten.setBounds(657, 289, 113, 23);
			getContentPane().add(btnBearbeiten);
			btnBearbeiten.addActionListener(actionlistener);

			btnNeu = new JButton("Neu");
			btnNeu.addActionListener(actionlistener);
			btnNeu.setBounds(556, 289, 89, 23);
			getContentPane().add(btnNeu);

			JRadioButton rbtnEigene = new JRadioButton("eigene Pr\u00FCfungen");
			rbtnEigene.setSelected(true);
			buttonGroup.add(rbtnEigene);
			rbtnEigene.setBounds(31, 127, 128, 23);
			getContentPane().add(rbtnEigene);

			JRadioButton rbtnFachgruppe = new JRadioButton(
					"Pr\u00FCfungen Fachgruppe");
			buttonGroup.add(rbtnFachgruppe);
			rbtnFachgruppe.setBounds(161, 127, 161, 23);
			getContentPane().add(rbtnFachgruppe);
		//}
		setBounds(100, 100, 796, 400);

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
				
				JMenu mnExport = new JMenu("Export");
				menuBar.add(mnExport);
				
				JMenuItem mntmExportieren = new JMenuItem("Exportieren");
				mnExport.add(mntmExportieren);

		
		

		//}

		ActionListener myActionListener = new MyActionListener(this, con);
		

		DefaultTableModel tm = startansichtController.aendereTm("pruefung");
		tabelle = new Tabelle("pruefung", tm);
		((JComponent) tabelle.getDefaultRenderer(Boolean.class)).setOpaque(true);
		tm.fireTableDataChanged();
		tm.fireTableStructureChanged();
		
		validate();
		
		
		myListSelectionListener = new MyListSelectionListener(
				this);
		tabelle.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listmodel = tabelle.getSelectionModel();
		listmodel.addListSelectionListener(myListSelectionListener);

		
		
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
		
		
		JScrollPane sp = new JScrollPane(tabelle);
		sp.setBounds(31, 157, 739, 121);
		
		
		Date frist = startansichtController.getFrist("SoSe161");
		Date serverdatum = startansichtController.getServerDatum();
		System.out.println("Server: " + serverdatum);
		System.out.println("Frist: " + frist);
		
		getContentPane().add(sp);

		JLabel lblSuchen = new JLabel("Suchen:");
		lblSuchen.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSuchen.setBounds(0, 104, 77, 16);
		getContentPane().add(lblSuchen);

		searchText = new JTextField();
		searchText.setBounds(100, 100, 86, 20);
		getContentPane().add(searchText);
		searchText.setColumns(10);
		
		JRadioButton rdbtnAllePrfungen = new JRadioButton("alle Pr\u00FCfungen");
		buttonGroup.add(rdbtnAllePrfungen);
		rdbtnAllePrfungen.setBounds(324, 127, 109, 23);
		getContentPane().add(rdbtnAllePrfungen);
		DocumentListener mySearchListener = new MySearchListener(this);
		searchText.getDocument().addDocumentListener(mySearchListener);
	}
}
