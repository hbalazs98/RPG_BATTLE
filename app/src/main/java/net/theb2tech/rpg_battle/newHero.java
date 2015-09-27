package net.theb2tech.rpg_battle;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by Balázs on 2015. 09. 27..
 */
public class newHero extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newhero);
    }

    public void save()
    {
        EditText nameText = (EditText) findViewById(R.id.hero_name);
        EditText hpText = (EditText) findViewById(R.id.hero_hp);
        EditText manaText = (EditText) findViewById(R.id.hero_sp);
        EditText wpnDmgText = (EditText) findViewById(R.id.hero_weapondamage);
        EditText defText = (EditText) findViewById(R.id.hero_defense);
        Spinner factionDrop = (Spinner) findViewById(R.id.faction);
        hero tempHero = new hero(nameText.getText().toString(),
                Integer.parseInt(hpText.getText().toString()),
                Integer.parseInt(manaText.getText().toString()),
                Integer.parseInt(wpnDmgText.getText().toString()),
                Integer.parseInt(defText.getText().toString()),
                false);
        MainActivity.heroList.add(tempHero);
    }

    public void editTextClick(View v){
        EditText editttext = (EditText) v;
        editttext.setText("");
    }
}
