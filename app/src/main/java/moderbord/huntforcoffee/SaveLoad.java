package moderbord.huntforcoffee;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import moderbord.huntforcoffee.GameFunctions.Inventory;
import moderbord.huntforcoffee.GameFunctions.Item;

/**
 * Created by Moderbord on 2015-12-13.
 */
public class SaveLoad {

    protected MainActivity main;
    public SaveLoad(Context context){this.main = (MainActivity) context;}

    Entity entityList[];

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
        if(main.flags.activeGame){main.eventManager.prepEvent("Continue", 11111, 4);}
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
        main.appendInfo("");
        main.submitInfo();

        main.ui.toggleButtons(1);
        main.eventManager.clrEventList();
        try {
            SharedPreferences one = main.getSharedPreferences("One", 0);
            String name = one.getString("0", "");
            main.appendText("\n\n1. " + name);
            main.eventManager.prepEvent("One", 9001, 0);
        } catch (Exception e) {}

        try {
            SharedPreferences one = main.getSharedPreferences("Two", 0);
            String name = one.getString("0", "");
            main.appendText("\n\n2. " + name);
            main.eventManager.prepEvent("Two", 9001, 1);
        } catch (Exception e) {}

        try {
            SharedPreferences one = main.getSharedPreferences("Three", 0);
            String name = one.getString("0", "");
            main.appendText("\n\n3. " + name);
            main.eventManager.prepEvent("Three", 9001, 2);
        } catch (Exception e) {}

        try {
            SharedPreferences one = main.getSharedPreferences("Four", 0);
            String name = one.getString("0", "");
            main.appendText("\n\n4. " + name);
            main.eventManager.prepEvent("Four", 9001, 3);
        } catch (Exception e) {}

        try {
            SharedPreferences one = main.getSharedPreferences("Five", 0);
            String name = one.getString("0", "");
            main.appendText("\n\n5. " + name);
            main.eventManager.prepEvent("Five", 9001, 4);
        } catch (Exception e) {}

        try {
            SharedPreferences one = main.getSharedPreferences("Six", 0);
            String name = one.getString("0", "");
            main.appendText("\n\n6. " + name);
            main.eventManager.prepEvent("Six", 9001, 5);
        } catch (Exception e) {}

        try {
            SharedPreferences one = main.getSharedPreferences("Seven", 0);
            String name = one.getString("0", "");
            main.appendText("\n\n7. " + name);
            main.eventManager.prepEvent("Seven", 9001, 6);
        } catch (Exception e) {}

        try {
            SharedPreferences one = main.getSharedPreferences("Eight", 0);
            String name = one.getString("0", "");
            main.appendText("\n\n8. " + name);
            main.eventManager.prepEvent("Eight", 9001, 7);
        } catch (Exception e) {}

        try {
            SharedPreferences one = main.getSharedPreferences("Nine", 0);
            String name = one.getString("0", "");
            main.appendText("\n\n9. " + name);
            main.submitText();
            main.eventManager.prepEvent("Nine", 9001, 8);
        } catch (Exception e) {}
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

        entityList = new Entity[5];

        loadToEntityList(main.player);
        int x = 0;
        for(Entity entity: entityList){
            if(entity != null){
                // Stats
                editor.putString(""+Integer.toString(x), entity.geteName());
                editor.putString("gender"+entity.geteName(), entity.geteGender());
                editor.putString("class"+entity.geteName(), entity.geteClass());
                editor.putString("race"+entity.geteName(), entity.geteRace());
                editor.putString("faction"+entity.geteName(), entity.geteFaction());
                editor.putInt("level"+entity.geteName(), entity.geteLevel());
                editor.putInt("physique"+entity.geteName(), entity.getePhysique());
                editor.putInt("intellect"+entity.geteName(), entity.geteIntellect());
                editor.putInt("agility"+entity.geteName(), entity.geteAgility());
                editor.putInt("quickness"+entity.geteName(), entity.geteQuickness());
                editor.putInt("charisma"+entity.geteName(), entity.geteCharisma());
                editor.putInt("luck"+entity.geteName(), entity.geteLuck());
                editor.putInt("li"+entity.geteName(), entity.geteLi());
                editor.putInt("maxHealth"+entity.geteName(), entity.geteMaxHealth());
                editor.putInt("health"+entity.geteName(), entity.geteHealth());
                editor.putInt("maxMana"+entity.geteName(), entity.geteMaxMana());
                editor.putInt("mana"+entity.geteName(), entity.geteMana());
                editor.putInt("maxFatigue"+entity.geteName(), entity.geteMaxFatigue());
                editor.putInt("fatigue"+entity.geteName(), entity.geteFatigue());
                editor.putInt("lu"+entity.geteName(), entity.geteLu());
                editor.putInt("minLu"+entity.geteName(), entity.geteMinLu());
                editor.putInt("experience"+entity.geteName(), entity.geteExperience());
                editor.putInt("expToLvl"+entity.geteName(), entity.geteExpToLvl());

                // Inventory
                List<String> iName = new ArrayList<String>(5);
                List<String> iType = new ArrayList<String>(5);
                List<Integer> iAmount = new ArrayList<Integer>(5);
                int i = 0;
                while(i < 5){
                    try {
                        iName.add(i, entity.getInventory().getInvItem(entity, i).getiName());
                        iType.add(i, entity.getInventory().getInvItem(entity, i).getType());
                        iAmount.add(i, entity.getInventory().getInvItem(entity, i).getAmount());
                        System.out.println("Added " + iAmount.get(i) + " " + iType.get(i) + " " + iName.get(i) + " to " + i);
                    } catch (Exception e) {}
                    i++;
                }
                String invName = gson.toJson(iName);
                String InvType = gson.toJson(iType);
                String InvAmount = gson.toJson(iAmount);
                editor.putString("invName"+entity.geteName(), invName);
                editor.putString("invType"+entity.geteName(), InvType);
                editor.putString("invAmount"+entity.geteName(), InvAmount);
            }
            x++;
        }
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
            String name = one.getString("0", "");
            main.appendText("\n\n1. " + name);
            if (!name.equals("")) {main.eventManager.prepEvent("One", 9003, 0);}
        } catch (Exception e) {}

        try {
            SharedPreferences one = main.getSharedPreferences("Two", 0);
            String name = one.getString("0", "");
            main.appendText("\n\n2. " + name);
            if (!name.equals("")) {main.eventManager.prepEvent("Two", 9003, 1);}
        } catch (Exception e) {}

        try {
            SharedPreferences one = main.getSharedPreferences("Three", 0);
            String name = one.getString("0", "");
            main.appendText("\n\n3. " + name);
            if (!name.equals("")) {main.eventManager.prepEvent("Three", 9003, 2);}
        } catch (Exception e) {}

        try {
            SharedPreferences one = main.getSharedPreferences("Four", 0);
            String name = one.getString("0", "");
            main.appendText("\n\n4. " + name);
            if (!name.equals("")) {main.eventManager.prepEvent("Four", 9003, 3);}
        } catch (Exception e) {}

        try {
            SharedPreferences one = main.getSharedPreferences("Five", 0);
            String name = one.getString("0", "");
            main.appendText("\n\n5. " + name);
            if (!name.equals("")) {main.eventManager.prepEvent("Five", 9003, 4);}
        } catch (Exception e) {}

        try {
            SharedPreferences one = main.getSharedPreferences("Six", 0);
            String name = one.getString("0", "");
            main.appendText("\n\n6. " + name);
            if (!name.equals("")) {main.eventManager.prepEvent("Six", 9003, 5);}
        } catch (Exception e) {}

        try {
            SharedPreferences one = main.getSharedPreferences("Seven", 0);
            String name = one.getString("0", "");
            main.appendText("\n\n7. " + name);
            if (!name.equals("")) {main.eventManager.prepEvent("Seven", 9003, 6);}
        } catch (Exception e) {}

        try {
            SharedPreferences one = main.getSharedPreferences("Eight", 0);
            String name = one.getString("0", "");
            main.appendText("\n\n8. " + name);
            if (!name.equals("")) {main.eventManager.prepEvent("Eight", 9003, 7);}
        } catch (Exception e) {}

        try {
            SharedPreferences one = main.getSharedPreferences("Nine", 0);
            String name = one.getString("0", "");
            main.appendText("\n\n9. " + name);
            main.submitText();
            if (!name.equals("")) {main.eventManager.prepEvent("Nine", 9003, 8);}
        } catch (Exception e) {}

        if(main.flags.mainMenu){
            main.eventManager.prepEvent("Back", 8008, 9);} else {main.eventManager.prepEvent("Back", 11111, 9);}
        main.ui.toggleButtons(2);

    }

    public void loadGameSlot(){ // ID 9003
        System.out.println("LOADGAMESLOT from SaveLoad here!");
        String which = main.eventManager.getEventChoice();
        SharedPreferences sp = main.getSharedPreferences(which, 0);
        Gson gson = new Gson();

        Entity tempEntity;

        for (int i = 0; i < 5; i++) {
            String name = sp.getString(""+Integer.toString(i), "null");
            if (!name.equals("null")) {
                if(name.equals("Jheero")){
                    main.entityInitiator.initJheero();
                    tempEntity = main.jheero;
                } else {
                    tempEntity = main.player;
                }
                // Stats
                tempEntity.seteName(sp.getString("" + Integer.toString(i), "null"));
                tempEntity.seteGender(sp.getString("gender" + name, "null"));
                tempEntity.seteClass(sp.getString("class" + name, "null"));
                tempEntity.seteRace(sp.getString("race" + name, "null"));
                tempEntity.seteFaction(sp.getString("faction" + name, "null"));
                tempEntity.seteLevel(sp.getInt("level" + name, 0));
                tempEntity.setePhysique(sp.getInt("physique" + name, 0));
                tempEntity.seteIntellect(sp.getInt("intellect" + name, 0));
                tempEntity.seteAgility(sp.getInt("agility" + name, 0));
                tempEntity.seteQuickness(sp.getInt("quickness" + name, 0));
                tempEntity.seteCharisma(sp.getInt("charisma" + name, 0));
                tempEntity.seteLuck(sp.getInt("luck" + name, 0));
                tempEntity.seteLi(sp.getInt("li" + name, 0));
                tempEntity.seteMaxHealth(sp.getInt("maxHealth" + name, 0));
                tempEntity.seteHealth(sp.getInt("health" + name, 0));
                tempEntity.seteMaxMana(sp.getInt("maxMana" + name, 0));
                tempEntity.seteMana(sp.getInt("mana" + name, 0));
                tempEntity.seteMaxFatigue(sp.getInt("maxFatigue" + name, 0));
                tempEntity.seteFatigue(sp.getInt("fatigue" + name, 0));
                tempEntity.seteLu(sp.getInt("lu" + name, 0));
                tempEntity.seteMinLu(sp.getInt("minLu" + name, 0));
                tempEntity.seteExperience(sp.getInt("experience" + name, 0));
                tempEntity.seteExpToLvl(sp.getInt("expToLvl" + name, 0));

                // Inventory
                tempEntity.setInventory(new Inventory());

                String invUno = sp.getString("invName"+name, null);
                Type type = new TypeToken<List<String>>(){}.getType();
                List<String> inputIName = gson.fromJson(invUno, type);

                String invDos = sp.getString("invType"+name, null);
                Type typer = new TypeToken<List<String>>(){}.getType();
                List<String> inputIType = gson.fromJson(invDos, typer);

                String invTres = sp.getString("invAmount"+name, null);
                Type typers = new TypeToken<List<Integer>>(){}.getType();
                List<Integer> inputIAmount = gson.fromJson(invTres, typers);

                int z = 0;
                while(z < inputIName.size()){
                    try {
                        tempEntity.getInventory().setInvItem(tempEntity, z, new Item(inputIName.get(z), inputIType.get(z), inputIAmount.get(z)));
                        System.out.println("Created new Item");
                    } catch (Exception e) {}
                    z++;
                }
            }
        }

        main.ui.updateStatsAll(main.player);

        main.appendText("Done!");
        main.submitText();

        main.ui.toggleButtons(1);
        main.eventManager.clrEventList();
        main.eventManager.prepEvent("Done", 11111, 0);
        main.ui.toggleButtons(2);
        main.flags.activeGame = true;
    }

    public void deleteSave(){ // ID 9004
        System.out.println("DELETESAVESLOT from SaveLoad here!");

        main.appendText("Which slot do you want to delete?");
        main.appendInfo("CANNOT BE UNDONE!");
        main.submitInfo();

        main.ui.toggleButtons(1);
        main.eventManager.clrEventList();
        try {
            SharedPreferences one = main.getSharedPreferences("One", 0);
            String name = one.getString("0", "");
            main.appendText("\n\n1. " + name);
            if (!name.equals("")) {main.eventManager.prepEvent("One", 9005, 0);}
        } catch (Exception e) {}

        try {
            SharedPreferences one = main.getSharedPreferences("Two", 0);
            String name = one.getString("0", "");
            main.appendText("\n\n2. " + name);
            if (!name.equals("")) {main.eventManager.prepEvent("Two", 9005, 1);}
        } catch (Exception e) {}

        try {
            SharedPreferences one = main.getSharedPreferences("Three", 0);
            String name = one.getString("0", "");
            main.appendText("\n\n3. " + name);
            if (!name.equals("")) {main.eventManager.prepEvent("Three", 9005, 2);}
        } catch (Exception e) {}

        try {
            SharedPreferences one = main.getSharedPreferences("Four", 0);
            String name = one.getString("0", "");
            main.appendText("\n\n4. " + name);
            if (!name.equals("")) {main.eventManager.prepEvent("Four", 9005, 3);}
        } catch (Exception e) {}

        try {
            SharedPreferences one = main.getSharedPreferences("Five", 0);
            String name = one.getString("0", "");
            main.appendText("\n\n5. " + name);
            if (!name.equals("")) {main.eventManager.prepEvent("Five", 9005, 4);}
        } catch (Exception e) {}

        try {
            SharedPreferences one = main.getSharedPreferences("Six", 0);
            String name = one.getString("0", "");
            main.appendText("\n\n6. " + name);
            if (!name.equals("")) {main.eventManager.prepEvent("Six", 9005, 5);}
        } catch (Exception e) {}

        try {
            SharedPreferences one = main.getSharedPreferences("Seven", 0);
            String name = one.getString("0", "");
            main.appendText("\n\n7. " + name);
            if (!name.equals("")) {main.eventManager.prepEvent("Seven", 9005, 6);}
        } catch (Exception e) {}

        try {
            SharedPreferences one = main.getSharedPreferences("Eight", 0);
            String name = one.getString("0", "");
            main.appendText("\n\n8. " + name);
            if (!name.equals("")) {main.eventManager.prepEvent("Eight", 9005, 7);}
        } catch (Exception e) {}

        try {
            SharedPreferences one = main.getSharedPreferences("Nine", 0);
            String name = one.getString("0", "");
            main.appendText("\n\n9. " + name);
            main.submitText();
            if (!name.equals("")) {main.eventManager.prepEvent("Nine", 9005, 8);}
        } catch (Exception e) {}
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

    private void loadToEntityList(Entity entity) {
        for(int i = 0; i < entityList.length; i++){
            if(entityList[i] == null){
                entityList[i] = entity;
            } else {
                return;
            }
        }
    }

}
