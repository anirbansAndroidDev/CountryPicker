package com.androiddoc.countrypickerwithflag;

import com.countrypicker.CountryPicker;
import com.countrypicker.CountryPickerListener;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MyMainActivity extends FragmentActivity {
	
	EditText editTextCountry;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_main);
		
		editTextCountry = (EditText)findViewById(R.id.editTextCountry);
	}
	public void openPicker(View v) 
	{
		final CountryPicker picker = CountryPicker.newInstance("Select Country");
		picker.setListener(new CountryPickerListener() {

			@Override
			public void onSelectCountry(String name, String code) {
				Toast.makeText(
						MyMainActivity.this,
						"Country Name: " + name + " - Code: " + code
						+ " - Currency: "
						+ CountryPicker.getCurrencyCode(code),
						Toast.LENGTH_SHORT).show();
				
				editTextCountry.setText(name);
				picker.dismiss();
			}
		});

		picker.show(getSupportFragmentManager(), "COUNTRY_PICKER");
	}

}
