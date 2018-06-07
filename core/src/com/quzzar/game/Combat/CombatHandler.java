package com.quzzar.game.Combat;

import com.quzzar.game.Combat.Entities.Groups.Monster;
import com.quzzar.game.Player.Player;
import com.quzzar.game.Player.Stats;
import com.quzzar.game.Utility;

import java.util.Random;

public class CombatHandler {
    public static void doCombat(Monster enemy){
        Stats stats = Player.getStats();

        double playerSpeedR = stats.getSpeed()*1.0/enemy.getSpeed();
        double enemySpeedR = enemy.getSpeed()*1.0/stats.getSpeed();

        boolean playerHit = checkHit(playerSpeedR);
        boolean enemyHit = checkHit(enemySpeedR);
        boolean poisonous = enemy.poisonous;
        boolean poisoned = false;
        int poisonCount = 0;


        Utility.print("COMBAT","pSpeed:"+stats.getSpeed());
        Utility.print("COMBAT","eSpeed:"+enemy.getSpeed());

        if (enemyHit && poisonous) {
            if (poisoned) {
                poisonCount = 0;
            } else {
                poisoned = true;
                Utility.print("COMBAT", "Player has been poisoned");
                }
            }
        if (poisoned && !playerHit) {
                Player.hurt(2);
                Utility.print("COMBAT", "Player took 2 damage from poison" + stats.getHealth());
                poisonCount++;
                if (poisonCount == 3) {
                    poisoned = false;
                    poisonCount = 0;
                }
        }
        if(playerHit){
            enemy.hurt(calculateDamage(stats.getDamage(), enemy.getDefense()));
        }
        if(enemyHit){
            Player.hurt(calculateDamage(enemy.getDamage(), stats.getDefense()));
        }

        Utility.print("COMBAT","Enemy Damage:"+enemy.getDamage());

        Utility.print("COMBAT","Enemy Final Damage:"+calculateDamage(enemy.getDamage(), stats.getDefense()));

    }

    private static double calculateDamage(double attackerDamage, double defenderDefense){
        return attackerDamage - attackerDamage*((defenderDefense*1.0)/20);

    }

    private static boolean checkHit(double speedR){

        int odds = (int) Math.round(1/(0.931238 - 1.034495*Math.pow(Math.E,-0.875008*speedR)));

        Random rand = new Random();

        int r = rand.nextInt(odds);


        Utility.print("COMBAT","SpeedR:"+speedR);

        Utility.print("COMBAT","Odds:"+odds);

        Utility.print("COMBAT","R:"+r);



        return r==0;
    }

}
