package net.theb2tech.rpg_battle;

import java.util.Random;

/**
 * Created by Balázs on 2015. 09. 27..
 */
public class calculate {
    Random rand = new Random();

    public int dmg(hero attacker)
    {
        if (attacker.mana == 0) {
            return attacker.wpnDmg * (rand.nextInt(45) + 70) / 10;
        }
        else {
            if (rand.nextBoolean())
            {
                if (attacker.mana > 5) {
                    attacker.mana-=5;
                    return (attacker.wpnDmg * (rand.nextInt(45) + 70) / 10) * (1 + (5/5));
                }
                else
            }
        }
    }
}
