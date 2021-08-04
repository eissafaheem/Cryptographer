package com.example.crypto;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class encryption extends AppCompatActivity
{
    //function to encode the string
    public static String encode(String a)
    {
        int i,ascii;
        char ch;
        String str="",b;

        //Since 5 ascii value before a is '\' which is an escape character we need to replace every a in string with e1
        b=a.replace("a","e1");

        //replacing every space with p)fu*n
        a=b.replace(" ","p)fu*n");

        //for loop to iterate every character of string
        for(i=0;i<a.length();i++)
        {
            ch=a.charAt(i);
            //converting every character of string to its corresponding ascii value and subtracting 5 from each ascii value
            ascii=(int)ch-5;
            //converting new ascii values back to character
            ch=(char)ascii;
            //storing each character to another string which was declared empty in starting
            str=str+ch;
        }
        return str;
    }

    @SuppressLint("WrongViewCast")
    @Override

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encryption);

        //declaring id for edit text
        EditText input_text = (EditText)findViewById(R.id.en_text);
        //declaring id for button
        Button en_bt = (Button)findViewById(R.id.en);

        //defining the task to perform on clicking button
         en_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //getting the text entered by user, converting it into string and storing it into a string variable: input_to_string
                String input_to_string = input_text.getText().toString();

                //defining an intent object to tell operation to be performed: moving from encryption activity to result activity
                Intent intent = new Intent(encryption.this, result.class);
                //calling function encode() to encrypt string which returns encoded string value and storing it into a variable: input_to_string_encoded
                String input_to_string_encoded = encode(input_to_string);
                //Copy all extras in string in to this intent which can be accessed using the key_value
                intent.putExtra("key_value", input_to_string_encoded);
                //this starts the activity intent
                startActivity(intent);
            }
        });

        //declaring id for back button
        Button en_b_bt = (Button)findViewById(R.id.back_button);
        //defining the task to perform on clicking button
        en_b_bt.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //defining an intent object  to tell operation to be performed
                Intent intent = new Intent(encryption.this, MainActivity.class);
                //starting activity for object intent
                startActivity(intent);
            }
        });
    }
}