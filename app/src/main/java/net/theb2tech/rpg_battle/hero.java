package net.theb2tech.rpg_battle;

/**
 * Created by Balázs on 27/09/2015.
 */
public class hero{

    public String name;
    public int hp;
    public int mana;
    public int wpnDmg;
    public int def;
    public boolean faction;

    public hero(String nameIn, int hpIn, int manaIn, int wpnDmgIn, int defIn, boolean factionIn)
    {
        name = nameIn;
        hp = hpIn;
        mana = manaIn;
        wpnDmg = wpnDmgIn;
        def = defIn;
        faction = factionIn;
    }
}
