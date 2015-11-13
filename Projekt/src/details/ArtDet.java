package details;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class ArtDet extends JFrame {
	private JTextField textField;
	private JTable table;
	public ArtDet() {
		setTitle("Art Detailansicht");
		getContentPane().setLayout(null);
		
		JLabel lblBezeichnung = new JLabel("Bezeichnung:");
		lblBezeichnung.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBezeichnung.setBounds(-14, 23, 111, 14);
		getContentPane().add(lblBezeichnung);
		
		textField = new JTextField();
		textField.setBounds(123, 20, 141, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JScrollPane sp = new JScrollPane();
		sp.setBounds(39, 65, 336, 82);
		getContentPane().add(sp);
		
		table = new JTable();
		sp.setViewportView(table);
		
		JButton btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.setBounds(187, 158, 89, 23);
		getContentPane().add(btnAbbrechen);
		
		JButton btnLschen = new JButton("L\u00F6schen");
		btnLschen.setBounds(286, 158, 89, 23);
		getContentPane().add(btnLschen);
		
		JButton btnHinzufgen = new JButton("Hinzuf\u00FCgen");
		btnHinzufgen.setBounds(286, 19, 89, 23);
		getContentPane().add(btnHinzufgen);
		
		JButton btnSpeichern = new JButton("Speichern");
		btnSpeichern.setBounds(88, 158, 89, 23);
		getContentPane().add(btnSpeichern);
	}
}
