package moderbord.huntforcoffee;


import android.content.Context;

import moderbord.huntforcoffee.GameFunctions.Item;

/**
 * Created by Moderbord on 2015-12-05.
 */
public class EventClass {

    protected MainActivity main;

    public EventClass(Context context){
        this.main = (MainActivity) context;
    }

    public void introGood(){ // ID 99980
        System.out.println("INTROGOOD from EventClass here!");
        main.appendText("You arrive back to your small encampment which consists of a simple tent and a cooking pot hanging above a fireplace.");
        main.appendText("\n\nThe forrest is all around you.");
        main.appendText("\n\nWhat do you feel like doing now?");
        main.submitText();

        main.ui.toggleButtons(1);
        main.eventManager.clrEventList();
        main.eventManager.prepEvent("Forrest", 10001, 0);
        main.eventManager.prepEvent("Hero", 11111, 9);
        main.ui.toggleButtons(2);

    }

    public void getForrest(){ // ID 10001
        System.out.println("FORREST from EventClass here!");
        main.appendText("Welcome to the jungle!");
        main.appendText("We hope you brought lotion.");
        main.appendText(main.player.getInventory().addItemToInv(main.player, new Item("Burger", "consumable", 1),1));
        main.appendText(main.player.getInventory().addItemToInv(main.player, new Item("Herp", "consumable", 1),1));
        main.appendText(main.player.getInventory().addItemToInv(main.player, new Item("Derp", "consumable", 1),3));
        main.appendText(main.player.getInventory().addItemToInv(main.player, new Item("Adda", "consumable", 1),5));
        main.appendText(main.player.getInventory().addItemToInv(main.player, new Item("Agedf", "consumable", 1),8));
        main.appendText(main.player.getInventory().addItemToInv(main.player, new Item("Drake", "consumable", 1),1));
        main.submitText();

        main.ui.toggleButtons(1)
        ;main.eventManager.clrEventList();
        main.eventManager.prepEvent("Back", 99980, 0);
        main.ui.toggleButtons(2);

    }

}
