package de.fhdw.set.bfwi312b.simplecounter5.activity_main;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class ActivityEventToListenerMapping implements OnClickListener, OnCheckedChangeListener {

	private ActivityApplicationLogic mApplicationLogic;
	private ActivityGUI mGUI;
	
	public ActivityEventToListenerMapping (ActivityGUI gui, ActivityApplicationLogic appLogic) {
		this.mGUI = gui;
		this.mApplicationLogic = appLogic;
		
		mGUI.getCountButton().setOnClickListener(this);
		mGUI.getToggleButton().setOnCheckedChangeListener(this);
	}

	@Override
	public void onClick(View v) {
		mApplicationLogic.onCountButtonClicked();	
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		mApplicationLogic.onToggleButtonClicked();
	}
	
}
