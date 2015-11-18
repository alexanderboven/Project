package details;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class NeuePrfg extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	public NeuePrfg() {
		setTitle("Neue Pr\u00FCfung");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Modul:");
		lblNewLabel.setBounds(21, 26, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Bezeichnung:");
		lblNewLabel_1.setBounds(21, 51, 64, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Status:");
		lblNewLabel_2.setBounds(21, 80, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Datum:");
		lblNewLabel_3.setBounds(21, 105, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Raum:");
		lblNewLabel_4.setBounds(21, 130, 46, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Anmeldezahl:");
		lblNewLabel_5.setBounds(21, 155, 64, 14);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_7 = new JLabel("Semester:");
		lblNewLabel_7.setBounds(21, 180, 64, 14);
		getContentPane().add(lblNewLabel_7);
		
		textField = new JTextField();
		textField.setBounds(138, 23, 117, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(138, 48, 117, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("aktiv");
		chckbxNewCheckBox.setBounds(138, 76, 97, 23);
		getContentPane().add(chckbxNewCheckBox);
		
		textField_2 = new JTextField();
		textField_2.setBounds(138, 127, 117, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(138, 102, 117, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(138, 152, 117, 20);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(138, 177, 117, 20);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setBounds(189, 208, 89, 23);
		getContentPane().add(btnOk);
	}
}
