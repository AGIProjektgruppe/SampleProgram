package de.fhdw.hilger.simplecounter5.activity_main;

import android.os.Bundle;
/**
 * 
 * @author Tobias Hilger 
 * @version 1.0
 * 
 * Klasse um Daten zu speichern und zu verwalten
 *
 */
public class ActivityData {
	
	private static final String KEYCOUNTERVALUE = "K1";
	private static final String KEYTYPEOFCOUNTING = "K2";
	
	private int mCounter;
	private TypeOfCounting mTypeOfCounting;
	private ActivityInit mActivity;

	// Bei Konstruktor Aufruf wird überprüft, ob gespeicherte Daten vorliegen
	public ActivityData (Bundle savedInstanceState, ActivityInit act) {
		mActivity = act;
		if ( savedInstanceState == null ) {  // keine Daten gespeichert
			mCounter = 0;   // verwende Default-Wert
			mTypeOfCounting = TypeOfCounting.INCREMENT; 
		}
		else {
			restoreDataFromBundle(savedInstanceState); //Ansonsten lade gespeicherte Daten
		}
	}
	
	// Spreichern und Wiederherstellen
	
	public void saveDataInBundle(Bundle b) {
		b.putInt(KEYCOUNTERVALUE, mCounter);
		b.putBoolean(KEYTYPEOFCOUNTING, mTypeOfCounting.toBoolean());
	}
	
	public void restoreDataFromBundle(Bundle b) {
		mCounter = b.getInt(KEYCOUNTERVALUE);
		mTypeOfCounting = TypeOfCounting.toTypeOfCounting(b.getBoolean(KEYTYPEOFCOUNTING));
	}
	
	// Setter
	
	public void setCounter(int value) {
		this.mCounter = value;
	}

	public void setTypeOfCounting(TypeOfCounting typeOfCounting) {
		this.mTypeOfCounting = typeOfCounting;
	}
	
	// Getter
	
	public TypeOfCounting getTypeOfCounting() {
		return mTypeOfCounting;
	}
	
	public int getCounter() {
		return mCounter;
	}
	
	public ActivityInit getActivity() {
		return mActivity;
	}
	
	// Daten-Bearbeitung
	
	public void incrementCounter() {
		mCounter++;
	}
	
	public void decrementCounter() {
		mCounter--;
	}
	//Zählweise ändern
	public void switchTypeOfCounting () {
		if ( mTypeOfCounting == TypeOfCounting.INCREMENT ) {
			mTypeOfCounting = TypeOfCounting.DECREMENT;
		}
		else {
			mTypeOfCounting = TypeOfCounting.INCREMENT;
		}
	}

}
