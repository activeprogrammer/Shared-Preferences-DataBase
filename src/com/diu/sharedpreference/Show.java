package com.diu.sharedpreference;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Show extends Activity {
	public static final String DEFAULT="N/A";
	TextView tvName, tvId, tvEmail, tvPhone;
	String name, id, email, phone;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show);
		tvName = (TextView) findViewById(R.id.tvName);
		tvId = (TextView) findViewById(R.id.tvId);
		tvEmail = (TextView) findViewById(R.id.tvEmail);
		tvPhone = (TextView) findViewById(R.id.tvPhone);
	}

	public void show(View v) {
		SharedPreferences sharedPreferences = getSharedPreferences("MyData",
				Context.MODE_PRIVATE);
		name = sharedPreferences.getString("name", DEFAULT);
		id = sharedPreferences.getString("id", DEFAULT);
		email = sharedPreferences.getString("email", DEFAULT);
		phone = sharedPreferences.getString("phone",DEFAULT);
		if (name.equals(DEFAULT) || id.equals(DEFAULT) || email.equals(DEFAULT)
				|| phone.equals(DEFAULT)) {
			Toast.makeText(getBaseContext(), "No Data Found",
					Toast.LENGTH_SHORT).show();

		} else {
			tvName.setText(name);
			tvId.setText(id);
			tvEmail.setText(email);
			tvPhone.setText(phone);
			Toast.makeText(getBaseContext(), "Data Found", Toast.LENGTH_SHORT)
					.show();

		}

	}

	public void prev(View v) {
		startActivity(new Intent(this, MainActivity.class));
		Toast.makeText(getBaseContext(), "Previous Clicked", Toast.LENGTH_SHORT)
				.show();

	}
}
