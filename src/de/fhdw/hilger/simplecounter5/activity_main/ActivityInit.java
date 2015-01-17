package de.fhdw.hilger.simplecounter5.activity_main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * @author Tobias Hilger
 * @version 1.0
 * 
 * Die Klasse erzeugt Instanzen aller benötigen Klassen für das layout_main.
 *
 */
public class ActivityInit extends Activity {

	//Objekte der Klassen für Daten, Interface und Datenmainpulation
	private ActivityData mData;
	private ActivityGUI mGUI;
	private ActivityApplicationLogic mApplicationLogic;

	//Wird aufgerufen, wenn die App gestartet wird. Siehe "Android App Life Cycle".
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Dem Aufruf der Dateninitialisierung werden die gespeicherten Daten mitgegeben.
		initData(savedInstanceState);
		initGUI();
		initApplicationLogic();
		initEventToListenerMapping();
	}

	private void initData(Bundle savedInstanceState) {
		//Der Konstruktor wird mit den gespeicherten Daten aufgrufen.
		mData = new ActivityData(savedInstanceState, this);
	}
	
	//Alle GUI-Elemente werden initialisiert, damit sie verwendet werden können.
	private void initGUI() {
		mGUI = new ActivityGUI(this);
	}
	
	//Daten-Manipulation wird in diese Klasse ausgelagert, deshalb muss das Obejekt der Datenklasse "mData" übegeben werden
	private void initApplicationLogic() {
		mApplicationLogic = new ActivityApplicationLogic(mData, mGUI);
	}
	
	//Event-Trigger durch die GUI werden hier verarbeitet
	private void initEventToListenerMapping() {
		new ActivityEventToListenerMapping(mGUI, mApplicationLogic);
	}
	
	//Wenn die App pausiert, werden die Daten aus dem Objekt der Daten-Klasse gespreichert
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		mData.saveDataInBundle(outState);
		super.onSaveInstanceState(outState);
	}
	
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		mApplicationLogic.processActivityReturnValues(requestCode, resultCode, data);
	}
	
	
}
