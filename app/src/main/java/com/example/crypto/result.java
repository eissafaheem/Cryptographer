package com.example.crypto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class result extends AppCompatActivity {
    Button b_bt, copy_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //getting the string stored in intent using its key_value
        String output_text = (String) getIntent().getExtras().get("key_value");

        //defining id for result_text
        EditText result_text = (EditText)findViewById(R.id.result_text) ;
        //setting the result_text as output_text in Edit text column
        result_text.setText(output_text);

        //declaring id to back button
        b_bt = (Button)findViewById(R.id.back_button);
        //defining task to be performed on clicking
        b_bt.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //defining an intent object to tell operation to be performed: moving from result activity to main activity
                Intent intent = new Intent(result.this, MainActivity.class);
                //this starts the activity intent
                startActivity(intent);
            }
        });

        //defining id for copy button
        copy_btn = (Button)findViewById(R.id.copy_text);
        //defining task to perform on clicking
        copy_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //using ClipboardManager to get CLIPBOARD_SERVICE
                ClipboardManager clipboard = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                //getting the clip data in string format
                ClipData clip = ClipData.newPlainText("text",result_text.getText().toString());
                clipboard.setPrimaryClip(clip);

                //A toast message will be displayed when text is copied
                Toast.makeText(result.this,"Text Copied!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}