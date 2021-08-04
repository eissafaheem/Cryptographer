package com.example.crypto;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{

    private Button en_bt, de_bt;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    { super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //defining id for encryption button
        en_bt = (Button)findViewById(R.id.en);

        //defining the task to perform on clicking button
        en_bt.setOnClickListener(new View.OnClickListener()
        {
            //encryption button will take us from main activity to encryption activity
            @Override
            public void onClick(View v)
            {
                //defining an intent object to tell operation to be performed
                Intent intent = new Intent(MainActivity.this, encryption.class);
                //starting activity for object intent
                startActivity(intent);
            }
        });



       //defining id for decryption button
        de_bt = (Button)findViewById(R.id.de);

        //defining the task to perform on clicking button
        de_bt.setOnClickListener(new View.OnClickListener()
        {
            //decryption button will take us from main activity to decryption activity
            @Override
            public void onClick(View v)
            {
                //defining an intent object  to tell operation to be performed
                Intent intent =new Intent(MainActivity.this, decryption.class);
                //starting activity for object intent
                startActivity(intent);
            }
        });
    }
}