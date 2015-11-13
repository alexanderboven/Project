package details;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class RolleDet extends JFrame {
	private JTextField textField;
	private JTable table;
	public RolleDet() {
		setTitle("Rolle Detailansicht");
		getContentPane().setLayout(null);
		
		JLabel lblBezeichnung = new JLabel("Bezeichnung:");
		lblBezeichnung.setBounds(32, 11, 76, 14);
		getContentPane().add(lblBezeichnung);
		
		textField = new JTextField();
		textField.setBounds(119, 8, 141, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnHinzufgen = new JButton("Hinzuf\u00FCgen");
		btnHinzufgen.setBounds(270, 7, 89, 23);
		getContentPane().add(btnHinzufgen);
		
		JScrollPane sp = new JScrollPane();
		sp.setBounds(32, 36, 323, 88);
		getContentPane().add(sp);
		
		table = new JTable();
		sp.setViewportView(table);
		
		JButton btnLschen = new JButton("L\u00F6schen");
		btnLschen.setBounds(270, 135, 89, 23);
		getContentPane().add(btnLschen);
		
		JButton btnSpeichern = new JButton("Speichern");
		btnSpeichern.setBounds(169, 135, 89, 23);
		getContentPane().add(btnSpeichern);
	}

}
