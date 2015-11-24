package details;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;

import javax.swing.JTextPane;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class ModulDet extends JFrame{
	private JTextField txtModbez;
	private JTextField txtModnr;
	private JTable table;
	private JTextField textField;
	public ModulDet(String bezeichnung, String modNr, String fachgruppe, boolean aktiv, Connection con) {
		setTitle("Detailansicht Modul");
		getContentPane().setLayout(null);
		setBounds(100, 100, 508, 562);
		
		JLabel lblBezeichnung = new JLabel("Bezeichnung:");
		lblBezeichnung.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBezeichnung.setBounds(-18, 27, 108, 14);
		getContentPane().add(lblBezeichnung);
		
		JLabel lblModulnummer = new JLabel("Modulnummer:");
		lblModulnummer.setHorizontalAlignment(SwingConstants.RIGHT);
		lblModulnummer.setBounds(-40, 52, 130, 14);
		getContentPane().add(lblModulnummer);
		
		txtModbez = new JTextField(bezeichnung);
		txtModbez.setBounds(110, 24, 120, 20);
		getContentPane().add(txtModbez);
		txtModbez.setColumns(10);
		
		txtModnr = new JTextField(modNr);
		txtModnr.setBounds(110, 49, 120, 20);
		getContentPane().add(txtModnr);
		txtModnr.setColumns(10);
		
		JButton btnNewButton = new JButton("Speichern");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(87, 368, 120, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Abbrechen");
		btnNewButton_1.setBounds(209, 368, 115, 23);
		getContentPane().add(btnNewButton_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(17, 149, 269, 2);
		getContentPane().add(separator);
		
		JLabel lblAktivitt = new JLabel("Aktivit\u00E4t:");
		lblAktivitt.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAktivitt.setBounds(17, 124, 73, 14);
		getContentPane().add(lblAktivitt);
		
		JCheckBox chckbxAktiv = new JCheckBox("aktiv");
		chckbxAktiv.setBounds(110, 119, 97, 23);
		chckbxAktiv.setSelected(aktiv);
		getContentPane().add(chckbxAktiv);
		
		JButton btnHinzufgen = new JButton("Hinzuf\u00FCgen");
		btnHinzufgen.setBounds(22, 309, 89, 23);
		getContentPane().add(btnHinzufgen);
		
		JButton btnLschen = new JButton("L\u00F6schen");
		btnLschen.setBounds(118, 309, 89, 23);
		getContentPane().add(btnLschen);
		
		JScrollPane sp = new JScrollPane();
		table = new JTable();
		sp.setBounds(22, 167, 295, 131);
		sp.add(table);
		getContentPane().add(sp);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(29, 343, 292, 14);
		getContentPane().add(separator_1);
		
		JLabel lblTabelleMit = new JLabel("// Tabelle mit prfg des Moduls");
		lblTabelleMit.setBounds(334, 139, 135, 14);
		getContentPane().add(lblTabelleMit);
		
		textField = new JTextField();
		textField.setBounds(110, 84, 120, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblFachgruppe = new JLabel("Fachgruppe:");
		lblFachgruppe.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFachgruppe.setBounds(0, 87, 89, 14);
		getContentPane().add(lblFachgruppe);
		
		JLabel lblReadonly = new JLabel("// read-only");
		lblReadonly.setBounds(267, 87, 87, 14);
		getContentPane().add(lblReadonly);
		
	}
}
