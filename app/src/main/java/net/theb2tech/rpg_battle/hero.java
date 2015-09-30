package net.theb2tech.rpg_battle;

/**
 * Created by Balázs on 27/09/2015.
 */
public class hero {

    private String name;
    private double hp;
    private int mana;
    private int wpnDmg;
    private int def;
    private int iconId;
    private String hero_class;

    public String getFaction() {
        return faction;
    }

    private String faction;

    public int getIconId() {
        return iconId;
    }

    public String getName() {
        return name;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
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

    public String getHero_class() {
        return hero_class;
    }

    ;

    public hero(String name, int hp, int mana, int wpnDmg, int def, String faction, String hero_class, int iconId) {
        this.name = name;
        this.hp = hp;
        this.mana = mana;
        this.wpnDmg = wpnDmg;
        this.def = def;
        this.faction = faction;
        this.iconId = iconId;
        this.hero_class = hero_class;
    }
}
