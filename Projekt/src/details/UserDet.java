package details;

import gui.Startansicht;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;

import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.UserDetController;

public class UserDet extends JFrame{
	private JTextField textNutzername;
	private JTextField textName;
	private JTable table;
	private UserDetController controller;
	public UserDet(String name, final String nutzername, String rolle,boolean aktiv, final Connection con) {
		setTitle("Nutzer Detailansicht");
		getContentPane().setLayout(null);
		setBounds(100, 100, 325, 226);
		
		controller = new UserDetController(con);
		JLabel lblName = new JLabel("Name:");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(-14, 29, 105, 14);
		getContentPane().add(lblName);
		
		JLabel lblBenutzername = new JLabel("Benutzername:");
		lblBenutzername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBenutzername.setBounds(10, 54, 81, 14);
		getContentPane().add(lblBenutzername);
		
		textNutzername = new JTextField(nutzername);
		textNutzername.setBounds(160, 51, 120, 20);
		getContentPane().add(textNutzername);
		textNutzername.setColumns(10);
		
		textName = new JTextField(name);
		textName.setBounds(160, 26, 120, 20);
		getContentPane().add(textName);
		textName.setColumns(10);
		
		JLabel lblRolle = new JLabel("Rolle:");
		lblRolle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRolle.setBounds(45, 79, 46, 14);
		getContentPane().add(lblRolle);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Dozent", "Fachgruppenreferent", "Admin"}));
		comboBox.setBounds(160, 76, 120, 20);
		getContentPane().add(comboBox);
		
		JButton btnSpeichern = new JButton("Speichern");
		btnSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Datenbankcommandos
				// Treemap Komando
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							setVisible(false);
							dispose();
							Startansicht frame = new Startansicht(nutzername, con);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
						
					}
				});
				
			}
		});
		btnSpeichern.setBounds(45, 309, 120, 23);
		getContentPane().add(btnSpeichern);
		setBounds(100, 100, 677, 400);
		JButton btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.setBounds(175, 309, 105, 23);
		getContentPane().add(btnAbbrechen);
		
		JCheckBox chckbxAktiv = new JCheckBox("aktiv");
		chckbxAktiv.setBounds(160, 100, 97, 23);
		chckbxAktiv.setSelected(aktiv);
		getContentPane().add(chckbxAktiv);
		
		JLabel lblAktivitt = new JLabel("Aktivit\u00E4t:");
		lblAktivitt.setBounds(45, 104, 46, 14);
		getContentPane().add(lblAktivitt);
		
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(14, 133, 266, 20);
		getContentPane().add(separator);
		
		String[]headder = controller.getHeadder();
		Object[][]data = controller.getData(nutzername);
		DefaultTableModel dtm = new DefaultTableModel(data, headder);
		
		JScrollPane sp = new JScrollPane();
		table = new JTable(dtm);
		sp.setBounds(10, 144, 270, 106);
		sp.add(table);
		getContentPane().add(sp);
		
		
		JButton btnHinzufgen = new JButton("Hinzuf\u00FCgen");
		btnHinzufgen.setBounds(20, 261, 89, 23);
		getContentPane().add(btnHinzufgen);
		
		JButton btnEntfernen = new JButton("Entfernen");
		btnEntfernen.setBounds(119, 261, 89, 23);
		getContentPane().add(btnEntfernen);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 295, 270, 14);
		getContentPane().add(separator_1);
		
		JLabel lblInformationenber = new JLabel("// Informationen \u00FCber die Fachgruppen des Users");
		lblInformationenber.setBounds(290, 168, 237, 14);
		getContentPane().add(lblInformationenber);
	}
}
