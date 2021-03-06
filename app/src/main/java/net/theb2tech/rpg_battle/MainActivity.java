package net.theb2tech.rpg_battle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static List<hero> heroList = new ArrayList<>();  //fő hős lista
    public static int editHeroPos = 0; //TODO ezt valahogy másthogy kéne megoldani
    static boolean voltmán = false; //TODO végleges változatból törölni!

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateListView();
        editHero();
        if (!voltmán) { //TODO végleges változatból törölni!
            for (int i = 0; i < 2; i++) {
                createDefaultHero(Integer.toString(i));
            }
        }
        voltmán = true;
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

    //lista nézet feltöltása
    private void populateListView() {
        ArrayAdapter<hero> adapter = new listAdapter();
        ListView listView = (ListView) findViewById(R.id.listCurrentHeroes);
        listView.setAdapter(adapter);
    }

    //átváltás uj hős képernyőra
    public void callNewHero(View v) {
        Intent intent = new Intent(this, newHero.class);
        startActivity(intent);
    }

    //átváltás információk képernyőra
    public void callInfos(View v) {
        Intent intent = new Intent(this, infos.class);
        startActivity(intent);
    }

    //átváltás információk képernyőra
    public void callEdit(View v) {
        Intent intent = new Intent(this, editHero.class);
        startActivity(intent);
    }

    public void callBattle(View v) {
        Intent intent = new Intent(this, battleActivity.class);
        startActivity(intent);
    }

    //listaadapter
    private class listAdapter extends ArrayAdapter<hero> {

        public listAdapter() {
            super(MainActivity.this, R.layout.itemview, heroList);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView = convertView;
            if (itemView == null) {
                itemView = getLayoutInflater().inflate(R.layout.itemview, parent, false);
            }

            hero currentHero = heroList.get(position);

            ImageView itemImage = (ImageView) itemView.findViewById(R.id.itemImage);
            itemImage.setImageResource(currentHero.getIconId());

            TextView itemName = (TextView) itemView.findViewById(R.id.text_name);
            itemName.setText(currentHero.getName());

            TextView itemFaction = (TextView) itemView.findViewById(R.id.textHeroFaction);
            itemFaction.setText(currentHero.getFaction().toString());

            TextView itemClass = (TextView) itemView.findViewById(R.id.textHeroClass);
            itemClass.setText(currentHero.getHero_class());

            return itemView;
            //return  super.getView(position, convertView, parent);
        }
    }

    //debug hős létrehozása
    private void createDefaultHero(String name) {
        heroList.add(new hero(name, 10, 10, 10, 10, "Horde", "Warrior", R.drawable.dahero));
    }

    private void editHero() {
        ListView listView = (ListView) findViewById(R.id.listCurrentHeroes);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MainActivity.editHeroPos = position;
                callEdit(view);
            }
        });
    }
}
