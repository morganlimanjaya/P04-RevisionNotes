package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etNote;
    //instead of labeling each radio button use the radio group instead
    RadioGroup rgStars;
    Button btnInsert;
    Button btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNote = (EditText)findViewById(R.id.editTextNote);
        btnInsert = (Button)findViewById(R.id.buttonInsertNote);
        btnShow = (Button)findViewById(R.id.buttonShowList);
        rgStars = (RadioGroup)findViewById(R.id.radioGroupStars);


        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selected = rgStars.getCheckedRadioButtonId();
                RadioButton radiobtn = (RadioButton)findViewById(selected);
                int rbtext = Integer.parseInt(radiobtn.getText().toString());
                String notesContent = etNote.getText().toString();

                DBHelper db = new DBHelper(MainActivity.this);
                //Insert a task
                db.insertNote(notesContent,rbtext);
                Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_SHORT).show();
                db.close();
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                DBHelper db = new DBHelper(MainActivity.this);

                //Insert a task
//                ArrayList<String> data = db.getNoteContent();
                Intent intent = new Intent(getBaseContext(),SecondActivity.class);
                startActivity(intent);
//                db.close();

            }
        });



    }
}
