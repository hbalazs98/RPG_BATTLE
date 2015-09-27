package net.theb2tech.rpg_battle;

import java.util.Random;

/**
 * Created by Balázs on 2015. 09. 27..
 */
public class calculate {
    public int dmg(hero attacker)
    {
        if (attacker.mana == 0) {
            Random rand = new Random();
            return attacker.wpnDmg * (rand.nextInt(45) + 70) / 10;
        }
        
    }
}
