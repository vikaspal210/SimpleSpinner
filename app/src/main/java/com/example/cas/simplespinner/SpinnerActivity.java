package com.example.cas.simplespinner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        //Spinner element
        final Spinner mSpinner=(Spinner) findViewById(R.id.spinner_view);

        Button mButton=findViewById(R.id.button_);

        //Spinner click listener
        mSpinner.setOnItemSelectedListener(this);

        //Creating adapter for spinner
        ArrayAdapter<CharSequence> dataAdapter=ArrayAdapter.createFromResource(this,R.array.planets_array,android.R.layout.simple_spinner_item);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //attaching adapter
        mSpinner.setAdapter(dataAdapter);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //launch display activity
                Intent intent=new Intent(SpinnerActivity.this,DisplayActivity.class);
                //add data to intent, to be caught in Bundle in DisplayActivity
                intent.putExtra("data",String.valueOf(mSpinner.getSelectedItem()));
                startActivity(intent);
            }
        });

    }//onCreate END

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item=parent.getItemAtPosition(position).toString();

        Toast.makeText(this, "Selected: "+item, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
