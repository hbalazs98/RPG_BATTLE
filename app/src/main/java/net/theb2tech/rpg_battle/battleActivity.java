package net.theb2tech.rpg_battle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/*import android.view.Menu;
import android.view.MenuItem;*/

public class battleActivity extends AppCompatActivity {
    List<hero> heroListBattle = MainActivity.heroList;

    Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);

        populateListView();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                //battleActivity.battleTick();
                battleTick();
            }
        }, 3000, 3000);
    }

    @Override
    protected void onPause() {
        timer.cancel();
        super.onPause();
    }

    private void populateListView() {
        ArrayAdapter<hero> adapter = new listAdapter();
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }

    private class listAdapter extends ArrayAdapter<hero> {

        public listAdapter() {
            super(battleActivity.this, R.layout.itemview, heroListBattle);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView = convertView;
            if (itemView == null) {
                itemView = getLayoutInflater().inflate(R.layout.itemview, parent, false);
            }

            hero currentHero = heroListBattle.get(position);

            ImageView itemImage = (ImageView) itemView.findViewById(R.id.itemImage);
            itemImage.setImageResource(currentHero.getIconId());

            TextView itemName = (TextView) itemView.findViewById(R.id.text_name);
            itemName.setText(currentHero.getName());

            TextView itemFaction = (TextView) itemView.findViewById(R.id.textHeroFaction);
            itemFaction.setText(currentHero.getFaction().toString());

            TextView itemClass = (TextView) itemView.findViewById(R.id.textHeroClass);
            itemClass.setText(currentHero.getHero_class());

            TextView itemHp = (TextView) itemView.findViewById(R.id.textHeroHp);
            itemClass.setText(Double.toString(currentHero.getHp()));

            return itemView;
            //return  super.getView(position, convertView, parent);
        }
    }

    void battleTick() {
        battleActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {

                Random rand = new Random();
                for (int i = 0; i < heroListBattle.size(); i++) {
                    int defender = i;
                    do {
                        defender = rand.nextInt(heroListBattle.size());
                    } while (defender == i);

                    Toast.makeText(battleActivity.this, heroListBattle.get(i).getName() + " támadja " + heroListBattle.get(defender).getName() + "-et.", Toast.LENGTH_LONG).show();

                    if (calculate.defence(heroListBattle.get(defender)) < calculate.attack(heroListBattle.get(i))) {
                        heroListBattle.get(defender).setHp((int)Math.floor(heroListBattle.get(defender).getHp() - (calculate.attack(heroListBattle.get(i)))));

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
                populateListView();
            }
        });
    }


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
