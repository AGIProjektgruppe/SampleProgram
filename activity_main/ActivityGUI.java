package de.fhdw.set.bfwi312b.simplecounter5.activity_main;

import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;
import de.fhdw.set.bfwi312b.simplecounter5.R;

public class ActivityGUI {

	private Button mIncrementButton;
	private TextView mCounterValueTextView;
	private ToggleButton mTypeOfCountingToggleButton;

	public ActivityGUI(ActivityInit act) {
		act.setContentView(R.layout.activity_main);
		
		mIncrementButton = (Button) act.findViewById(R.id.button1);
		mCounterValueTextView = (TextView) act.findViewById(R.id.textview1);
		mTypeOfCountingToggleButton = (ToggleButton) act.findViewById(R.id.togglebutton1);
	}

	// getter to access views
	
	public Button getCountButton() {
		return mIncrementButton;
	}

	public TextView getCounterValueTextView() {
		return mCounterValueTextView;
	}
	
	public ToggleButton getToggleButton() {
		return mTypeOfCountingToggleButton;
	}
	
	// methods to change view attributes 
	
	public void setCounterValueInTextView(int value) {
		mCounterValueTextView.setText(String.valueOf(value));
	}
	
	public void setToggleButtonState(boolean b) {
		mTypeOfCountingToggleButton.setChecked(b);
	}
	
	public void setToggleButtonOnText(String text) {
		mTypeOfCountingToggleButton.setTextOn(text);
	}

	public void setToggleButtonOffText(String text) {
		mTypeOfCountingToggleButton.setTextOff(text);
	}
}
