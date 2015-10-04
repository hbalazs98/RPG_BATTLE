package net.theb2tech.rpg_battle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.Console;

/**
 * Created by Balázs on 2015. 09. 27..
 */
public class newHero extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newhero);
    }

    boolean check() {
        EditText hpText = (EditText) findViewById(R.id.textHeroHp);             //hős életereje
        EditText manaText = (EditText) findViewById(R.id.textHeroMana);         //hős varázsereje
        EditText wpnDmgText = (EditText) findViewById(R.id.textHeroWpnDmg);     //hős fegyversebzése
        EditText defText = (EditText) findViewById(R.id.textHeroDef);           //hős védelme

        boolean valid = true;

        if (Integer.parseInt(hpText.getText().toString()) < 10) {
            Toast.makeText(this, "Az életerő nem lehet 10-nél kissebb!", Toast.LENGTH_LONG).show();
            valid = false;
        } else if (Integer.parseInt(hpText.getText().toString()) > 500) {
            Toast.makeText(this, "Az életerő nem lehet 500-nál nagyobb!", Toast.LENGTH_LONG).show();
            valid = false;
        }

        if (Integer.parseInt(manaText.getText().toString()) < 0) {
            Toast.makeText(this, "Az varázserő nem lehet 0-nál kissebb!", Toast.LENGTH_LONG).show();
            valid = false;
        } else if (Integer.parseInt(hpText.getText().toString()) > 20) {
            Toast.makeText(this, "Az varázserő nem lehet 20-nál nagyobb!", Toast.LENGTH_LONG).show();
            valid = false;
        }

        if (Integer.parseInt(wpnDmgText.getText().toString()) < 1) {
            Toast.makeText(this, "Az fegyver sebzése nem lehet 1-nél kissebb!", Toast.LENGTH_LONG).show();
            valid = false;
        } else if (Integer.parseInt(wpnDmgText.getText().toString()) > 10) {
            Toast.makeText(this, "Az fegyver sebzése nem lehet 10-nál nagyobb!", Toast.LENGTH_LONG).show();
            valid = false;
        }

        if (Integer.parseInt(defText.getText().toString()) < 1) {
            Toast.makeText(this, "Az védelmi képesség nem lehet 1-nél kissebb!", Toast.LENGTH_LONG).show();
            valid = false;
        } else if (Integer.parseInt(defText.getText().toString()) > 10) {
            Toast.makeText(this, "Az védelmi képesség nem lehet 10-nál nagyobb!", Toast.LENGTH_LONG).show();
            valid = false;
        }

        return valid;
    }

    public void save(View v) {
        if (check()) {
            EditText nameText = (EditText) findViewById(R.id.textHeroName);         //hős neve
            EditText hpText = (EditText) findViewById(R.id.textHeroHp);             //hős életereje
            EditText manaText = (EditText) findViewById(R.id.textHeroMana);         //hős varázsereje
            EditText wpnDmgText = (EditText) findViewById(R.id.textHeroWpnDmg);     //hős fegyversebzése
            EditText defText = (EditText) findViewById(R.id.textHeroDef);           //hős védelme
            Spinner factionDrop = (Spinner) findViewById(R.id.dropFaction);
            Spinner heroClassDrop = (Spinner) findViewById(R.id.dropHeroClass);     //hős osztálya

            try {
                hero tempHero = new hero(nameText.getText().toString(),
                        Integer.parseInt(hpText.getText().toString()),
                        Integer.parseInt(manaText.getText().toString()),
                        Integer.parseInt(wpnDmgText.getText().toString()),
                        Integer.parseInt(defText.getText().toString()),
                        factionDrop.getSelectedItem().toString(),
                        heroClassDrop.getSelectedItem().toString(),
                        R.drawable.dahero);
                MainActivity.heroList.add(tempHero);
            } catch (Exception e) {
                Toast.makeText(this, "Az egyik tulajdonság hinányzik!", Toast.LENGTH_LONG).show();
            }
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}
