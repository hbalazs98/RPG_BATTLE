package net.theb2tech.rpg_battle;

import java.util.Random;

/**
 * Created by Balázs on 2015. 09. 27..
 */
public class calculate {
    static Random rand = new Random();

    //attacker hős támadásának számítása
    public static int attack(hero attacker)
    {
        if (attacker.getMana() == 0) {
            return attacker.getWpnDmg() * (rand.nextInt(45) + 70) / 10;
        }
        else {
            if (rand.nextBoolean())
            {
                if (attacker.getMana() > 5) {
                    attacker.setMana(attacker.getMana()-5);
                    return (attacker.getWpnDmg() * (rand.nextInt(45) + 70) / 10) * (1 + (5/5));
                }
                else {
                    int manaUsed = attacker.getMana();
                    return (attacker.getWpnDmg() * (rand.nextInt(45) + 70) / 10) * (1 + (manaUsed/5));
                }
            }
            else {
                return attacker.getWpnDmg() * (rand.nextInt(45) + 70) / 10;
            }
        }
    }

    //defender hős védelmének számítása
    public static int defence(hero defender)
    {
        return (defender.getDef())*((int)Math.floor(Math.random() * (13 - 5 + 1)) + 5)/10;
    }
}
