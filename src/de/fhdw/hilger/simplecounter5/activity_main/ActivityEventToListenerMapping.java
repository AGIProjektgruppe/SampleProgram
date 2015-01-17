package de.fhdw.hilger.simplecounter5.activity_main;


import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import de.fhdw.set.bfwi312b.simplecounter5.R;
/**
 * 
 * @author Tobias Hilger
 * @version 1.0
 * 
 * Hier werden Event-Trigger verarbeitet
 */
public class ActivityEventToListenerMapping implements OnClickListener, OnCheckedChangeListener {

	private ActivityApplicationLogic mApplicationLogic;
	private ActivityGUI mGUI;
	
	public ActivityEventToListenerMapping (ActivityGUI gui, ActivityApplicationLogic appLogic) {
		this.mGUI = gui;
		this.mApplicationLogic = appLogic;
		//Den GUI-Elementen werden Event-Listener zugewiesen
		mGUI.getCountButton().setOnClickListener(this);
		mGUI.getToggleButton().setOnCheckedChangeListener(this);
		mGUI.getEditButton().setOnClickListener(this);
	}

	//Hier werden die Aktionen beim Auslösen eines Event-Triggers gestartet
	@Override
	public void onClick(View v) {
		switch(v.getId())
		{
		case R.id.button_count: mApplicationLogic.onCountButtonClicked(); break;
		case R.id.buttonedit: mApplicationLogic.onEditButtonClicked(); break;
		}
					
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		mApplicationLogic.onToggleButtonClicked();
	}
	
}
