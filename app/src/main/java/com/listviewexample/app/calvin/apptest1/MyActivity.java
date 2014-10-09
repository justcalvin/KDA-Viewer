package com.listviewexample.app.calvin.apptest1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MyActivity extends Activity {
    private EditText name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void onGetNameClick(View view) {
        name = (EditText) findViewById(R.id.sumName);
        //toast to welcome users
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.TOP| Gravity.LEFT, 0, 0);
        toast.makeText(MyActivity.this, "Welcome " + name.getText(), toast.LENGTH_SHORT).show();


        String summonerName = name.getText().toString();
        Button button = (Button) view;

        Intent i = new Intent(getApplicationContext(), MyActivity2.class);
        i.putExtra("Summoner Name", summonerName);
        startActivity(i);

        // setContentView(name);
    }
}
