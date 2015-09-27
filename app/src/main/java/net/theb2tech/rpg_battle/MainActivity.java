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

    public static List<hero> heroList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.current_heroes);
        populateListView();
        //createDefaultHero();
    }

    private void createDefaultHero()
    {
        heroList.add(new hero("Test",1,1,1,1,false,R.drawable.dahero));
    }

    private void populateListView() {
        ArrayAdapter<hero> adapter = new listAdapter();
        ListView listView = (ListView) findViewById(R.id.current_heroes);
        listView.setAdapter(adapter);
    }

    public void buttonOnClick(View v){
        Intent intent = new Intent(this, newHero.class);
        startActivity(intent);
    }

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

            return  itemView;
            //return  super.getView(position, convertView, parent);
        }
    }
}
