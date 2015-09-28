package net.theb2tech.rpg_battle;

import java.util.Random;

/**
 * Created by Balázs on 2015. 09. 27..
 */
public class calculate {
    Random rand = new Random();

    //attacker hős támadásának számítása
    public double dmg(hero attacker)
    {
        if (attacker.getMana() == 0) {
            return attacker.getWpnDmg() * (Math.floor(Math.random() * (13 - 5 + 1)) + 5)/10;
        }
        else {
            if (rand.nextBoolean())
            {
                if (attacker.getMana() > 5) {
                    attacker.setMana(attacker.getMana()-5);
                    return (attacker.getWpnDmg() * (Math.floor(Math.random() * (13 - 5 + 1)) + 5)/10 * (1 + (5/5)));
                }
                else {
                    int manaUsed = attacker.getMana();
                    return (attacker.getWpnDmg() * (Math.floor(Math.random() * (13 - 5 + 1)) + 5)/10 * (1 + (manaUsed/5)));
                }
            }
            else {
                return attacker.getWpnDmg() * (Math.floor(Math.random() * (13 - 5 + 1)) + 5)/10;
            }
        }
    }

    //defender hős védelmének számítása
    public double defence(hero defender)
    {
        double herodef = (defender.getDef())*(Math.floor(Math.random() * (13 - 5 + 1)) + 5)/10;
        if (defender.getMana() == 0) {
            //return defender.getWpnDmg() * (rand.nextInt(45) + 70) / 10;
        }
        else {
            if (rand.nextBoolean())
            {
                if (defender.getMana() > 5) {
                    defender.setMana(defender.getMana()-5);
                    return (herodef) * (1+(defender.getMana()/2.5));
                }
                else {
                    int manaUsed = defender.getMana();
                    return (herodef) * (1+(defender.getMana()/2.5)) * (1 + (manaUsed/5));
                }
            }
            else {
                return herodef;
            }
        }
        return 0;
    }
}
