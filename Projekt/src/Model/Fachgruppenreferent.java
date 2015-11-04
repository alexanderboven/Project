package Model;

public class Fachgruppenreferent extends Dozent{

	
	
	public Fachgruppenreferent(String benutzername, char[] passwort, String nachname, String rolle){
		super(benutzername, passwort, nachname, rolle);	
	}
	
	
	public void bestimmePrueferkonstellation(){
		Modul modul = bestimmeModul();
		Pruefung[] pruefungen = bestimmeModulpruefung(modul);
		Dozent erstPruefer = bestimmeErstpruefer(null);
		Dozent[] zweitPruefer = bestimmeZweitpruefer(null);
		Studiengang[] studiengang = bestimmeStudiengang(null);
		
		
		new Prueferkonstellation(studiengang, erstPruefer, zweitPruefer, pruefungen);
		
		
	}
	
	public Studiengang[] bestimmeStudiengang(Studiengang[] studiengang){
		return studiengang;
	}
	
	
	public Dozent bestimmeErstpruefer(Dozent dozent){
		return dozent;
	}
	
	public Dozent[] bestimmeZweitpruefer(Dozent[] dozent){
		return dozent;
	}
	
	public boolean aenderePrueferkonstellation(Prueferkonstellation prueferkonstellation){
		//true falls �nderung erfolgreich, false falls nicht
		return true;
	}
	
	public void loeschePrueferkonstellation(Prueferkonstellation prueferkonstellation){
		//SQL-Anweisung zum L�schen der Fachgruppe
	}
	
	
	public Pruefung[] zeigePruefungenFachgruppe(Fachgruppe fachgruppe){
		//SQL-Abfrage auf alle Pr�fungen f�r Module der Fachgruppe
		return null;
	}
	
	
	public Modul bestimmeModul(){
		
		return null;
	}
	
	
	public Pruefung[] bestimmeModulpruefung(Modul modul){
		//sqlAbfrage auf alle Pr�fungen des Moduls
		return null;
	}
	
	
	public Pruefung bestimmeRaume(Pruefung pruefung, String raum){
		pruefung.setRaum(raum);
		return pruefung;
	}
	
	
	public Pruefung aenderePruefungsform(Pruefung pruefung, String pruefungsForm){
		pruefung.setPruefungsForm(pruefungsForm);
		return pruefung;
	}
}
