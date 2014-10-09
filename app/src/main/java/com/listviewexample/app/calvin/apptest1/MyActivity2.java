package com.listviewexample.app.calvin.apptest1;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Scanner;

import com.listviewexample.app.calvin.apptest1.JRiot;
import com.listviewexample.app.calvin.apptest1.JRiotException;
import objects.Game;
import objects.RawStats;
import objects.RecentGames;
import objects.Summoner;


public class MyActivity2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_activity2);

        Bundle extras = getIntent().getExtras();
        String value = extras.getString("Summoner Name");
        if (extras != null) {

            final TextView textView = (TextView)findViewById(R.id.textView1);
            textView.setText(value);
        }

        JRiot lol = new JRiot();
        lol.setApiKey("c590cefb-441f-4e58-9d25-e737dd58f969");
        lol.setRegion("na");

        try {

            // Get Summoner information

            Summoner summoner = lol.getSummoner(value);

            long id = summoner.getId();

            RecentGames recentgames = lol.getRecentGames(id);

            ArrayList<Game> games = recentgames.getGames();

            for (int i = 0; i < 10; i++) {
                RawStats test = games.get(i).getStats();
                int assists = test.getAssists();
                int kills = test.getChampionsKilled();
                int deaths = test.getNumDeaths();
                double kills1 = (double) kills;
                double assists1 = (double) assists;
                double deaths1 = (double) deaths;
                double kda = 0;

                if (deaths != 0) {
                    kda = (kills1 + assists1) / deaths1;

                }
                int cs = test.getMinionsKilled();
                int timeSec = test.getTimePlayed();
                int timeMin = timeSec / 60;
                timeSec = timeSec % 60;
                TextView selection = (TextView) findViewById(R.id.textView2);
                selection.setText("End Games Stats for Game " + (i + 1) + ":\n----------------------------------------");

                if (kda != 0) {
                    selection.setText("KDA: ");
                    //System.out.print("KDA: ");
                    //System.out.printf("%.2f", kda);
                    //System.out.println();
                }
                // System.out.println(kills + " kills, " + deaths + " deaths, and " + assists + " assists.\n" + cs +
                //        " minions killed in " + timeMin + " minutes, " + timeSec + " seconds.\n");


                }

            }

            catch(JRiotException e){

            }

        }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_activity2, menu);
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
}
