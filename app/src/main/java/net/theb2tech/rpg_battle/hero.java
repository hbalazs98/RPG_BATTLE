package net.theb2tech.rpg_battle;

import android.view.View;
import android.widget.EditText;

/**
 * Created by Balázs on 27/09/2015.
 */
public class hero{

    public String name;
    public int hp;
    public int mana;
    public int wpnDmg;
    public int def;

    public void hero(String nameIn, int hpIn, int manaIn, int wpnDmgIn, int defIn)
    {
        name = nameIn;
        hp = hpIn;
        mana = manaIn;
        wpnDmg = wpnDmgIn;
        def = defIn;
    }
}
