package details;

import gui.Startansicht;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import Controller.ersterLoginController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class ersterLogin extends JFrame {
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private ersterLoginController controller;

	public ersterLogin(final String nutzername, final Connection con) {
		controller = new ersterLoginController(con);
		setTitle("erster Login");
		getContentPane().setLayout(null);
		setBounds(100,100,480,186);
		
		JLabel lblNewLabel = new JLabel(
				"Bitte geben Sie nach dem erstmaligen Einloggen ein neues Passwort ein.");
		lblNewLabel.setBounds(24, 22, 429, 14);
		getContentPane().add(lblNewLabel);

		JLabel lblPasswort = new JLabel("Passwort:");
		lblPasswort.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPasswort.setBounds(10, 47, 98, 14);
		getContentPane().add(lblPasswort);

		JLabel lblWiederholen = new JLabel("Wiederholen:");
		lblWiederholen.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWiederholen.setBounds(29, 81, 79, 14);
		getContentPane().add(lblWiederholen);

		passwordField = new JPasswordField();
		passwordField.setBounds(154, 47, 115, 20);
		getContentPane().add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(154, 78, 115, 20);
		getContentPane().add(passwordField_1);

		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				char[] pw1 = passwordField.getPassword();
				char[] pw2 = passwordField_1.getPassword();
				if (Arrays.equals(pw1, pw2)) {
					
					
					
					if (pw1.length > 5) {
						controller.setRegistriert(nutzername);
						controller.setPasswort(nutzername);
						JOptionPane.showMessageDialog(null,
								"Das Passwort wurde erfolgreich geändert.",
								"Passwort geändert", JOptionPane.PLAIN_MESSAGE);
						Startansicht frame = new Startansicht(nutzername, con);
						frame.setVisible(true);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Ihr Passwort muss länger als 5 Zeichen sein.", "Passwort zu kurz", JOptionPane.ERROR_MESSAGE);
					}
					
					
				} else {
					JOptionPane.showMessageDialog(null, "Passwörter nicht identisch.", "Passwörter nicht identisch", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnOk.setBounds(180, 109, 89, 23);
		getContentPane().add(btnOk);
	}
}
