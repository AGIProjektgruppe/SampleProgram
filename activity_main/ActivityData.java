package de.fhdw.set.bfwi312b.simplecounter5.activity_main;

import android.os.Bundle;

public class ActivityData {
	
	private static final String KEYCOUNTERVALUE = "K1";
	private static final String KEYTYPEOFCOUNTING = "K2";
	
	private int mCounter;
	private TypeOfCounting mTypeOfCounting;
	private ActivityInit mActivity;

	public ActivityData (Bundle savedInstanceState, ActivityInit act) {
		mActivity = act;
		if ( savedInstanceState == null ) {  // no data to restore
			mCounter = 0;   // use default
			mTypeOfCounting = TypeOfCounting.INCREMENT;
		}
		else {
			restoreDataFromBundle(savedInstanceState);
		}
	}
	
	// save and restore
	
	public void saveDataInBundle(Bundle b) {
		b.putInt(KEYCOUNTERVALUE, mCounter);
		b.putBoolean(KEYTYPEOFCOUNTING, mTypeOfCounting.toBoolean());
	}
	
	public void restoreDataFromBundle(Bundle b) {
		mCounter = b.getInt(KEYCOUNTERVALUE);
		mTypeOfCounting = TypeOfCounting.toTypeOfCounting(b.getBoolean(KEYTYPEOFCOUNTING));
	}
	
	// setter
	
	public void setCounter(int value) {
		this.mCounter = value;
	}

	public void setTypeOfCounting(TypeOfCounting typeOfCounting) {
		this.mTypeOfCounting = typeOfCounting;
	}
	
	// getter
	
	public TypeOfCounting getTypeOfCounting() {
		return mTypeOfCounting;
	}
	
	public int getCounter() {
		return mCounter;
	}
	
	public ActivityInit getActivity() {
		return mActivity;
	}
	
	// change data
	
	public void incrementCounter() {
		mCounter++;
	}
	
	public void decrementCounter() {
		mCounter--;
	}
	
	public void switchTypeOfCounting () {
		if ( mTypeOfCounting == TypeOfCounting.INCREMENT ) {
			mTypeOfCounting = TypeOfCounting.DECREMENT;
		}
		else {
			mTypeOfCounting = TypeOfCounting.INCREMENT;
		}
	}

}
