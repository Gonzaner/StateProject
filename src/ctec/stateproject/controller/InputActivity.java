package ctec.stateproject.controller;

import ctec.stateproject.model.AndroidState;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class InputActivity extends Activity
{
	private EditText ageField, nameField, phraseField, blatherField;
	private Button transferButton;
	private AndroidState appState;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_input);
		/**
		 * Information gathering questions. 
		 */
		ageField = (EditText) findViewById(R.id.ageTextField);
		nameField = (EditText) findViewById(R.id.nameTextField);
		phraseField = (EditText) findViewById(R.id.phraseTextField);
		blatherField = (EditText) findViewById(R.id.blatherTextField);
		/**
		 * How we get access to the State. 
		 */
		appState = (AndroidState) this.getApplication();
		
		setupListeners();
	}
	/**
	 * Sends us back to the Display Activity 
	 */
	private void setupListeners()
	{
		transferButton.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View currentView)
			{
				gatherInformation();
				
				Intent transferIntent = new Intent(currentView.getContext(), DisplayActivity.class);
				startActivityForResult(transferIntent, 0);
			}
		});
	}
	/**
	 *  Sets the Information gathering to whatever is input to the text field. 
	 */
	private void gatherInformation()
	{
		appState.setAge(ageField.getText().toString());
		appState.setName(nameField.getText().toString());
		appState.setPhrase(phraseField.getText().toString());
		appState.setBlather(blatherField.getText().toString());
	}
}
