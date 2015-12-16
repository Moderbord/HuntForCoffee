package moderbord.huntforcoffee;


import android.content.Context;

import moderbord.huntforcoffee.GameFunctions.Item;
import moderbord.huntforcoffee.GameFunctions.Weapon;

/**
 * Created by Moderbord on 2015-12-05.
 */
public class EventClass {

    protected MainActivity main;

    public EventClass(Context context){
        this.main = (MainActivity) context;
    }

    public void introGood(){ // ID 99901
        System.out.println("INTROGOOD from EventClass here!");
        main.appendText("You arrive back to your small encampment which consists of a simple tent and a cooking pot hanging above a fireplace.");
        main.appendText("\n\nThe forrest is all around you.");
        main.appendText("\n\nWhat do you feel like doing now?");
        main.submitText();

        main.ui.toggleButtons(1);
        main.eventManager.clrEventList();
        main.eventManager.prepEvent("Forrest", 10001, 0);
        main.eventManager.prepEvent("Hero", 11111, 4);
        main.ui.toggleButtons(2);

    }

    public void getForrest(){ // ID 10001
        System.out.println("FORREST from EventClass here!");
        main.appendText("Welcome to the jungle!");
        main.appendText("We hope you brought lotion.");
        main.appendText(main.player.getInventory().addItemToInv(main.player, new Item("burger", "consumable", 1),1));
        main.submitText();

        main.ui.toggleButtons(1);
        main.eventManager.clrEventList();
        int x = main.eventManager.stirThePot("forrest");
        main.eventManager.prepEvent("Search", x, 5);
        main.eventManager.prepEvent("Camp", 99901, 9);
        main.ui.toggleButtons(2);

    }

    public void forrestSearchOne(){ // ID 10002
        System.out.println("FORRESTSEARCHONE from EventClass here!");
        main.appendText("Not much from search one...");
        main.appendText(main.player.getInventory().addItemToInv(main.player, new Weapon("hatchet", "weapon", 1, 1, 0, 100, 11, "axe", "cleaving", 2, 12), 1));
        main.submitText();


        main.ui.toggleButtons(1);
        main.eventManager.clrEventList();
        main.eventManager.prepEvent("Next", 10001, 0);
        main.ui.toggleButtons(2);
    }

    public void forrestSearchTwo(){ // ID 10003
        System.out.println("FORRESTSEARCHTWO from EventClass here!");
        main.appendText("Not much from search two...");
        main.submitText();

        main.ui.toggleButtons(1);
        main.eventManager.clrEventList();
        main.eventManager.prepEvent("Next", 10001, 0);
        main.ui.toggleButtons(2);
    }

    public void forrestSearchThree(){ // ID 10004
        System.out.println("FORRESTSEARCHTHREE from EventClass here!");
        main.appendText("Not much from search three...");
        main.submitText();

        main.ui.toggleButtons(1);
        main.eventManager.clrEventList();
        main.eventManager.prepEvent("Next", 10001, 0);
        main.ui.toggleButtons(2);
    }

}
