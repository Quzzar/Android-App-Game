package com.quzzar.game.Generation;

import com.quzzar.game.Combat.Entities.Groups.Monster;
import com.quzzar.game.Combat.Entities.Monsters.Cultist;
import com.quzzar.game.Combat.Entities.Monsters.Furry;
import com.quzzar.game.Combat.Entities.Monsters.Goblin;

import java.util.Random;

public class EnemyCreation {


    public static Monster createWeakEnemy(){

        Random rand = new Random();

        int r = rand.nextInt(3);

        if(r==0){
            return new Cultist();
        }

        if(r==1){
            return new Furry();
        }

        if(r==2){
            return new Goblin();
        }

        return new Goblin();
    }


}
