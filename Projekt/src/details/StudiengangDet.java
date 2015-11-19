package details;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;

import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JTable;

import Controller.AnmeldeGUIController;
import Controller.StudiengangDetController;

public class StudiengangDet extends JFrame{
	private JTextField txtBezeichnung;
	private JTable table;
	private StudiengangDetController controller;
	private JTextField textField;
	
	public StudiengangDet(final String bezeichnung, boolean aktiv, Connection con) {
		setTitle("Detailansicht Studiengang");
		getContentPane().setLayout(null);
		controller = new StudiengangDetController(con);
		
		txtBezeichnung = new JTextField();
		txtBezeichnung.setBounds(117, 27, 120, 20);
		getContentPane().add(txtBezeichnung);
		txtBezeichnung.setColumns(10);
		
		JButton btnSpeichern = new JButton("Speichern");
		btnSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSpeichern.setBounds(54, 329, 120, 23);
		getContentPane().add(btnSpeichern);
		
		JButton btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAbbrechen.setBounds(195, 329, 110, 23);
		getContentPane().add(btnAbbrechen);
		
		JLabel lblBezeichnung = new JLabel("Bezeichnung:");
		lblBezeichnung.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBezeichnung.setBounds(10, 30, 86, 14);
		getContentPane().add(lblBezeichnung);
		
		JLabel lblAktivitt = new JLabel("Aktivit\u00E4t:");
		lblAktivitt.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAktivitt.setBounds(33, 92, 63, 14);
		getContentPane().add(lblAktivitt);
		
		JCheckBox chckbxAktiv = new JCheckBox("aktiv");
		chckbxAktiv.setBounds(117, 88, 97, 23);
		getContentPane().add(chckbxAktiv);
		
		JButton btnHinzufgen = new JButton("Hinzuf\u00FCgen");
		btnHinzufgen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ModulHinzufuegen frame = new ModulHinzufuegen(controller, bezeichnung);
				frame.setVisible(true);
				
			}});
		
				
				
				
				
		
		btnHinzufgen.setBounds(33, 281, 89, 23);
		getContentPane().add(btnHinzufgen);
		
		JButton btnEntfernen = new JButton("Entfernen");
		btnEntfernen.setBounds(125, 281, 89, 23);
		getContentPane().add(btnEntfernen);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(33, 117, 243, 8);
		getContentPane().add(separator);
		
		
		String[] header = controller.getHeader(); // Array mit den Überschriften der Tabelle
		Object[][] data = controller.getData(bezeichnung); // 2D-Array mit den Daten der Module
		
		DefaultTableModel dtm = new DefaultTableModel(data, header){
			Class[] columnTypes = new Class[] {Object.class,Object.class};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};
		JScrollPane sp = new JScrollPane(); //um in der Tabelle zu scrollen
		// Tabelle mit den Moduldaten des Studiengangs
		table = new JTable(dtm);
		sp.setBounds(33, 136, 265, 134);
		sp.add(table);
		getContentPane().add(sp);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(33, 315, 258, 14);
		getContentPane().add(separator_1);
		
		JLabel lblKrzel = new JLabel("K\u00FCrzel:");
		lblKrzel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKrzel.setBounds(20, 55, 72, 14);
		getContentPane().add(lblKrzel);
		
		textField = new JTextField();
		textField.setBounds(117, 52, 120, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
	}
	
	public static void main(String[] args){
		final AnmeldeGUIController contr = new AnmeldeGUIController();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudiengangDet frame = new StudiengangDet("WIF", true, contr.getConnection());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
