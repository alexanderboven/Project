package gui;

import java.awt.Font;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Tabelle extends JTable{
	private String klasse;
	private MyTableModel tm;
	
	public Tabelle(String klasse, DefaultTableModel tm){
		super(tm);
		
		setBounds(31, 134, 586, 121);
		this.klasse = klasse;
		setDefaultRenderer(Object.class,new MyTableCellRenderer());
		getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 12));
	}
	
	public void setKlasse(String klasse){
		this.klasse = klasse;
	}
	
	public String getKlasse(){
		return klasse;
	}
}
