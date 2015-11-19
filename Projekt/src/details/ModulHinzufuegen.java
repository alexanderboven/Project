package details;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import Controller.StudiengangDetController;


public class ModulHinzufuegen extends JFrame {
	private JTable table;
	private StudiengangDetController controller;
	public ModulHinzufuegen(StudiengangDetController controller, String studiengang) {
		setTitle("Modul hinzufügen");
		getContentPane().setLayout(null);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(107, 228, 117, 29);
		getContentPane().add(btnOk);
		
		JButton btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.setBounds(238, 228, 117, 29);
		getContentPane().add(btnAbbrechen);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 12, 394, 205);
		getContentPane().add(scrollPane);
		
		
		String[] header = controller.getHeaderModHinzu();
		Object[][] data = controller.getAllModule(studiengang);
		DefaultTableModel dtm = new DefaultTableModel(data, header);
		
		table = new JTable(dtm);
		scrollPane.setViewportView(table);
	}
}
