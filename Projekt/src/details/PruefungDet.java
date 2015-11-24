package details;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.util.Date;

import javax.swing.JCheckBox;

public class PruefungDet extends JFrame{
	private JTextField txtPrfnr;
	private JTextField txtRaum;
	private JTextField txtDauer;
	private JTextField txtModul;
	private JTextField txtBez;
	
	
	public PruefungDet(String bezeichnung, String prf_id, String mod_id, String stdg_id, String sem_id, String erstpruefer, String zweitpruefer, Date datum, int dauer, String art, String raum, 
			int teilnehmerzahl, boolean aktiv, Connection con) {
		setTitle("Detailansicht Pr\u00FCfung");
		getContentPane().setLayout(null);
		
		JLabel lblPrfnr = new JLabel("Prf.Nr.:");
		lblPrfnr.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrfnr.setBounds(10, 22, 63, 14);
		getContentPane().add(lblPrfnr);
		
		JLabel lblDatum = new JLabel("Datum:");
		lblDatum.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDatum.setBounds(10, 271, 63, 14);
		getContentPane().add(lblDatum);
		
		JLabel lblRaum = new JLabel("Raum:");
		lblRaum.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRaum.setBounds(10, 184, 63, 14);
		getContentPane().add(lblRaum);
		
		JLabel lblForm = new JLabel("Form:");
		lblForm.setHorizontalAlignment(SwingConstants.RIGHT);
		lblForm.setBounds(7, 159, 66, 14);
		getContentPane().add(lblForm);
		
		JLabel lblDauer = new JLabel("Dauer:");
		lblDauer.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDauer.setBounds(15, 116, 58, 14);
		getContentPane().add(lblDauer);
		
		JLabel lblModul = new JLabel("Modul:");
		lblModul.setHorizontalAlignment(SwingConstants.RIGHT);
		lblModul.setBounds(10, 78, 63, 14);
		getContentPane().add(lblModul);
		
		txtPrfnr = new JTextField();
		txtPrfnr.setText("prfid");
		txtPrfnr.setBounds(124, 19, 120, 20);
		getContentPane().add(txtPrfnr);
		txtPrfnr.setColumns(10);
		
		txtRaum = new JTextField();
		txtRaum.setText("" + raum);
		txtRaum.setBounds(83, 181, 120, 20);
		getContentPane().add(txtRaum);
		txtRaum.setColumns(10);
		
		JLabel lbldatetimepicker = new JLabel("//DateTimePicker");
		lbldatetimepicker.setBounds(83, 271, 99, 14);
		getContentPane().add(lbldatetimepicker);
		
		JComboBox cbForm = new JComboBox();
		cbForm.setBounds(124, 141, 120, 20);
		getContentPane().add(cbForm);
		
		txtDauer = new JTextField();
		txtDauer.setText("" + dauer);
		txtDauer.setBounds(124, 110, 120, 20);
		getContentPane().add(txtDauer);
		txtDauer.setColumns(10);
		
		txtModul = new JTextField();
		txtModul.setText("modul");
		txtModul.setBounds(124, 75, 120, 20);
		getContentPane().add(txtModul);
		txtModul.setColumns(10);
		
		JLabel lblNurFr = new JLabel("// read-only");
		lblNurFr.setBounds(270, 209, 128, 14);
		getContentPane().add(lblNurFr);
		
		JButton btnSpeichern = new JButton("Speichern");
		btnSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSpeichern.setBounds(10, 485, 120, 23);
		getContentPane().add(btnSpeichern);
		
		JButton btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.setBounds(157, 485, 110, 23);
		getContentPane().add(btnAbbrechen);
		
		JLabel lblNurFr_1 = new JLabel("// nur f\u00FCr den Admin");
		lblNurFr_1.setBounds(270, 184, 144, 14);
		getContentPane().add(lblNurFr_1);
		
		txtBez = new JTextField();
		txtBez.setText("bez");
		txtBez.setBounds(124, 44, 120, 20);
		getContentPane().add(txtBez);
		txtBez.setColumns(10);
		
		JLabel lblBezeichnung = new JLabel("Bezeichnung:");
		lblBezeichnung.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBezeichnung.setBounds(-21, 47, 94, 14);
		getContentPane().add(lblBezeichnung);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(33, 313, 46, 14);
		getContentPane().add(lblStatus);
		
		JCheckBox chckbxAktiv = new JCheckBox("aktiv");
		chckbxAktiv.setBounds(106, 309, 97, 23);
		getContentPane().add(chckbxAktiv);
		if (aktiv){
			System.out.println(aktiv + "");
			chckbxAktiv.setSelected(true);
		}else {
			System.out.println(aktiv + "");
			chckbxAktiv.setSelected(false);
		}
		setBounds(100, 100, 583, 557);
		
		
		
	}
}
