package net.theb2tech.rpg_battle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class editHero extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_hero);
    }

    public void fill(hero edit) {

    }

    public void save(View v)
    {
        boolean faction;                                                        //hős frakciója, true=alliance, false= horde
        EditText nameText = (EditText) findViewById(R.id.textHeroName);         //hős neve
        EditText hpText = (EditText) findViewById(R.id.textHeroHp);             //hős életereje
        EditText manaText = (EditText) findViewById(R.id.textHeroMana);         //hős varázsereje
        EditText wpnDmgText = (EditText) findViewById(R.id.textHeroWpnDmg);     //hős fegyversebzése
        EditText defText = (EditText) findViewById(R.id.textHeroDef);           //hős védelme
        Spinner factionDrop = (Spinner) findViewById(R.id.dropFaction);
        Spinner heroClassDrop = (Spinner) findViewById(R.id.dropHeroClass);     //hős osztálya
        if (factionDrop.getSelectedItem().toString() == "Horde")
        {
            faction = false;
        }
        else
        {
            faction = true;
        }

        hero tempHero = new hero(nameText.getText().toString(),
                Integer.parseInt(hpText.getText().toString()),
                Integer.parseInt(manaText.getText().toString()),
                Integer.parseInt(wpnDmgText.getText().toString()),
                Integer.parseInt(defText.getText().toString()),
                faction,
                heroClassDrop.getSelectedItem().toString(),
                R.drawable.dahero);
        // TODO kép kiválasztása
        MainActivity.heroList.add(tempHero);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
