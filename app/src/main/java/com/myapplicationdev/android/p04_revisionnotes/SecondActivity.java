package com.myapplicationdev.android.p04_revisionnotes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
	ListView lv;
	ArrayList<Note> notesArrayList;
	ArrayAdapter aa;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);


		lv = (ListView)findViewById(R.id.lv);

//        Intent intentReceived = getIntent();
		DBHelper db = new DBHelper(SecondActivity.this);
		notesArrayList = db.getAllNotes();

		aa = new RevisionNotesArrayAdapter(SecondActivity.this, R.layout.row, notesArrayList) ;
		lv.setAdapter(aa);


	}


}
