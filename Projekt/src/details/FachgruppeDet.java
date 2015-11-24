package details;

import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JSeparator;

public class FachgruppeDet extends JFrame{
	private JTextField textField;
	private JTable tabelleModule;
	private JTable tabelleUser;

	public FachgruppeDet(String name, String referent, boolean aktiv, Connection con){
		setTitle("Detailansicht Fachgruppe");
		getContentPane().setLayout(null);
		
		JLabel lblBezeichnung = new JLabel("Bezeichnung:");
		lblBezeichnung.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBezeichnung.setBounds(0, 14, 88, 14);
		getContentPane().add(lblBezeichnung);
		
		textField = new JTextField();
		textField.setBounds(110, 11, 121, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblAktivitit = new JLabel("Aktiviti\u00E4t:");
		lblAktivitit.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAktivitit.setBounds(18, 39, 70, 14);
		getContentPane().add(lblAktivitit);
		
		JCheckBox chckbxAktiv = new JCheckBox("aktiv");
		chckbxAktiv.setBounds(110, 38, 97, 23);
		getContentPane().add(chckbxAktiv);
		
		JButton btnSpeichern = new JButton("Speichern");
		btnSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSpeichern.setBounds(142, 398, 89, 23);
		getContentPane().add(btnSpeichern);
		
		JButton btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.setBounds(246, 398, 89, 23);
		getContentPane().add(btnAbbrechen);
		
		JButton btnHinzufgen = new JButton("Hinzuf\u00FCgen");
		btnHinzufgen.setBounds(172, 207, 89, 23);
		getContentPane().add(btnHinzufgen);
		
		JButton btnEntfernen = new JButton("Entfernen");
		btnEntfernen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEntfernen.setBounds(73, 207, 89, 23);
		getContentPane().add(btnEntfernen);
		
		
		
		JScrollPane scp1 = new JScrollPane();
		scp1.setBounds(73, 93, 262, 92);
		tabelleModule = new JTable();
		scp1.add(tabelleModule);
		getContentPane().add(scp1);
		
		
		JScrollPane scp2 = new JScrollPane();
		tabelleUser = new JTable();
		scp2.setBounds(73, 251, 262, 92);
		scp2.add(tabelleUser);
		getContentPane().add(scp2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(40, 239, 306, 2);
		getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(40, 76, 313, 2);
		getContentPane().add(separator_1);
		
		JButton btnEntfernen_1 = new JButton("Entfernen");
		btnEntfernen_1.setBounds(73, 354, 89, 23);
		getContentPane().add(btnEntfernen_1);
		
		JButton btnHinzufgen_1 = new JButton("Hinzuf\u00FCgen");
		btnHinzufgen_1.setBounds(172, 354, 89, 23);
		getContentPane().add(btnHinzufgen_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(40, 386, 306, 2);
		getContentPane().add(separator_2);
		
		JLabel lblNewLabel = new JLabel("// Tabelle mit Modulen der FG");
		lblNewLabel.setBounds(345, 130, 211, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblTabelleMit = new JLabel("// Tabelle mit Usern der FG");
		lblTabelleMit.setBounds(365, 275, 128, 14);
		getContentPane().add(lblTabelleMit);
		
		
	}
}
