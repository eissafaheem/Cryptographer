package com.example.crypto;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class decryption extends AppCompatActivity
{
    private Button de_b_bt;
            Button de_bt;

    //function to decode the string
    static String decode(String a)
    {
        int i,ascii;
        char ch;
        String  b, str="";

        //replacing '`,' with e1 which was replaced from 'a' and storing it into a string 'b'
        b=a.replace("`,","e1");
        //replacing k$ap%i with A@ which will be later converted to space and storing it into a string 'a'
        a=b.replace("k$ap%i","@A");

        //iterating the characters of string
        for(i=0;i<a.length();i++) {

            ch = a.charAt(i);
            //converting every character of string to its corresponding ascii value and adding 5 to each ascii value
            ascii = (int) ch + 5;
            //converting new ascii values back to character
            ch = (char) ascii;
            //storing each character to another string which was declared empty in starting
            str = str + ch;

        }
        a=str.replace("EF"," ");
        b=a.replace("j6","a");
        return b;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decryption);

        //declaring id to back button
        de_b_bt = (Button) findViewById(R.id.back_button);
        //defining task to be performed on clicking
        de_b_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //defining an intent object to tell operation to be performed: moving from encryption activity to result activity
                Intent intent = new Intent(decryption.this,MainActivity.class);
                //this starts the activity intent
                startActivity(intent);
            }
        });

        //declaring id for edit text ant decryption button
        EditText input_text = (EditText)findViewById(R.id.de_text) ;
        de_bt = (Button)findViewById(R.id.de);
        //defining task to be performed on clicking
        de_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getting input from user and converting it into string to store into a variable
                String input_to_string = input_text.getText().toString();

                //defining an intent object  to tell operation to be performed: moving from decryption activity to result activity
                Intent intent = new Intent(decryption.this, result.class);
                //calling function decode() to encrypt string which returns decoded string value and storing it into a variable: input_to_string_decoded
                String input_to_string_decoded = decode(input_to_string);
                //Copy all extras in string into this intent which can be accessed using the key_value
                intent.putExtra("key_value", input_to_string_decoded);
                //this starts the activity intent
                startActivity(intent);
            }
        });



    }
}