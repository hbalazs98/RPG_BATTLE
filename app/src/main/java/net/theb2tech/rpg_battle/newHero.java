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

    public void callChooseImage()
    {
        Intent intent = new Intent(this, chooseImage.class);
        startActivity(intent);
    }

    public void save(View v)
    {
        boolean faction;
        EditText nameText = (EditText) findViewById(R.id.hero_name);
        EditText hpText = (EditText) findViewById(R.id.hero_hp);
        EditText manaText = (EditText) findViewById(R.id.hero_sp);
        EditText wpnDmgText = (EditText) findViewById(R.id.hero_weapondamage);
        EditText defText = (EditText) findViewById(R.id.hero_defense);
        Spinner factionDrop = (Spinner) findViewById(R.id.faction);
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
                R.drawable.dahero);
        // TODO kép kiválasztása
        MainActivity.heroList.add(tempHero);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
