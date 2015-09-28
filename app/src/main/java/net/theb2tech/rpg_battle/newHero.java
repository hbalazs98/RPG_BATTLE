package net.theb2tech.rpg_battle;

import android.app.Activity;
import android.content.Intent;
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
        MainActivity.heroList.add(tempHero);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
