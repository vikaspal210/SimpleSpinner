package com.example.cas.simplespinner;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        TextView mTextView=(TextView)findViewById(R.id.display_tv);
        //getting data from Bundle
        Bundle mBundle=getIntent().getExtras();
        String data=mBundle.get("data").toString();
        mTextView.setText(data);
    }
}
