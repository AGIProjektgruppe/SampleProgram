package de.fhdw.hilger.simplecounter5.activity_main;

import android.app.Activity;
import android.content.Intent;
import de.fhdw.hilger.simplecounter5.constants.Constants;
import de.fhdw.set.bfwi312b.simplecounter5.R;

/**
 * 
 * @author Tobias Hilger
 * @version 1.0
 * 
 * Die Logik der App wird hier implementiert, Daten- und GUI-manipulation gesteuert
 */
public class ActivityApplicationLogic {

	//Weil Daten und GUI bearbeitet werden, brauchen wir Objekte beider Klassen
	private ActivityData mData;
	private ActivityGUI mGUI;
	
	
	//Der Konstuktor wird mit Parametern "Daten" und "GUI" aufgerufen, damit diese bearbeitet werden können.
	public ActivityApplicationLogic(ActivityData mData, ActivityGUI mGUI) {
		this.mData = mData;
		this.mGUI = mGUI;
		mGUI.setToggleButtonOnText(
			mData.getActivity().getResources().getString(R.string.togglebutton_on_text));
		mGUI.setToggleButtonOffText(
			mData.getActivity().getResources().getString(R.string.togglebutton_off_text));
		applyDataToGUI();
	}

	//Nachdem die Daten bearbeitet worden sind, werden die entsprechenden Setter-Methoden
	//der GUI-Klasse aufgerufen; 
	private void applyDataToGUI() {
		int counterValue;
		TypeOfCounting typeOfCounting;
		
		counterValue = mData.getCounter();
		mGUI.setCounterValueInTextView(counterValue);
		typeOfCounting = mData.getTypeOfCounting();
		mGUI.setToggleButtonState(typeOfCounting.toBoolean());
	}
	
	// Methoden, welche von EventToListenerMapping aufgerufen werden, um nach einem Event-Trigger
	// Daten zu bearbeiten
	
	public void onCountButtonClicked() {
		if ( mData.getTypeOfCounting() == TypeOfCounting.INCREMENT ) {
			mData.incrementCounter();
		}
		else {
			mData.decrementCounter();
		}
		applyDataToGUI();
	}
	
	public void onToggleButtonClicked() {
		mData.switchTypeOfCounting();
		applyDataToGUI();
	}
	
	public void onEditButtonClicked() {
		Intent intent;
		intent = new Intent();
		intent.setClass(mData.getActivity(), Constants.ACTIVITYEDITCLASS);
		intent.putExtra(Constants.PARAMETER_KEY_COUNTERVALUE, mData.getCounter());
		mData.getActivity().startActivityForResult(intent, Constants.REQUESTCODE_COUNTERVALUE);
	}
	
	//Methode, um die übergebenen Daten aus dem anderen Layout zu verwenden
	public void processActivityReturnValues(int requestCode, int resultCode,
			Intent data) {
		//Wenn der Aufruf der neuen Aktivität fehlerfrei war
		if (resultCode == Activity.RESULT_OK){
			
			switch(requestCode){
			
				case Constants.REQUESTCODE_COUNTERVALUE:
					int value;
					//Wird der übergebene Wert genommen
					value = data.getIntExtra(Constants.PARAMETER_KEY_COUNTERVALUE, mData.getCounter());
					mData.setCounter(value);
					//Und auf der GUI angezeigt.
					applyDataToGUI();
					break;
			}
		}
	}

}
