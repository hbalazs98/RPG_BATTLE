package net.theb2tech.rpg_battle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import java.util.List;

import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static List<hero> heroList = new ArrayList<>();  //fő hős lista
    public static int editHeroPos = 0;
    static boolean voltmán = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateListView();
        editHero();
        if (!voltmán) {
            createDefaultHero();
        }
        voltmán = true;
    }

    //lista nézet feltöltása
    private void populateListView() {
        ArrayAdapter<hero> adapter = new listAdapter();
        ListView listView = (ListView) findViewById(R.id.listCurrentHeroes);
        listView.setAdapter(adapter);
    }

    //átváltás uj hős képernyőra
    public void callNewHero(View v){
        Intent intent = new Intent(this, newHero.class);
        startActivity(intent);
    }

    //átváltás információk képernyőra
    public void callInfos(View v){
        Intent intent = new Intent(this, infos.class);
        startActivity(intent);
    }

    //átváltás információk képernyőra
    public void callEdit(View v){
        Intent intent = new Intent(this, editHero.class);
        startActivity(intent);
    }

    //listaadapter
    private class listAdapter extends ArrayAdapter<hero> {

        public  listAdapter() {
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

            TextView itemName = (TextView) itemView.findViewById(R.id.textHeroName);
            itemName.setText(currentHero.getName());

            TextView itemFaction = (TextView) itemView.findViewById(R.id.textHeroFaction);
            if (currentHero.isFaction())
            {
                itemFaction.setText("Alliance");
            }
            else
            {
                itemFaction.setText("Horde");
            }

            TextView itemClass = (TextView) itemView.findViewById(R.id.textHeroClass);
            itemClass.setText(currentHero.getHero_class().toString());

            return  itemView;
            //return  super.getView(position, convertView, parent);
        }

    }

    //debug hős létrehozása
    private void createDefaultHero()
    {
        heroList.add(new hero("Test", 1, 1, 1, 1, false, "Warrior", R.drawable.dahero));
    }

    private void editHero() {
        ListView listView = (ListView) findViewById(R.id.listCurrentHeroes);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //MainActivity.editHeroPos = position;
                callEdit(view);
            }
        });
    }
}
