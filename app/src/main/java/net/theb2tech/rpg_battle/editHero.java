package net.theb2tech.rpg_battle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class editHero extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_hero);
        fill();
    }

    public void fill() {
        EditText nameText = (EditText) findViewById(R.id.text_name);         //hős neve
        nameText.setText(MainActivity.heroList.get(MainActivity.editHeroPos).getName());

        EditText hpText = (EditText) findViewById(R.id.tex_hp);             //hős életereje
        hpText.setText(Double.toString(MainActivity.heroList.get(MainActivity.editHeroPos).getHp()));

        EditText manaText = (EditText) findViewById(R.id.text_mana);         //hős varázsereje
        manaText.setText(Integer.toString(MainActivity.heroList.get(MainActivity.editHeroPos).getMana()));

        EditText wpnDmgText = (EditText) findViewById(R.id.text_dmg);     //hős fegyversebzése
        wpnDmgText.setText(Integer.toString(MainActivity.heroList.get(MainActivity.editHeroPos).getWpnDmg()));

        EditText defText = (EditText) findViewById(R.id.text_def);           //hős védelme
        defText.setText(Integer.toString(MainActivity.heroList.get(MainActivity.editHeroPos).getDef()));

        Spinner factionDrop = (Spinner) findViewById(R.id.dropFaction);
        if (MainActivity.heroList.get(MainActivity.editHeroPos).getFaction() == "Alliance") {
            factionDrop.setSelection(0);
        } else {
            factionDrop.setSelection(1);
        }
        Spinner heroClassDrop = (Spinner) findViewById(R.id.dropHeroClass);     //hős osztálya*/
    }

    public void save(View v) {
        EditText nameText = (EditText) findViewById(R.id.text_name);         //hős neve
        EditText hpText = (EditText) findViewById(R.id.tex_hp);             //hős életereje
        EditText manaText = (EditText) findViewById(R.id.text_mana);         //hős varázsereje
        EditText wpnDmgText = (EditText) findViewById(R.id.text_dmg);     //hős fegyversebzése
        EditText defText = (EditText) findViewById(R.id.text_def);           //hős védelme
        Spinner factionDrop = (Spinner) findViewById(R.id.dropFaction);
        Spinner heroClassDrop = (Spinner) findViewById(R.id.dropHeroClass);     //hős osztálya

        hero tempHero = new hero(nameText.getText().toString(),
                Double.parseDouble(hpText.getText().toString()),
                Integer.parseInt(manaText.getText().toString()),
                Integer.parseInt(wpnDmgText.getText().toString()),
                Integer.parseInt(defText.getText().toString()),
                factionDrop.getSelectedItem().toString(),
                heroClassDrop.getSelectedItem().toString(),
                R.drawable.dahero);
        MainActivity.heroList.set(MainActivity.editHeroPos, tempHero);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
