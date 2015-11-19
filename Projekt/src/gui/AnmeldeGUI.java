package gui;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JSeparator;

import details.ersterLogin;
import Controller.AnmeldeGUIController;

public class AnmeldeGUI extends JFrame {
	private JPasswordField pfPasswort;
	private JTextField tfNutzer;
	private AnmeldeGUIController controller;

	public AnmeldeGUI() {

		controller = new AnmeldeGUIController();

		setTitle("Log-In Pr\u00FCfungsverwaltung");
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Benutzer");
		lblNewLabel.setBounds(30, 26, 46, 14);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Passwort");
		lblNewLabel_1.setBounds(30, 61, 46, 14);
		getContentPane().add(lblNewLabel_1);

		pfPasswort = new JPasswordField();
		pfPasswort.setBounds(107, 58, 131, 20);
		getContentPane().add(pfPasswort);

		tfNutzer = new JTextField("sleonardo");
		tfNutzer.setBounds(107, 23, 131, 20);
		getContentPane().add(tfNutzer);
		tfNutzer.setColumns(10);

		JButton btnEinloggen = new JButton("Einloggen");

		btnEinloggen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							String nutzername = tfNutzer.getText();
							char[] passwort = pfPasswort.getPassword();

							Connection con = controller.getConnection();

							if (con != null) {
								if (controller.passwortPruefen(nutzername,
										passwort)) {
									if (controller.nutzerAktiv(nutzername)) {

										if (!controller
												.nutzerRegistriert(nutzername)) {
											ersterLogin frame = new ersterLogin(
													nutzername, con);
											frame.setVisible(true);
										} else {
											Startansicht frame = new Startansicht(
													nutzername, con);
											frame.setVisible(true);

										}
										setVisible(false);
										dispose();

									} else {
										JOptionPane
												.showMessageDialog(
														null,
														"Der Nutzer "
																+ nutzername
																+ " ist nicht als aktiv gekennzeichnet.",
														"Log In Fehler",
														JOptionPane.ERROR_MESSAGE);
									}

								} else {
									JOptionPane.showMessageDialog(null,
											"Nutzername oder Passwort falsch.",
											"Log In Fehler",
											JOptionPane.ERROR_MESSAGE);
								}
							} else {
								System.out
										.println("Fehler bei der Erstellung des Connection-Objektes");
							}

						} catch (Exception e) {
							e.printStackTrace();
						}

					}
				});
			}
		});
		btnEinloggen.setBounds(179, 103, 90, 23);
		getContentPane().add(btnEinloggen);

		JButton btnBeenden = new JButton("Beenden");
		btnBeenden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				dispose();
				System.exit(0);
			}
		});
		btnBeenden.setBounds(279, 103, 89, 23);
		getContentPane().add(btnBeenden);

		JButton btnPasswortVergessen = new JButton("Passwort vergessen?");
		btnPasswortVergessen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,
						"Wenden Sie sich bitte an den Systemadministrator: \n"
								+ "     Sascha Leonardo \n"
								+ "     Raum B421 \n"
								+ "     sascha.leonardo@fh-bielefeld.de",
						"Passwort vergessen?", JOptionPane.OK_CANCEL_OPTION);
			}
		});
		btnPasswortVergessen.setBounds(29, 103, 140, 23);
		getContentPane().add(btnPasswortVergessen);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 86, 352, 2);
		getContentPane().add(separator);
		setBounds(100, 100, 400, 183);

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnmeldeGUI frame = new AnmeldeGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
