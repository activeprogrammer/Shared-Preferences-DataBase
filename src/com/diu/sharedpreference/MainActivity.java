package com.diu.sharedpreference;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	EditText etName, etId, etEmail, etPahone;
	String name, id, email, phone;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		etName = (EditText) findViewById(R.id.etName);
		etId = (EditText) findViewById(R.id.etId);
		etEmail = (EditText) findViewById(R.id.etEmail);
		etPahone = (EditText) findViewById(R.id.etPhone);

	}

	public void save(View v) {
		name = etName.getText().toString();
		id = etId.getText().toString();
		email = etEmail.getText().toString();
		phone = etPahone.getText().toString();
		SharedPreferences sharedPreferences = getSharedPreferences("MyData",
				Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sharedPreferences.edit();
		editor.putString("name", name);
		editor.putString("id", id);
		editor.putString("email", email);
		editor.putString("phone", phone);
		editor.commit();
		Toast.makeText(getBaseContext(), "Successfully Saved",
				Toast.LENGTH_SHORT).show();

	}

	public void next(View v) {

		startActivity(new Intent(this, Show.class));
		Toast.makeText(getBaseContext(), "Next Clicked", Toast.LENGTH_SHORT)
				.show();
	}
}
