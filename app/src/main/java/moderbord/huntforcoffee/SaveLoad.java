package moderbord.huntforcoffee;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import moderbord.huntforcoffee.GameFunctions.Inventory;
import moderbord.huntforcoffee.GameFunctions.Item;

/**
 * Created by Moderbord on 2015-12-13.
 */
public class SaveLoad {

    protected MainActivity main;
    public SaveLoad(Context context){this.main = (MainActivity) context;}

    private String eName, eGender, eClass, eRace, eFaction;
    private int eLevel, ePhysique, eIntellect, eAgility, eQuickness, eCharisma, eLuck, eLi, eMaxHealth, eHealth, eMaxMana, eMana, eMaxFatigue, eFatigue, eLu, eMinLu, eExperience, eExpToLvl;
    //private boolean

    public void mainMenu(){ // ID 8008
        System.out.println("MAINMENU from EventClass here!");
        main.flags.mainMenu=true;
        main.appendText("Welcome back!");
        main.appendText("\n\nDo you want to create a new hero, or continue from a previous one?");
        main.submitText();

        main.ui.toggleButtons(1);
        main.eventManager.clrEventList();
        main.eventManager.prepEvent("New", 99991, 0);
        main.eventManager.prepEvent("Load", 9002, 1);
        main.eventManager.prepEvent("Continue", 11111, 4);
        main.eventManager.prepEvent("Delete", 9004, 8);
        main.ui.toggleButtons(2);
    }

    public void gameOptions(){ // ID 9099
        System.out.println("GAMEOPTIONS from SaveLoad here!");
        main.appendText("Game Options");
        main.submitText();
        main.appendInfo("");
        main.submitInfo();

        main.ui.toggleButtons(1);
        main.eventManager.clrEventList();
        main.eventManager.prepEvent("Save", 9000, 0);
        main.eventManager.prepEvent("Load", 9002, 3);
        main.eventManager.prepEvent("Main Menu", 8008, 4);
        main.eventManager.prepEvent("Back", 11111, 9);
        main.ui.toggleButtons(2);
    }

    public void saveGame(){ // ID 9000
        System.out.println("SAVEGAME from SaveLoad here!");
        main.appendText("Which slot do you want to save to?");
        main.submitText();
        main.appendInfo("");
        main.submitInfo();

        main.ui.toggleButtons(1);
        main.eventManager.clrEventList();
        main.eventManager.prepEvent("One", 9001, 0);
        main.eventManager.prepEvent("Two", 9001, 1);
        main.eventManager.prepEvent("Three", 9001, 2);
        main.eventManager.prepEvent("Four", 9001, 3);
        main.eventManager.prepEvent("Five", 9001, 4);
        main.eventManager.prepEvent("Six", 9001, 5);
        main.eventManager.prepEvent("Seven", 9001, 6);
        main.eventManager.prepEvent("Eight", 9001, 7);
        main.eventManager.prepEvent("Nine", 9001, 8);
        if(main.flags.mainMenu){
            main.eventManager.prepEvent("Back", 8008, 9);} else {main.eventManager.prepEvent("Back", 11111, 9);}
        main.ui.toggleButtons(2);
    }

    public void saveGameSlot(){ // ID 9001
        System.out.println("SAVEGAMESLOT from SaveLoad here!");
        String saveName = main.eventManager.getEventChoice();
        SharedPreferences sharedPreferences = main.getSharedPreferences(saveName, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();

        // Stats
        editor.putString("name", main.player.geteName());
        editor.putString("gender", main.player.geteGender());
        editor.putString("class", main.player.geteClass());
        editor.putString("race", main.player.geteRace());
        editor.putString("faction", main.player.geteFaction());
        editor.putInt("level", main.player.geteLevel());
        editor.putInt("physique", main.player.getePhysique());
        editor.putInt("intellect", main.player.geteIntellect());
        editor.putInt("agility", main.player.geteAgility());
        editor.putInt("quickness", main.player.geteQuickness());
        editor.putInt("charisma", main.player.geteCharisma());
        editor.putInt("luck", main.player.geteLuck());
        editor.putInt("li", main.player.geteLi());
        editor.putInt("maxHealth", main.player.geteMaxHealth());
        editor.putInt("health", main.player.geteHealth());
        editor.putInt("maxMana", main.player.geteMaxMana());
        editor.putInt("mana", main.player.geteMana());
        editor.putInt("maxFatigue", main.player.geteMaxFatigue());
        editor.putInt("fatigue", main.player.geteFatigue());
        editor.putInt("lu", main.player.geteLu());
        editor.putInt("minLu", main.player.geteMinLu());
        editor.putInt("experience", main.player.geteExperience());
        editor.putInt("expToLvl", main.player.geteExpToLvl());

        // Inventory
        List<String> iName = new ArrayList<String>(5);
        List<String> iType = new ArrayList<String>(5);
        List<Integer> iAmount = new ArrayList<Integer>(5);
        int i = 0;
        while(i < 5){
            try {
                iName.add(i, main.player.getInventory().getInvItem(main.player, i).getiName());
                iType.add(i, main.player.getInventory().getInvItem(main.player, i).getType());
                iAmount.add(i, main.player.getInventory().getInvItem(main.player, i).getAmount());
                System.out.println("Added " + iAmount.get(i) + " " + iType.get(i) + " " + iName.get(i) + " to " + i);
            } catch (Exception e) {}
            i++;
        }
        String invName = gson.toJson(iName);
        String InvType = gson.toJson(iType);
        String InvAmount = gson.toJson(iAmount);
        editor.putString("invName", invName);
        editor.putString("invType", InvType);
        editor.putString("invAmount", InvAmount);

        editor.apply();

        main.appendText("Done!");
        main.submitText();

        main.ui.toggleButtons(1);
        main.eventManager.clrEventList();
        main.eventManager.prepEvent("Done", 11111, 0);
        main.ui.toggleButtons(2);
    }

    public void loadGame(){ // ID 9002
        System.out.println("LOADGAME from SaveLoad here!");
        main.appendText("Which slot do you want to load?");
        main.appendInfo("");
        main.submitInfo();

        main.ui.toggleButtons(1);
        main.eventManager.clrEventList();

        try {
            SharedPreferences one = main.getSharedPreferences("One", 0);
            String name = one.getString("name", "");
            main.appendText("\n\n1. " + name);
            if (!name.equals("")) {main.eventManager.prepEvent("One", 9003, 0);}
        } catch (Exception e) {}

        try {
            SharedPreferences one = main.getSharedPreferences("Two", 0);
            String name = one.getString("name", "");
            main.appendText("\n\n2. " + name);
            if (!name.equals("")) {main.eventManager.prepEvent("Two", 9003, 1);}
        } catch (Exception e) {}

        try {
            SharedPreferences one = main.getSharedPreferences("Three", 0);
            String name = one.getString("name", "");
            main.appendText("\n\n3. " + name);
            if (!name.equals("")) {main.eventManager.prepEvent("Three", 9003, 2);}
        } catch (Exception e) {}

        try {
            SharedPreferences one = main.getSharedPreferences("Four", 0);
            String name = one.getString("name", "");
            main.appendText("\n\n4. " + name);
            if (!name.equals("")) {main.eventManager.prepEvent("Four", 9003, 3);}
        } catch (Exception e) {}

        try {
            SharedPreferences one = main.getSharedPreferences("Five", 0);
            String name = one.getString("name", "");
            main.appendText("\n\n5. " + name);
            if (!name.equals("")) {main.eventManager.prepEvent("Five", 9003, 4);}
        } catch (Exception e) {}

        try {
            SharedPreferences one = main.getSharedPreferences("Six", 0);
            String name = one.getString("name", "");
            main.appendText("\n\n6. " + name);
            if (!name.equals("")) {main.eventManager.prepEvent("Six", 9003, 5);}
        } catch (Exception e) {}

        try {
            SharedPreferences one = main.getSharedPreferences("Seven", 0);
            String name = one.getString("name", "");
            main.appendText("\n\n7. " + name);
            if (!name.equals("")) {main.eventManager.prepEvent("Seven", 9003, 6);}
        } catch (Exception e) {}

        try {
            SharedPreferences one = main.getSharedPreferences("Eight", 0);
            String name = one.getString("name", "");
            main.appendText("\n\n8. " + name);
            if (!name.equals("")) {main.eventManager.prepEvent("Eight", 9003, 7);}
        } catch (Exception e) {}

        try {
            SharedPreferences one = main.getSharedPreferences("Nine", 0);
            String name = one.getString("name", "");
            main.appendText("\n\n9. " + name);
            main.submitText();
            if (!name.equals("")) {main.eventManager.prepEvent("Nine", 9003, 8);}
        } catch (Exception e) {}

        if(main.flags.mainMenu){
            main.eventManager.prepEvent("Back", 8008, 9);} else {main.eventManager.prepEvent("Back", 11111, 9);}
        main.ui.toggleButtons(2);

    }

    //eLevel, ePhysique, eIntellect, eAgility, eQuickness, eCharisma, eLuck, eLi, eMaxHealth, eHealth, eMaxMana, eMana, eMaxFatigue, eFatigue, eLu, eMinLu, eExperience, eExpToLvl;
    public void loadGameSlot(){ // ID 9003
        System.out.println("LOADGAMESLOT from SaveLoad here!");
        String which = main.eventManager.getEventChoice();
        SharedPreferences sp = main.getSharedPreferences(which, 0);
        Gson gson = new Gson();

        // Stats
        main.player.seteName(sp.getString("name", "null"));
        main.player.seteGender(sp.getString("gender", "null"));
        main.player.seteClass(sp.getString("class", "null"));
        main.player.seteRace(sp.getString("race", "null"));
        main.player.seteFaction(sp.getString("faction", "null"));
        main.player.seteLevel(sp.getInt("level", 0));
        main.player.setePhysique(sp.getInt("physique", 0));
        main.player.seteIntellect(sp.getInt("intellect", 0));
        main.player.seteAgility(sp.getInt("agility", 0));
        main.player.seteQuickness(sp.getInt("quickness", 0));
        main.player.seteCharisma(sp.getInt("charisma", 0));
        main.player.seteLuck(sp.getInt("luck", 0));
        main.player.seteLi(sp.getInt("li", 0));
        main.player.seteMaxHealth(sp.getInt("maxHealth", 0));
        main.player.seteHealth(sp.getInt("health", 0));
        main.player.seteMaxMana(sp.getInt("maxMana", 0));
        main.player.seteMana(sp.getInt("mana", 0));
        main.player.seteMaxFatigue(sp.getInt("maxFatigue", 0));
        main.player.seteFatigue(sp.getInt("fatigue", 0));
        main.player.seteLu(sp.getInt("lu", 0));
        main.player.seteMinLu(sp.getInt("minLu", 0));
        main.player.seteExperience(sp.getInt("experience", 0));
        main.player.seteExpToLvl(sp.getInt("expToLvl", 0));
        main.ui.updateStatsAll(main.player);

        // Inventory
        main.player.setInventory(new Inventory());
        Type typer = new TypeToken<List<String>>(){}.getType();
        Type typers = new TypeToken<List<Integer>>(){}.getType();

        String invUno = sp.getString("invName", null);
        Type type = new TypeToken<List<String>>(){}.getType();
        List<String> inputIName = gson.fromJson(invUno, type);

        String invDos = sp.getString("invType", null);
        List<String> inputIType = gson.fromJson(invDos, typer);

        String invTres = sp.getString("invAmount", null);
        List<Integer> inputIAmount = gson.fromJson(invTres, typers);

        int i = 0;
        while(i < inputIName.size()){
            try {
                main.player.getInventory().setInvItem(main.player, i, new Item(inputIName.get(i), inputIType.get(i), inputIAmount.get(i)));
                System.out.println("Created new Item");
            } catch (Exception e) {}
            i++;
        }


        main.appendText("Done!");
        main.submitText();

        main.ui.toggleButtons(1);
        main.eventManager.clrEventList();
        main.eventManager.prepEvent("Done", 11111, 0);
        main.ui.toggleButtons(2);
    }

    public void deleteSave(){ // ID 9004
        System.out.println("DELETESAVESLOT from SaveLoad here!");

        main.appendText("Which slot do you want to delete?");
        main.submitText();
        main.appendInfo("CANNOT BE UNDONE!");
        main.submitInfo();

        main.ui.toggleButtons(1);
        main.eventManager.clrEventList();
        main.eventManager.prepEvent("One", 9005, 0);
        main.eventManager.prepEvent("Two", 9005, 1);
        main.eventManager.prepEvent("Three", 9005, 2);
        main.eventManager.prepEvent("Four", 9005, 3);
        main.eventManager.prepEvent("Five", 9005, 4);
        main.eventManager.prepEvent("Six", 9005, 5);
        main.eventManager.prepEvent("Seven", 9005, 6);
        main.eventManager.prepEvent("Eight", 9005, 7);
        main.eventManager.prepEvent("Nine", 9005, 8);
        main.eventManager.prepEvent("Back", 8008, 9);
        main.ui.toggleButtons(2);

    }

    public void deleteSaveSlot(){ // ID 9005
        System.out.println("DELETESAVESLOT from SaveLoad here!");
        String which = main.eventManager.getEventChoice();

        SharedPreferences sp = main.getSharedPreferences(which, 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear().commit();

        main.appendText("Cleared slot " + which);
        main.submitText();

        main.ui.toggleButtons(1);
        main.eventManager.clrEventList();
        main.eventManager.prepEvent("Done", 8008, 0);
        main.ui.toggleButtons(2);
    }

}
