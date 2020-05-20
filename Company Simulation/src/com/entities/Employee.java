package com.entities;

import java.awt.Dimension;
import java.awt.Image;

public class Employee extends Person{
	//Klasse Mitarbeiter, vererbt von Person
	
	
		//__________________________________________________________________________________________________________________
		//Variablen
		
		private int produktivit�t /*= standardwert*/;			//MISSING FILE
		private int umweltfaktor /*= standardwert*/;			//MISSING FILE
		private int ausbildung = 1;													//start bei 1 bei weiterbildung erh�hen
		private Maschine maschine;													//Maschine an der der Mitarbeiter arbeitet
		private Image[] images;									//MISSING FILE		Bilder der Mitarbeiter nach level
		private final Dimension dimension = new Dimension();	//MISSING FILE		Standard Dimension f�r Mitarbeiter			
		
		//__________________________________________________________________________________________________________________
		//Konstruktoren, zum erstellen eines neuen Mitarbeiters
		
		public Employee(Maschine maschine) {
			this.maschine = maschine;	 	//Zuweisung zu der Maschine, an der der Mitarbeiter arbeitet
			super.dimension = dimension;	//Festlegen der dimension
			berechne_produktivit�t();	 	//Methode berechne_produktivit�t aufrufen
			update_image();			 	 	//Methode update_image aufrufen
		}
		
		public Employee(Maschine maschine, int umweltfaktor) {
			this.maschine = maschine;			//Zuweisung zu der Maschine, an der der Mitarbeiter arbeitet
			this.umweltfaktor = umweltfaktor;	//direkte zuweisung des umweltfaktors, falls dieser dem standart abweichen sollte
			super.dimension = dimension;		//Festlegen der dimension
			berechne_produktivit�t();			//Methode berechne_produktivit�t aufrufen
			update_image();						//Methode update_image aufrufen
		}
		
		//__________________________________________________________________________________________________________________
		//Methoden 
		
		public void fortbildung(int fortbildung/*Wert an fortbildung*/) { //Methode um den Wert der Ausbildung zu erh�hen
			ausbildung += fortbildung;
			update_image();
		}
		
		private void berechne_produktivit�t() { //Methode um die produktivit�t mithilfe der Werte von ausbildung und umweltfaktor zu berechnen
			this.produktivit�t = ausbildung * umweltfaktor;//Beispiel berechnung 
		}
		
		private void update_image() { //Methode um das Image des arbeiters zu aktualisieren (das Bild ver�ndert sich bei ver�nderung des Umweltfaktors oder des ausbildungsgrad)
			super.image = images[ausbildung + umweltfaktor];
		}

		//__________________________________________________________________________________________________________________
		//Getter und Setter Methoden		
		
		public Maschine getMaschine() {
			return maschine;
		}

		public void setMaschine(Maschine maschine) {
			this.maschine = maschine;
			update_image();
		}

		public int getProduktivit�t() {
			return produktivit�t;
		}

		public int getAusbildung() {
			return ausbildung;
		}

		public void setUmweltfaktor(int umweltfaktor) {
			this.umweltfaktor = umweltfaktor;
			berechne_produktivit�t();
			update_image();
		}
	}
