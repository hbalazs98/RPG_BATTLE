package net.theb2tech.rpg_battle;

import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/*import android.view.Menu;
import android.view.MenuItem;*/

public class battleActivity extends AppCompatActivity {

    Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);

        final List<hero> heroListBattle = MainActivity.heroList;

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                battleActivity.this.runOnUiThread(new Runnable()
                {
                    public void run()
                    {
                        Random rand = new Random();
                        for (int i = 0; i < heroListBattle.size(); i++) {
                            int defender = i;
                            do {
                            } while (defender == i);

                            Toast.makeText(battleActivity.this, heroListBattle.get(i).getName() + " támadja " + heroListBattle.get(defender).getName() + "-et.", Toast.LENGTH_LONG).show();

                            if (calculate.defence(heroListBattle.get(defender)) < calculate.attack(heroListBattle.get(i))) {
                                heroListBattle.get(defender).setHp(Math.floor(heroListBattle.get(defender).getHp() - (calculate.attack(heroListBattle.get(i)))));

                                Toast.makeText(battleActivity.this, heroListBattle.get(i).getName() + " " + calculate.attack(heroListBattle.get(i)) + " -et sebzett " +
                                        heroListBattle.get(defender).getName() + "-nek. (" + calculate.defence(heroListBattle.get(defender)) + " védelem)", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(battleActivity.this, heroListBattle.get(defender).getName() + " védelme nagyobb mint " + heroListBattle.get(i).getName() + " támadása (" +
                                        calculate.attack(heroListBattle.get(i)) + " > " + calculate.defence(heroListBattle.get(defender)) + ")", Toast.LENGTH_LONG).show();

                                if (heroListBattle.get(defender).getHp() <= 0) {
                                    Toast.makeText(battleActivity.this, heroListBattle.get(defender).getName() + "meghalt.", Toast.LENGTH_LONG).show();
                                    heroListBattle.remove(defender);
                                }
                            }
                        }
                    }
                });
            }
        }, 2000, 2000);


    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_battle, menu);
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
    }*/
    }
}
