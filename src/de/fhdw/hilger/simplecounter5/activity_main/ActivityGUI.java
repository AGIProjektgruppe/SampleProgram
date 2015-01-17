package de.fhdw.hilger.simplecounter5.activity_main;

import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;
import de.fhdw.set.bfwi312b.simplecounter5.R;

public class ActivityGUI {

	private Button mCountButton;
	private Button mEditButton;
	private TextView mCounterValueTextView;
	private ToggleButton mTypeOfCountingToggleButton;

	//Der Konstruktor initialisert alle GUI-Elemente
	public ActivityGUI(ActivityInit act) {
		act.setContentView(R.layout.activity_main);
		//
		mCountButton = (Button) act.findViewById(R.id.button_count);
		mEditButton = (Button) act.findViewById(R.id.buttonedit);
		mCounterValueTextView = (TextView) act.findViewById(R.id.textview1);
		mTypeOfCountingToggleButton = (ToggleButton) act.findViewById(R.id.togglebutton1);
	}

	// Getter-Methoden 
	
	public Button getCountButton() {
		return mCountButton;
	}

	public Button getEditButton() {
		return mEditButton;
	}

	public TextView getCounterValueTextView() {
		return mCounterValueTextView;
	}
	
	public ToggleButton getToggleButton() {
		return mTypeOfCountingToggleButton;
	}
	
	// Manipulation der GUI-Elemente durch Setter-Methoden
	
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
