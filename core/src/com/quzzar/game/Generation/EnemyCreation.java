package com.quzzar.game.Generation;

import com.quzzar.game.Combat.Entities.Groups.Monster;
import com.quzzar.game.Combat.Entities.Monsters.Antelope;
import com.quzzar.game.Combat.Entities.Monsters.Archon;
import com.quzzar.game.Combat.Entities.Monsters.Badger;
import com.quzzar.game.Combat.Entities.Monsters.Basilisk;
import com.quzzar.game.Combat.Entities.Monsters.Boar;
import com.quzzar.game.Combat.Entities.Monsters.Crab;
import com.quzzar.game.Combat.Entities.Monsters.Cultist;
import com.quzzar.game.Combat.Entities.Monsters.Demon;
import com.quzzar.game.Combat.Entities.Monsters.Djinn;
import com.quzzar.game.Combat.Entities.Monsters.Druid;
import com.quzzar.game.Combat.Entities.Monsters.Dryad;
import com.quzzar.game.Combat.Entities.Monsters.Fox;
import com.quzzar.game.Combat.Entities.Monsters.Fury;
import com.quzzar.game.Combat.Entities.Monsters.Goblin;
import com.quzzar.game.Combat.Entities.Monsters.Harpy;
import com.quzzar.game.Combat.Entities.Monsters.Leech;
import com.quzzar.game.Combat.Entities.Monsters.Ogre;
import com.quzzar.game.Combat.Entities.Monsters.Orc;
import com.quzzar.game.Combat.Entities.Monsters.Shade;
import com.quzzar.game.Combat.Entities.Monsters.Wizard;
import com.quzzar.game.Combat.Entities.Monsters.Zombie;

import java.util.Random;

public class EnemyCreation {


    public static Monster createWeakEnemy(){

        Random rand = new Random();

        int r = rand.nextInt(16);

        if(r==0){
            return new Cultist();
        }

        if(r==1){
            return new Antelope();
        }

        if(r==2){
            return new Goblin();
        }

        if(r==3){
            return new Fox();
        }

        if(r==4){
            return new Leech();
        }

        if(r==5){
            return new Badger();
        }

        if(r==6){
            return new Boar();
        }

        if(r==7){
            return new Crab();
        }

        if(r==8){
            return new Druid();
        }

        if(r==9){
            return new Dryad();
        }

        if(r==10){
            return new Zombie();
        }

        if(r==11){
            return new Orc();
        }

        if(r==12){
            return new Shade();
        }

        if(r==14){
            return new Wizard();
        }

        if(r==15){
            return createStrongEnemy();
        }

        return new Goblin();
    }

    public static Monster createStrongEnemy(){

        Random rand = new Random();

        int r = rand.nextInt(7);

        if(r==0){
            return new Archon();
        }

        if(r==1){
            return new Basilisk();
        }

        if(r==2){
            return new Demon();
        }

        if(r==3){
            return new Djinn();
        }

        if(r==4){
            return new Fury();
        }

        if(r==5){
            return new Harpy();
        }

        if(r==6){
            return new Ogre();
        }

        return new Demon();
    }


}
