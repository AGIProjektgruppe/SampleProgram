package de.fhdw.set.bfwi312b.simplecounter5.activity_main;

import de.fhdw.set.bfwi312b.simplecounter5.R;


public class ActivityApplicationLogic {

	private ActivityData mData;
	private ActivityGUI mGUI;

	public ActivityApplicationLogic(ActivityData mData, ActivityGUI mGUI) {
		this.mData = mData;
		this.mGUI = mGUI;
		mGUI.setToggleButtonOnText(
			mData.getActivity().getResources().getString(R.string.togglebutton_on_text));
		mGUI.setToggleButtonOffText(
			mData.getActivity().getResources().getString(R.string.togglebutton_off_text));
		applyDataToGUI();
	}

	private void applyDataToGUI() {
		int counterValue;
		TypeOfCounting typeOfCounting;
		
		counterValue = mData.getCounter();
		mGUI.setCounterValueInTextView(counterValue);
		typeOfCounting = mData.getTypeOfCounting();
		mGUI.setToggleButtonState(typeOfCounting.toBoolean());
	}
	
	// event handling
	
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

}
