package de.fhdw.hilger.simplecounter5.activity_edit;

import de.fhdw.hilger.simplecounter5.constants.Constants;
import android.content.Intent;
import android.os.Bundle;

public class ActivityData {
	
	private static final String KEYCOUNTERVALUE = "K1";
	
	private int mCounter;
	private ActivityInit mActivity;

	public ActivityData (Bundle savedInstanceState, ActivityInit act) {
		Intent intent;
		
		mActivity = act;
		if ( savedInstanceState == null ) {  // no data to restore
			mCounter = 0;   // use default
			intent = act.getIntent();
			mCounter = intent.getIntExtra(Constants.PARAMETER_KEY_COUNTERVALUE, mCounter);
		}
		else {
			restoreDataFromBundle(savedInstanceState);
		}
	}
	
	// save and restore
	
	public void saveDataInBundle(Bundle b) {
		b.putInt(KEYCOUNTERVALUE, mCounter);
	}
	
	public void restoreDataFromBundle(Bundle b) {
		mCounter = b.getInt(KEYCOUNTERVALUE);
	}
	
	// setter
	
	public void setCounter(int value) {
		this.mCounter = value;
	}

	// getter
	public int getCounter() {
		return mCounter;
	}
	
	public ActivityInit getActivity() {
		return mActivity;
	}
}
