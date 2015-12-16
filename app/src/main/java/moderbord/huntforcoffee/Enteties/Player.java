package moderbord.huntforcoffee.Enteties;

import android.content.Context;

import moderbord.huntforcoffee.Entity;
import moderbord.huntforcoffee.GameFunctions.Armour;
import moderbord.huntforcoffee.GameFunctions.Inventory;
import moderbord.huntforcoffee.GameFunctions.Resistance;
import moderbord.huntforcoffee.GameFunctions.Weapon;

/**
 * Created by Moderbord on 2015-12-07.
 */

public class Player extends Entity{


    public Player(Context context, String eName, String eGender, String eClass, String eRace, String eFaction, int eLevel, int ePhysique,
                  int eIntellect, int eAgility, int eQuickness, int eCharisma, int eLuck, int eLi, int eMaxHealth, int eHealth, int eMaxMana,
                  int eMana, int eMaxFatigue, int eFatigue, int eLu, int eMinLu, int eExperience, int eExpToLvl, Weapon backWep, Weapon mainWep,
                  Weapon offWep, Armour armHead, Armour armShoulders, Armour armChest, Armour armGloves, Armour armLegs, Armour armFeet,
                  Resistance resistance, Inventory inventory) {
        super(context, eName, eGender, eClass, eRace, eFaction, eLevel, ePhysique, eIntellect, eAgility, eQuickness, eCharisma, eLuck, eLi,
                eMaxHealth, eHealth, eMaxMana, eMana, eMaxFatigue, eFatigue, eLu, eMinLu, eExperience, eExpToLvl, backWep, mainWep, offWep,
                armHead, armShoulders, armChest, armGloves, armLegs, armFeet, resistance, inventory);
    }

    @Override
    public void info(){ // ID 11111
        main.flags.mainMenu = false;
        System.out.println("INFO from Player here!");
        main.appendText("YOU ARE STRONG " + geteName() + "!");
        main.submitText();

        main.ui.toggleButtons(1);
        main.eventManager.clrEventList();
        main.eventManager.prepEvent("Inventory", 11112, 2);
        main.eventManager.prepEvent("Options", 9099, 4);
        main.eventManager.prepEvent("Back", 99901, 9); //IntroGood
        main.ui.toggleButtons(2);
    }

    @Override
    public void inventory() { // ID 11112
        System.out.println("INVENTORY from Player here!");
        try {main.appendText(this.getInventory().printInventory(this));} catch (Exception e) {}
        main.submitText();

        main.ui.toggleButtons(1);
        main.eventManager.clrEventList();
        if (this.getInventory().getInvItem(this, 0) != null) {
            main.eventManager.prepEvent("Consume", 11113, 0);
            main.eventManager.prepEvent("Equip", 11113, 1);
            main.eventManager.prepEvent("Drop", 11113, 4);
        }
        main.eventManager.prepEvent("Back", 11111, 9);
        main.ui.toggleButtons(2);
    }

    @Override
    public void inventoryChoice(){ // ID 11113
        System.out.println("INVENTORY from Player here!");
        try {main.appendText(this.getInventory().printInventory(this));} catch (Exception e) {}
        main.appendText("\n\nWhich item?");
        main.submitText();

        String choice = main.eventManager.getEventChoice();
        int next;
        if(choice.equals("Consume")){next = 11114;} else if(choice.equals("Equip")){next = 11115;} else {next = 11116;}

        main.ui.toggleButtons(1);
        main.eventManager.clrEventList();
        if(this.getInventory().getInvItem(this, 0) != null){main.eventManager.prepEvent("1", next, 0);}
        if(this.getInventory().getInvItem(this, 1) != null){main.eventManager.prepEvent("2", next, 1);}
        if(this.getInventory().getInvItem(this, 2) != null){main.eventManager.prepEvent("3", next, 2);}
        if(this.getInventory().getInvItem(this, 3) != null){main.eventManager.prepEvent("4", next, 3);}
        if(this.getInventory().getInvItem(this, 4) != null){main.eventManager.prepEvent("5", next, 4);}
        main.eventManager.prepEvent("Back", 11112, 9);
        main.ui.toggleButtons(2);
    }

    @Override
    public void consumeX(){ // ID 11114
        System.out.println("CONSUMEX from Player here!");
        int x = Integer.parseInt(main.eventManager.getEventChoice()) - 1; // Corrects index
        main.consumer.consumeSwitch(this, this.getInventory().getInvItem(this, x));

        if (main.flags.consuming) {
            this.getInventory().getInvItem(this, x).setAmount(this.getInventory().getInvItem(this, x).getAmount() - 1);

            String iName = this.getInventory().getInvItem(this, x).getiName();
            if(this.getInventory().getInvItem(this, x).getAmount() < 1) {
                this.getInventory().removeItem(this, x);
                main.appendText("\n\nYou consumed your last " + iName);
            }
        }

        main.submitText();
        main.ui.toggleButtons(1);
        main.eventManager.clrEventList();
        main.eventManager.prepEvent("Next", 11112, 0);
        main.ui.toggleButtons(2);
    }

    @Override
    public void equipX(){ // ID 11115

    }

    @Override
    public void dropX(){ // ID 11116
        System.out.println("DROPX from Player here!");
        int x = Integer.parseInt(main.eventManager.getEventChoice()) - 1; // Corrects index
        String iName = this.getInventory().getInvItem(this, x).getiName();
        int qty = this.getInventory().getInvItem(this, x).getAmount();
        this.getInventory().removeItem(this, x);
        main.appendText(qty + " " + iName + " was removed from your inventory");
        main.submitText();
        main.ui.toggleButtons(1);
        main.eventManager.clrEventList();
        main.eventManager.prepEvent("Next", 11112, 0);
        main.ui.toggleButtons(2);
    }

}
