package net.theb2tech.rpg_battle;

/**
 * Created by Balázs on 27/09/2015.
 */
public class hero{

    private String name;
    private int hp;
    private int mana;
    private int wpnDmg;
    private int def;

    public boolean isFaction() {
        return faction;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getWpnDmg() {
        return wpnDmg;
    }

    public int getDef() {
        return def;
    }

    private boolean faction;

    public hero(String name, int hp, int mana, int wpnDmg, int def, boolean faction)
    {
        this.name = name;
        this.hp = hp;
        this.mana = mana;
        this.wpnDmg = wpnDmg;
        this.def = def;
        this.faction = faction;
    }
}
