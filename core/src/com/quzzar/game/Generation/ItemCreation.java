package com.quzzar.game.Generation;

import com.quzzar.game.Inventory.Item;
import com.quzzar.game.Inventory.Items.BoneHelmet;
import com.quzzar.game.Inventory.Items.Book;
import com.quzzar.game.Inventory.Items.EmeraldRing;
import com.quzzar.game.Inventory.Items.GoldAxe;
import com.quzzar.game.Inventory.Items.GoldRing;
import com.quzzar.game.Inventory.Items.HealthPotion;
import com.quzzar.game.Inventory.Items.HealthPotionGreater;
import com.quzzar.game.Inventory.Items.HealthPotionLesser;
import com.quzzar.game.Inventory.Items.IronHelmet;
import com.quzzar.game.Inventory.Items.LeatherArmor;
import com.quzzar.game.Inventory.Items.MagicBook;
import com.quzzar.game.Inventory.Items.OnyxRing;
import com.quzzar.game.Inventory.Items.RubyRing;
import com.quzzar.game.Inventory.Items.ShortSword;

import java.util.Random;

public class ItemCreation {

    public static Item createCommonItem(){

        Random rand = new Random();

        int r = rand.nextInt(16);

        if(r==0){
            return new HealthPotionGreater();
        }

        if(r==1){
            return new HealthPotion();
        }

        if(r==2){
            return new HealthPotion();
        }

        if(r==3){
            return new GoldRing();
        }

        if(r==4){
            return new GoldAxe();
        }

        if(r==5){
            return new ShortSword();
        }

        if(r==6){
            return new OnyxRing();
        }

        if(r==7){
            return new LeatherArmor();
        }

        if(r==8){
            return new EmeraldRing();
        }

        if(r==9){
            return new RubyRing();
        }

        if(r==10){
            return new HealthPotionLesser();
        }

        if(r==11){
            return new HealthPotionLesser();
        }

        if(r==12){
            return new HealthPotionLesser();
        }

        if(r==13){
            return new BoneHelmet();
        }

        if(r==14){
            return new IronHelmet();
        }

        if(r==15){
            return new MagicBook();
        }

        return new HealthPotion();
    }

}
