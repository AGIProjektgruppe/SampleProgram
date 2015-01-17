package de.fhdw.hilger.simplecounter5.activity_edit;

import android.widget.Button;
import android.widget.EditText;
import de.fhdw.set.bfwi312b.simplecounter5.R;

public class ActivityGUI {

	private Button mConfirmButton;
	private EditText mCounterValueEditText;

	public ActivityGUI(ActivityInit act) {
		act.setContentView(R.layout.activity_edit);
		
		mConfirmButton = (Button) act.findViewById(R.id.button_confirm);
		mCounterValueEditText = (EditText) act.findViewById(R.id.edittext1);
	}

	// getter to access views
	
	public Button getConfirmButton() {
		return mConfirmButton;
	}

	public EditText getCounterValueEditText() {
		return mCounterValueEditText;
	}
	
	// methods to change view attributes 
	
	public void setCounterValueInEditText(int value) {
		mCounterValueEditText.setText(String.valueOf(value));
	}
}
