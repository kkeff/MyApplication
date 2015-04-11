package com.kaspergustavii.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

    public final static String EXTRA_MESSAGE = "com.kaspergustavii.myapplication.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {//Bundle sparar information som sker i användarflöden mellan sidor osv.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void sendMessage (View view){

        Intent intent = new Intent(this, DisplayMessageActivity.class);
        //Man skapar ett intent som är kopplat till DisplayMessageActivity - Nästa sida
        EditText editText = (EditText) findViewById(R.id.edit_message);
        //Man hittar edit message genom att leta igenom hela res? Det blir då viktigt med unika namn!
        String message = editText.getText().toString();//Tar det inskrivna meddelandet från textfältet
        intent.putExtra(EXTRA_MESSAGE, message);// Här lagras texten i Intentet
        startActivity(intent);//startActivity måste vara en inbyggd metod som har parametern Intent

    }
}
