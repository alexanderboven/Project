package details;

import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JSeparator;
import javax.swing.table.DefaultTableModel;

import Controller.PrueferkonstellationDetController;

public class PrueferkonstellationDet extends JFrame {
	private JTable tabellePrfg;
	private JTable table;
	private JTable table_1;
	private PrueferkonstellationDetController controller;

	public PrueferkonstellationDet(String modul, String erstpruefer,
			String zweitpruefer, Connection con, String nutzername) {
		setTitle("Pr\u00FCferkonstellation Detailansicht");
		getContentPane().setLayout(null);

		controller = new PrueferkonstellationDetController(con);

		final JComboBox cbModul = new JComboBox();
		cbModul.setBounds(107, 18, 124, 20);
		getContentPane().add(cbModul);

		JLabel lblModul = new JLabel("Modul:");
		lblModul.setHorizontalAlignment(SwingConstants.RIGHT);
		lblModul.setBounds(31, 21, 46, 14);
		getContentPane().add(lblModul);

		JScrollPane sp1 = new JScrollPane();
		tabellePrfg = new JTable();
		sp1.add(tabellePrfg);
		sp1.setBounds(20, 49, 272, 133);
		getContentPane().add(sp1);

		JButton btnHinzufgenPrf = new JButton("Hinzuf\u00FCgen");
		btnHinzufgenPrf.setBounds(30, 193, 89, 23);
		getContentPane().add(btnHinzufgenPrf);

		JButton btnEntfernenPrf = new JButton("Entfernen");
		btnEntfernenPrf.setBounds(129, 193, 89, 23);
		getContentPane().add(btnEntfernenPrf);

		JLabel lblErstprfer = new JLabel("Erstpr\u00FCfer:");
		lblErstprfer.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErstprfer.setBounds(-55, 249, 132, 14);
		getContentPane().add(lblErstprfer);

		JComboBox cbErstpr = new JComboBox();
		cbErstpr.setBounds(104, 246, 127, 20);
		getContentPane().add(cbErstpr);

		JScrollPane sp2 = new JScrollPane();
		table = new JTable();
		sp2.setBounds(20, 287, 272, 133);
		sp2.add(table);
		getContentPane().add(sp2);

		JButton btnHinzufgenZwtPrf = new JButton("Hinzuf\u00FCgen");
		btnHinzufgenZwtPrf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnHinzufgenZwtPrf.setBounds(31, 431, 89, 23);
		getContentPane().add(btnHinzufgenZwtPrf);

		JButton btnEntfernenZwtPrf = new JButton("Entfernen");
		btnEntfernenZwtPrf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEntfernenZwtPrf.setBounds(129, 431, 89, 23);
		getContentPane().add(btnEntfernenZwtPrf);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 274, 295, 2);
		getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 224, 295, 14);
		getContentPane().add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(20, 474, 278, 2);
		getContentPane().add(separator_2);

		JScrollPane sp3 = new JScrollPane();
		table_1 = new JTable();
		sp3.add(table_1);
		sp3.setBounds(20, 487, 272, 133);
		getContentPane().add(sp3);

		JButton btnHinzufgen = new JButton("Hinzuf\u00FCgen");
		btnHinzufgen.setBounds(30, 631, 89, 23);
		getContentPane().add(btnHinzufgen);

		JButton btnEntfernen = new JButton("Entfernen");
		btnEntfernen.setBounds(129, 631, 89, 23);
		getContentPane().add(btnEntfernen);

		JButton btnSpeivhern = new JButton("Speichern");
		btnSpeivhern.setBounds(113, 693, 89, 23);
		getContentPane().add(btnSpeivhern);

		JButton btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.setBounds(212, 693, 89, 23);
		getContentPane().add(btnAbbrechen);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(31, 669, 272, 2);
		getContentPane().add(separator_3);

		JLabel lblPrfungen = new JLabel("// Pr\u00FCfungen");
		lblPrfungen.setBounds(356, 98, 97, 14);
		getContentPane().add(lblPrfungen);

		JLabel lblZweitprfer = new JLabel("// Zweitpr\u00FCfer");
		lblZweitprfer.setBounds(356, 326, 97, 14);
		getContentPane().add(lblZweitprfer);

		JLabel lblStudiengang = new JLabel("// Studieng\u00E4nge");
		lblStudiengang.setBounds(376, 504, 89, 14);
		getContentPane().add(lblStudiengang);

		cbModul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String modul = cbModul.getSelectedItem().toString();
				DefaultTableModel dtm = controller.bestimmeDtm(modul);
				tabellePrfg = new JTable(dtm);
			}
		});
		cbModul.setBounds(107, 18, 124, 20);
		getContentPane().add(cbModul);

		String fachgruppe = controller.getFachgruppe(nutzername);
		String[] modulbezeichnung = controller.getModule(fachgruppe);

		for (int i = 0; i < modulbezeichnung.length; i++) {
			cbModul.addItem(modulbezeichnung[i]);
		}

		
		String erstprüfer = controller.getErstpruefer(fachgruppe);
		

		for (int i = 0; i < modulbezeichnung.length; i++) {
			cbModul.addItem(modulbezeichnung[i]);
		}
		
		
	}

}
