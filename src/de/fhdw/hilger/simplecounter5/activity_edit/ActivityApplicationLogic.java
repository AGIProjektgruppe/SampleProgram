package de.fhdw.hilger.simplecounter5.activity_edit;


import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;
import de.fhdw.hilger.simplecounter5.constants.Constants;
import de.fhdw.set.bfwi312b.simplecounter5.R;



public class ActivityApplicationLogic {

	private ActivityData mData;
	private ActivityGUI mGUI;

	public ActivityApplicationLogic(ActivityData mData, ActivityGUI mGUI) {
		this.mData = mData;
		this.mGUI = mGUI;
		applyDataToGUI();
	}

	private void applyDataToGUI() {
		int counterValue;
		
		counterValue = mData.getCounter();
		mGUI.setCounterValueInEditText(counterValue);
	}
	
	// event handling
	
	public void onConfirmButtonClicked() {
		int value;
		try {
			value = Integer.valueOf(mGUI.getCounterValueEditText().getText().toString().trim());
			mData.setCounter(value);
		} catch (NumberFormatException e) {
			Toast.makeText(mData.getActivity(), R.string.error_wrong_number_format, Toast.LENGTH_SHORT).show();
		}
		defineActivityReturnValues();
		mData.getActivity().finish();
	}
	private void defineActivityReturnValues(){
		
		Intent intent;
		intent = new Intent();
		intent.putExtra(Constants.PARAMETER_KEY_COUNTERVALUE, mData.getCounter());
		mData.getActivity().setResult(Activity.RESULT_OK, intent);
		
	}
	
	public void onEditTextChanged() {
		int value;
		try {
			value = Integer.valueOf(mGUI.getCounterValueEditText().getText().toString().trim());
			mData.setCounter(value);
		} catch (NumberFormatException e) {

		}
	}

}
